package com.chinasoft.logindemo.biz.impl;

import java.util.List;

import com.chinasoft.logindemo.biz.CourseBiz;
import com.chinasoft.logindemo.dao.CourseDao;
import com.chinasoft.logindemo.dao.impl.CourseDaoimpl;
import com.chinasoft.logindemo.po.C_course;
import com.chinasoft.logindemo.po.Course;
import com.chinasoft.logindemo.vo.C_coursePageBean;
import com.chinasoft.logindemo.vo.CoursePageBean;

public class CourseBizimpl implements CourseBiz {

	CourseDao courseDao=new CourseDaoimpl();

	@Override
	public Course findCourseByCID(String c_ID) {
		// TODO Auto-generated method stub
		return courseDao.findCourseByCID(c_ID);
	}
	@Override
	public List<Course> findAllCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAllCourses();
	}
	@Override
	public CoursePageBean getCoursesByPage(int pagesize, int currentpage) {
		int rowcount=courseDao.getCourseCount();
		int pagecount=rowcount%pagesize==0?rowcount/pagesize:rowcount/pagesize+1;
		List<Course> data=courseDao.findCoursesByPage(pagesize, currentpage);
		CoursePageBean coursePageBean=new CoursePageBean();
		coursePageBean.setCurrpage(currentpage);
		coursePageBean.setPagesize(pagesize);
		coursePageBean.setRowcount(rowcount);
		coursePageBean.setPagecount(pagecount);
		coursePageBean.setDate(data);
		return coursePageBean;
	}
	@Override
	public List<Course> findCoursesByTh_id(String th_ID) {
		// TODO Auto-generated method stub
		return courseDao.findCoursesByTh_id(th_ID);
	}
	@Override
	public boolean addAppNum(String c_ID, int appnum) {
		// TODO Auto-generated method stub
		return courseDao.addAppNum(c_ID, appnum);
	}

}
