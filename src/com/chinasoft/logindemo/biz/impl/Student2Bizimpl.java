package com.chinasoft.logindemo.biz.impl;

import com.chinasoft.logindemo.biz.Student2Biz;
import com.chinasoft.logindemo.dao.Student2Dao;
import com.chinasoft.logindemo.dao.impl.Student2Daoimpl;
import com.chinasoft.logindemo.po.Student2;

public class Student2Bizimpl implements Student2Biz {
	private Student2Dao userdao=new Student2Daoimpl();
	public Student2 userLogin(String username,String password)
	{
		return userdao.findUserByUsernameAndPassword(username, password);
	}
	@Override
	public String findNameByStID(String st_ID) {
		// TODO Auto-generated method stub
		return userdao.findNameByStID(st_ID);
	}
	
}



	
