package com.chinasoft.logindemo.biz.impl;

import com.chinasoft.logindemo.biz.Student1Biz;
import com.chinasoft.logindemo.dao.Student1Dao;
import com.chinasoft.logindemo.dao.impl.Student1Daoimpl;
import com.chinasoft.logindemo.po.Student1;

public class Student1Bizimpl implements Student1Biz {

	Student1Dao stDao=new Student1Daoimpl();
	@Override
	public Student1 findStudentByStID(String st_ID) {
		// TODO Auto-generated method stub
		return stDao.findStudentByStID(st_ID);
	}

}
