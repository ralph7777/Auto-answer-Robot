package com.ralph.service;


import java.util.List;
import java.util.Random;

import com.ralph.bean.Player;
import com.ralph.bean.Team;
import com.ralph.bean.TeamInfo;
import com.ralph.dao.PlayerDao;
import com.ralph.dao.TeamDao;
import com.ralph.util.*;

/**
 * Business of list query 
 */
public class QueryService {
	
	/**
	 * Query list according to input name and team
	 * @param name
	 * @param team
	 * @return
	 */
	public List<Player> queryPlayerList(String name, String team) {
		PlayerDao playerDao = new PlayerDao();
		return playerDao.queryPlayerList(name, team);
	}
	
	/**
	 * Query list according to user's input name
	 * @param name
	 * @return
	 */
	public String queryByName(String name) {
		PlayerDao playerDao = new PlayerDao();
		List<Player> playerList;
		
		//Reply to HELP input, show all players' name
		if (Iconst.HELP_COMMAND_P.equals(name)) {
			playerList=playerDao.queryPlayerList(null, null);
			StringBuilder result=new StringBuilder();
			for (int i=0; i<playerList.size(); i++) {
				if (i != 0) {
					result.append("<br/>");
				}
				result.append(playerList.get(i).getName());
			}
			return result.toString();
		}
		
		//Query list
		playerList=playerDao.queryPlayerList(name, null);
		if (playerList.size()>0) {
			StringBuilder result=new StringBuilder();
			
			for (int i=0; i<playerList.size(); i++) {
				if (i != 0) {
					result.append("<br/>");
				}
				result.append("Name: "+playerList.get(i).getName()+"<br/>");
				result.append("Team: "+playerList.get(i).getTeam()+"<br/>");
				result.append("Number: "+playerList.get(i).getNumber());
			}
			return result.toString();
		}
		
		return Iconst.NO_MATCHING_CONTENT;
	}
	
	
	/**
	 * Query list according to user's input team
	 * @param name
	 * @return
	 */
	public String queryByTeam(String fullname) {
		TeamDao teamDao = new TeamDao();
		List<Team> teamList;
		
		//Reply to HELP input, show all teams' name
		if (Iconst.HELP_COMMAND_T.equals(fullname)) {
			teamList=teamDao.queryTeamList(null, null);
			StringBuilder result=new StringBuilder();
			for (int i=0; i<teamList.size(); i++) {
				if (i != 0) {
					result.append("<br/>");
				}
				result.append(teamList.get(i).getFullname());
			}
			return result.toString();
		}
		
		//Query list
		teamList=teamDao.queryTeamList(null, fullname);
		if (teamList.size()>0) {
			StringBuilder result=new StringBuilder();
			result.append(teamList.get(0).getFullname()+":<br/>");
			
			List<TeamInfo> infoList=teamList.get(0).getTeamInfo();
			int i=new Random().nextInt(infoList.size());
			result.append(infoList.get(i).getInformation());
			return result.toString();
		}
		
		return Iconst.NO_MATCHING_CONTENT;
	}
	
}
