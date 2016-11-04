package com.chinasoft.logindemo.biz;

import java.util.List;

import com.chinasoft.logindemo.po.C_course;
import com.chinasoft.logindemo.vo.C_coursePageBean;

public interface C_courseBiz {

	List<C_course> FindCcoursesByCID(String c_id);
	List<C_course> FindCcoursesByStID(String st_id);
	C_course findCcourseByCIDSTID(String c_id,String st_id);
	boolean addCCourse(String c_id,String t_id,String st_id,float credit);
	boolean gradeCcourse(C_course ccourse,float grade);
	C_coursePageBean getC_coursesByPage(int pagesize,int currentpage);
}
