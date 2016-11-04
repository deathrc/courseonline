package com.chinasoft.logindemo.biz.impl;

import java.util.List;

import com.chinasoft.logindemo.biz.C_courseBiz;
import com.chinasoft.logindemo.dao.C_courseDao;
import com.chinasoft.logindemo.dao.impl.C_courseDaoimpl;
import com.chinasoft.logindemo.po.C_course;
import com.chinasoft.logindemo.vo.C_coursePageBean;

public class C_courseBizimpl implements C_courseBiz {

	C_courseDao c_courseDao=new C_courseDaoimpl();
	@Override
	public List<C_course> FindCcoursesByCID(String c_id) {
		// TODO Auto-generated method stub
		return c_courseDao.findCcourseByCID(c_id);
	}

	@Override
	public List<C_course> FindCcoursesByStID(String st_id) {
		// TODO Auto-generated method stub
		return c_courseDao.findCcourseByStID(st_id);
	}

	@Override
	public C_course findCcourseByCIDSTID(String c_id, String st_id) {
		// TODO Auto-generated method stub
		return c_courseDao.findCcourseByCIDSTID(c_id, st_id);
	}

	@Override
	public boolean addCCourse(String c_id, String t_id,String st_id, float credit) {
		// TODO Auto-generated method stub
		return c_courseDao.addCCourse(c_id, t_id,st_id, credit);
	}

	@Override
	public boolean gradeCcourse(C_course ccourse, float grade) {
		// TODO Auto-generated method stub
		return c_courseDao.gradeCcourse(ccourse, grade);
	}

	@Override
	public C_coursePageBean getC_coursesByPage(int pagesize, int currentpage) {
		// TODO Auto-generated method stub
		int rowcount=c_courseDao.getC_courseCount();
		int pagecount=rowcount%pagesize==0?rowcount/pagesize:rowcount/pagesize+1;
		List<C_course> data=c_courseDao.findC_coursesByPage(pagesize, currentpage);
		C_coursePageBean c_coursePageBean=new C_coursePageBean();
		c_coursePageBean.setCurrpage(currentpage);
		c_coursePageBean.setPagesize(pagesize);
		c_coursePageBean.setRowcount(rowcount);
		c_coursePageBean.setPagecount(pagecount);
		c_coursePageBean.setDate(data);
		return c_coursePageBean;
	}

}
