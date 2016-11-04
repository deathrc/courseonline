package com.chinasoft.logindemo.dao;

import java.util.List;

import com.chinasoft.logindemo.po.C_course;
import com.chinasoft.logindemo.po.Student2;
import com.chinasoft.logindemo.po.Teacher2;

public interface Teacher2Dao {

	Teacher2 findUserByUsernameAndPassword(String username,String password);
	List<Teacher2> findAllTeachers();
	String findThnameByThID(String th_id);
	List<Teacher2> findTeacher2sByPage(int pagesize,int currpage);
	int getTeacher2Count();
}
