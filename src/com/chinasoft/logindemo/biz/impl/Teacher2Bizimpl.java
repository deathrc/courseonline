package com.chinasoft.logindemo.biz.impl;

import java.util.List;

import com.chinasoft.logindemo.biz.Teacher2Biz;
import com.chinasoft.logindemo.dao.Teacher2Dao;
import com.chinasoft.logindemo.dao.impl.Teacher2Daoimpl;
import com.chinasoft.logindemo.po.C_course;
import com.chinasoft.logindemo.po.Teacher2;
import com.chinasoft.logindemo.vo.C_coursePageBean;
import com.chinasoft.logindemo.vo.Teacher2PageBean;

public class Teacher2Bizimpl implements Teacher2Biz {

	Teacher2Dao teacher2Dao=new Teacher2Daoimpl();
	@Override
	public List<Teacher2> findAllTeachers() {
		// TODO Auto-generated method stub
		return teacher2Dao.findAllTeachers();
	}

	@Override
	public String getThnameByThID(String th_id) {
		// TODO Auto-generated method stub
		return teacher2Dao.findThnameByThID(th_id);
	}

	@Override
	public Teacher2PageBean getTeacger2sByPage(int pagesize, int currentpage) {
		// TODO Auto-generated method stub
				int rowcount=teacher2Dao.getTeacher2Count();
				int pagecount=rowcount%pagesize==0?rowcount/pagesize:rowcount/pagesize+1;
				List<Teacher2> data=teacher2Dao.findTeacher2sByPage(pagesize, currentpage);
				Teacher2PageBean teacher2PageBean=new Teacher2PageBean();
				teacher2PageBean.setCurrpage(currentpage);
				teacher2PageBean.setPagesize(pagesize);
				teacher2PageBean.setRowcount(rowcount);
				teacher2PageBean.setPagecount(pagecount);
				teacher2PageBean.setDate(data);
				return teacher2PageBean;
	}

	@Override
	public Teacher2 findUserByUsernameAndPassword(String username,
			String password) {
		// TODO Auto-generated method stub
		return teacher2Dao.findUserByUsernameAndPassword(username, password);
	}

}
