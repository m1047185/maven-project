package com.mindtree.WebApp;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@CrossOrigin
public class HomeController {
	private String stm;

	@RequestMapping(value = "/demo", method = RequestMethod.POST)

	public @ResponseBody ArrayList<String> teamt11(@RequestBody match t) {
		ImplementationDEOTeam im = new ImplementationDEOTeam();
		match m=new match();
		ArrayList<String>list=new ArrayList<String>();
		String s1 = t.getName1();
		if(!m.checkTeam(s1).equals("OK"))
		{
			list.add(m.checkTeam(s1));
			return list;
		}
		String s2 = t.getName2();
		if(!m.checkTeam(s2).equals("OK"))
		{
			list.add(m.checkTeam(s2));
			return list;
		}
		String s3 = t.getName3();
		if(!m.checkdate(s3).equals("OK"))
		{
			list.add(m.checkdate(s3));
			return list;
		}
		String madate = s3.substring(6, 10) + s3.substring(2, 6) + s3.substring(0, 2) + s3.substring(10, s3.length());
		
		String s4 = t.getName4();
		String s5 = t.getName5();
		int a = Integer.parseInt(s4);
		if(!m.checkgoal(a).equals("OK"))
		{
			list.add(m.checkgoal(a));
			return list;
		}
		int b = Integer.parseInt(s5);
		if(!m.checkgoal(a).equals("OK"))
		{
			list.add(m.checkgoal(a));
			return list;
		}
		
		try {
			im.insertValues(madate, a, b, s1, s2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list.add(" Data  Succesfully Inserted  ");
		return list;
	}

	@RequestMapping(value = "/demos", method = RequestMethod.POST)
	public @ResponseBody ArrayList<String> teamt1(@RequestBody match m) {
		ArrayList<String> list1 = new ArrayList<String>();
		ImplementationDEOTeam i = new ImplementationDEOTeam();
		stm = m.getTname();
		System.out.println(stm);
		try {
			list1 = i.check(stm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list1;

	}
}
