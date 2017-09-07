package com.ralph.service;

import java.util.ArrayList;
import java.util.List;

import com.ralph.dao.PlayerDao;

/*
 * Maintenance of player list
 */
public class MaintainService {

	/*
	 * Delete one record in the player list
	 */
	public void deleteOne(String id) {
		if (id!=null && !"".equals(id.trim())){
			PlayerDao playerDao=new PlayerDao();
			playerDao.deleteOne(Integer.valueOf(id));
		}
	}
	
	/*
	 * Delete multiple records in the player list
	 */
	public void deleteBatch(String[] ids) {
		if (ids==null || ids.length==0) return;
		List<Integer> idList=new ArrayList<Integer>();
		for (String id : ids) {
			idList.add(Integer.valueOf(id));
		}
		PlayerDao playerDao=new PlayerDao();
		playerDao.deleteBatch(idList);
	}
	
	/**
	 * Add a new player
	 * @param name
	 * @param team
	 * @param number
	 */
	public void addOne(String name, String team, String number) {
		PlayerDao playerDao=new PlayerDao();
		playerDao.addOne(name, team, number);
	}
	
	
}

