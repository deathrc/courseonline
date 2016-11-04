package com.chinasoft.logindemo.dao;

import java.util.List;

import com.chinasoft.logindemo.po.C_course;

public interface C_courseDao {

	List<C_course> findCcourseByCID(String c_id);
	List<C_course> findCcourseByStID(String st_id);
	C_course findCcourseByCIDSTID(String c_id,String st_id);
	boolean addCCourse(String c_id,String t_id,String st_id,float credit);
	boolean gradeCcourse(C_course ccourse,float grade);
	List<C_course> findC_coursesByPage(int pagesize,int currpage);
	int getC_courseCount();
}
