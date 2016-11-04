package com.chinasoft.logindemo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasoft.logindemo.dao.Student1Dao;
import com.chinasoft.logindemo.dbutil.DBHelper;
import com.chinasoft.logindemo.po.Student1;

public class Student1Daoimpl implements Student1Dao {

	private DBHelper dbHelper =new DBHelper();
	@Override
	public Student1 findStudentByStID(String st_ID) {
		String sql="select * from student1 where st_ID=?";		
		//执行sql语句
		ResultSet rst=dbHelper.execQuery(sql,st_ID);
		//把结果集resultset转为list
		try {
			
			if(rst.next()){
				Student1 student=new Student1();
				student.setSt_ID(rst.getString(1));

				student.setGender(rst.getString(2));
				student.setCity(rst.getString(3));
				rst.close();
				return student;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{dbHelper.closeAll();}
		return null;
	}

}
