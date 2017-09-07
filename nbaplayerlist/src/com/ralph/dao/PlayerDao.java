package com.ralph.dao;

import java.util.List;
import java.io.IOException;
//import java.lang.reflect.Array;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.ralph.bean.Player;
import com.ralph.db.DBAccess;


public class PlayerDao {
	
	/**
	 * Search player list according to input parameters using MyBatis
	 */
	public List<Player> queryPlayerList(String name, String team) {

		List<Player> pList=new ArrayList<Player>();
		
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			//Instantiate an instance of Player to pass in parameter values(more than one value -- name/team) 
			Player player=new Player();
			player.setName(name);
			player.setTeam(team);
			
			//Get SqlSession
			sqlSession=dbAccess.getSqlSession();
			//Run sql command using SqlSession
			pList=sqlSession.selectList("Player.queryPlayerList",player);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
		return pList;
	}
	
	
	/*
	 * Delete one player in the list
	 */
	public void deleteOne(int id) {

		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			//Get SqlSession
			sqlSession=dbAccess.getSqlSession();
			//Run sql command using SqlSession
			sqlSession.delete("Player.deleteOne", id);
			sqlSession.commit();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
		
	}
	
	
	/*
	 * Delete multiple players in the list
	 */
	public void deleteBatch(List<Integer> ids) {

		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			//Get SqlSession
			sqlSession=dbAccess.getSqlSession();
			//Run sql command using SqlSession
			sqlSession.delete("Player.deleteBatch", ids);
			sqlSession.commit();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
		
	}
	
	/*
	 * Add one player in the list
	 */
	public void addOne(String name, String team, String number) {

		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		
		try {
			//Instantiate an instance of Player to add
			Player player=new Player();
			player.setName(name);
			player.setTeam(team);
			player.setNumber(number);
			
			//Get SqlSession
			sqlSession=dbAccess.getSqlSession();
			
			//Run sql command using SqlSession
			sqlSession.insert("Player.addOne", player);
			sqlSession.commit();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
		
	}
	
//	public static void main(String[] args) {
//		PlayerDao playerDao=new PlayerDao();
//		playerDao.queryPlayerList("", "");
//		
//	}
	
//	/**
//	 * Search player list according to input parameters using JDBC
//	 */
//	public ArrayList<Player> queryPlayerList(String name, String team) {
//		
//		ArrayList<Player> playerList = new ArrayList<Player>();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/players","root","123456");
//			StringBuilder sql = new StringBuilder("select ID,NAME,TEAM,NUMBER from PLAYERINFO where 1=1");
//			ArrayList<String> paramList = new ArrayList<String>(); 
//			
//			if (name!=null && !"".equals(name.trim())) {
//				sql.append(" and NAME like '%' ? '%'");
//				paramList.add(name);
//			}
//			if (team!=null && !"".equals(team.trim())) {
//				sql.append(" and TEAM like '%' ? '%'");
//				paramList.add(team);
//			}
//		
//			PreparedStatement statement = connection.prepareStatement(sql.toString());
//			for (int i=0; i<paramList.size(); i++) {
//				statement.setString(i+1, paramList.get(i));
//			}
//	
//			ResultSet rSet = statement.executeQuery();
//
//			while (rSet.next()) {
//				Player player = new Player();
//				player.setId(rSet.getString("ID"));
//				player.setName(rSet.getString("NAME"));
//				player.setTeam(rSet.getString("TEAM"));
//				player.setNumber(rSet.getString("NUMBER"));
//				
//				playerList.add(player);
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return playerList;
//	}
}
