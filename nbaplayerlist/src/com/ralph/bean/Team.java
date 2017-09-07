package com.ralph.bean;

import java.util.List;

public class Team {
	
	private String name;
	
	private String fullname;
	
	private List<TeamInfo> teamInfoList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public List<TeamInfo> getTeamInfo() {
		return teamInfoList;
	}

	public void setTeamInfo(List<TeamInfo> teamInfo) {
		this.teamInfoList = teamInfo;
	}
	
	
	

}
