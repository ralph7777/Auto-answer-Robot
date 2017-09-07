package com.ralph.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ralph.bean.Team;
import com.ralph.db.DBAccess;

public class TeamDao {
	
	/**
	 * Query team list
	 * @param name
	 * @param fullname
	 * @return
	 */
	public List<Team> queryTeamList(String name, String fullname) {

		List<Team> tList=new ArrayList<Team>();
		
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			//Instantiate an instance of Team to pass in parameter values
			Team team=new Team();
			team.setName(name);
			team.setFullname(fullname);
			
			//Get SqlSession
			sqlSession=dbAccess.getSqlSession();
			//Run sql command using SqlSession
			tList=sqlSession.selectList("Team.queryTeamList",team);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
		return tList;
	}
}
