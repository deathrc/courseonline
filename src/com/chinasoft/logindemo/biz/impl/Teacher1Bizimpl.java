package com.chinasoft.logindemo.biz.impl;

import com.chinasoft.logindemo.biz.Teacher1Biz;
import com.chinasoft.logindemo.dao.Teacher1Dao;
import com.chinasoft.logindemo.dao.impl.Teacher1Daoimpl;
import com.chinasoft.logindemo.po.Teacher1;

public class Teacher1Bizimpl implements Teacher1Biz {

	Teacher1Dao teacher1Dao=new Teacher1Daoimpl();
	@Override
	public Teacher1 findthinfo(String th_ID) {
		// TODO Auto-generated method stub
		return teacher1Dao.findthinfo(th_ID);
	}

}
