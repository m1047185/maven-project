package com.mindtree.WebApp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
public class ImplementationDEOTeam implements MatchDAO 
{
	Connection con=utility.createConnnection();
	public void display() throws SQLException
	{
		Statement statement=con.createStatement();
		ResultSet res=statement.executeQuery("select * from team");
		while(res.next())
		{
			System.out.println(res.getString("teamName")+"        "+res.getString("teamId"));
		}
	}
	
	@Autowired
	public void insertValues(String matchDate, int firstTeamScore, int secondTeamScore, String firstTeam,
			String secondTeam) throws SQLException 
	{
		Statement statement=con.createStatement();
		statement.executeUpdate("insert into match1(matchDate,firstTeamScore,SecondTeamScore,firstTeam,SecondTeam) values ('"+matchDate+"','"+firstTeamScore+"','"+secondTeamScore+"','"+firstTeam+"','"+secondTeam+"')");
	}
	public ArrayList<String> check(String s) throws SQLException 
	{	
		ArrayList<String> list=new ArrayList<String>();
		Statement statement=con.createStatement();
		ResultSet res=statement.executeQuery("select * from match1 where firstTeam='"+s+"'" );
		while(res.next())
		{
			String d=res.getString("matchDate");
			String temp=d.substring(8,10)+d.substring(4,8)+d.substring(0,4)+d.substring(10,d.length());
			list.add(temp);
			list.add("         ");
			String st=res.getString("secondTeam");
			list.add(st);
			list.add("         ");
			int c=res.getInt("firstTeamScore");
			String a1=Integer.toString(c);
			list.add(a1);
			list.add("        -- ");
			int e=res.getInt("secondTeamScore");
			String a2=Integer.toString(e);

			list.add(a2);
			list.add("         ");
			list.add("    ");
			//System.out.println(temp+"       "+res.getString("secondTeam")+"        "+res.getInt("firstTeamScore")+"-"+res.getInt("secondTeamScore"));

			list.add("<br><br>");
		}
		ResultSet res1=statement.executeQuery("select * from match1 where secondTeam='"+s+"'");
		while(res1.next())
		{
			String z=res1.getString("matchDate");
			String temp1=z.substring(8,10)+z.substring(4,8)+z.substring(0,4)+z.substring(10,z.length());
			list.add(temp1);
			list.add("         ");
			String str=res1.getString("firstTeam");
			list.add(str);
			list.add("         ");
			int x=res1.getInt("firstTeamScore");
			String b1=Integer.toString(x);
			list.add(b1);
			list.add("       --  ");
			int y=res1.getInt("secondTeamScore");
			String b2=Integer.toString(y);
			list.add(b2);
			list.add("         ");
			//System.out.println(temp1+"     "+res1.getString("firstTeam")+ "         "+res1.getInt("firstTeamScore")+"-"+res1.getInt("secondTeamScore"));
			//String b1=Integer.toString(res.getInt("firstTeamScore"));
			//String b2=Integer.toString(res.getInt("secondTeamScore"));
			//System.out.println(temp+"       "+res.getString("secondTeam")+"        "+res.getInt("firstTeamScore")+"-"+res.getInt("secondTeamScore"));
			list.add("<br><br>");
		}
		
		//for(String obj:list)
		//{
			//System.out.println(obj);
		//}
		return list;
	}

	public int checkt(String t1) throws SQLException 
	{
		Statement statement=con.createStatement();
		ResultSet res=statement.executeQuery("select * from team where teamName='"+t1+"'");
		if(res.next())
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}
