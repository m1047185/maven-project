package com.mindtree.WebApp;
public class team
{
	public String teamId;
	public String teamName;
	public team() {
		super();
		// TODO Auto-generated constructor stub
	}
	public team(String teamId, String teamName) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
		
}
