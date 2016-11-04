package com.chinasoft.logindemo.biz;

import java.util.List;

import com.chinasoft.logindemo.po.Course;
import com.chinasoft.logindemo.vo.C_coursePageBean;
import com.chinasoft.logindemo.vo.CoursePageBean;


public interface CourseBiz {
	Course findCourseByCID(String c_ID);
	List<Course> findAllCourses();
	CoursePageBean getCoursesByPage(int pagesize,int currentpage);
	List<Course> findCoursesByTh_id(String th_ID);
	boolean addAppNum(String c_ID,int appnum);
}
