package com.chinasoft.logindemo.dao;

import java.util.List;

import com.chinasoft.logindemo.po.C_course;
import com.chinasoft.logindemo.po.Course;

public interface CourseDao {

	Course findCourseByCID(String c_ID);
	List<Course> findAllCourses();
	List<Course> findCoursesByTh_id(String th_ID);
	List<Course> findCoursesByPage(int pagesize,int currpage);
	boolean addAppNum(String c_ID,int appnum);
	int getCourseCount();
}
