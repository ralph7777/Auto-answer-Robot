package com.ralph.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * Database Accessor
 *
 */
public class DBAccess {

	public SqlSession getSqlSession() throws IOException{
		//Get database information by configuaration.xml
		Reader reader=Resources.getResourceAsReader("com/ralph/config/Configuration.xml");

		//Build SqlSessionFactory
		SqlSessionFactory sFactory=new SqlSessionFactoryBuilder().build(reader);
		
		//Open new sql session
		SqlSession sqlSession=sFactory.openSession();
		
		return sqlSession;
	}
}
