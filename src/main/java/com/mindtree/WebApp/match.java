package com.mindtree.WebApp;

import java.sql.SQLException;




public class match 
{
	String name1;
	String name2;
	String name3;
	String name4;
	String name5;
	String tname;
	ImplementationDEOTeam it=new ImplementationDEOTeam();
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getName3() {
		return name3;
	}
	public void setName3(String name3) {
		this.name3 = name3;
	}
	public String getName4() {
		return name4;
	}
	public void setName4(String name4) {
		this.name4 = name4;
	}
	public String getName5() {
		return name5;
	}
	public void setName5(String name5) {
		this.name5 = name5;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public match(String name1, String name2, String name3, String name4, String name5, String tname) {
		super();
		this.name1 = name1;
		this.name2 = name2;
		this.name3 = name3;
		this.name4 = name4;
		this.name5 = name5;
		this.tname = tname;
	}
	public match() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String checkTeam(String s1) 
	{
		try
		{
			try {
				if(it.checkt(s1)==0)
				{
					throw new TeamDoesNotExistException();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch(TeamDoesNotExistException e2)
		{
			String r=e2.teamdnotexist();
			return r;
		}
		return "OK";
	}
	public String checkdate(String a) 
	{
		String s1=a.substring(0,2);
		String s2=a.substring(3,5);
		String s3=a.substring(6,10);
		String s4=a.substring(11,13);
		String s5=a.substring(14,16);
		String s6=a.substring(17,19);
		try
		{
			if(Integer.parseInt(s1)<=31 && Integer.parseInt(s2)<=12 && Integer.parseInt(s3)<=9999 && Integer.parseInt(s4)<=24 && Integer.parseInt(s5)<60 &&Integer.parseInt(s6)<60)
			{
			}
			else
			{
				throw new DateFormatException();
			}
		}
		catch(DateFormatException e)
		{
			String s=e.dateformat();
			return s;
		}
		return "OK";
	}
	public String checkgoal(int a) {
		try
		{
			if(a<0)
			{
				throw  new InvalidGoalException();
			}
			
		}
		catch(InvalidGoalException e1)
		{
			String g=e1.invalidgoal();
			return g;
		}
		return "OK";
	}
		
	}
			
