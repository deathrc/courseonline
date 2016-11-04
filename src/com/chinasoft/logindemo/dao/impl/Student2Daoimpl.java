package com.chinasoft.logindemo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasoft.logindemo.dao.Student2Dao;
import com.chinasoft.logindemo.dbutil.DBHelper;
import com.chinasoft.logindemo.po.Student2;

public class Student2Daoimpl implements Student2Dao {
	private DBHelper dbHelper=new DBHelper();

	@Override
	public Student2 findUserByUsernameAndPassword(String username, String password) {
		//准备sql语句
		String sql="select * from student2 where st_ID=? and password=?";
		ResultSet rst=dbHelper.execQuery(sql,username,password);
		try{
		    if(rst.next())
		 {
			Student2 user=new Student2();
			
			user.setSt_ID(rst.getString(1));
			user.setSt_name(rst.getString(2));
			user.setPassword(rst.getString(3));
			
			user.setCollege(rst.getString(4));
			user.setMajor(rst.getString(5));
			user.setGrade(rst.getString(6));
			rst.close();
			return user;
		 }
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{dbHelper.closeAll();}
		
		return null;
	}

	@Override
	public String findNameByStID(String st_ID) {
		String sql="select * from student2 where st_ID=?";
		ResultSet rst=dbHelper.execQuery(sql,st_ID);
		try{
		    if(rst.next())
		 {
			String name=rst.getString(2);
			
	
		
			return name;
		 }
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{dbHelper.closeAll();}
		
		return null;
	}

}
