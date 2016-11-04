package com.chinasoft.logindemo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasoft.logindemo.dao.Teacher1Dao;
import com.chinasoft.logindemo.dbutil.DBHelper;
import com.chinasoft.logindemo.po.Student1;
import com.chinasoft.logindemo.po.Teacher1;

public class Teacher1Daoimpl implements Teacher1Dao {

	private DBHelper dbHelper =new DBHelper();
	public Teacher1 findthinfo(String th_ID) {
		String sql="select * from teacher1 where th_ID=?";		
		//执行sql语句
		ResultSet rst=dbHelper.execQuery(sql,th_ID);
		//把结果集resultset转为list
		try {
			
			if(rst.next()){
				Teacher1 teacher1=new Teacher1();
				teacher1.setTh_ID(rst.getString(1));
				teacher1.setTh_name(rst.getString(2));
				teacher1.setGender(rst.getString(3));
				teacher1.setCity(rst.getString(4));
				rst.close();
				return teacher1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{dbHelper.closeAll();}
		return null;
	}

}
