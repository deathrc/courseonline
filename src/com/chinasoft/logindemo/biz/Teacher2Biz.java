package com.chinasoft.logindemo.biz;

import java.util.List;

import com.chinasoft.logindemo.po.Teacher2;
import com.chinasoft.logindemo.vo.C_coursePageBean;
import com.chinasoft.logindemo.vo.Teacher2PageBean;

public interface Teacher2Biz {

	List<Teacher2> findAllTeachers();
	String getThnameByThID(String th_id);
	Teacher2PageBean getTeacger2sByPage(int pagesize,int currentpage);
	Teacher2 findUserByUsernameAndPassword(String username,String password);
}
