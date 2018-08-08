package com.mindtree.WebApp;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MatchDAO 
{
	void display() throws SQLException;
	void insertValues(String matchDate,int firstTeamScore,int secondTeamScore,String firstName,String secondName) throws SQLException;
	ArrayList<String> check(String s) throws SQLException;
}
