package com.chinasoft.logindemo.dao;

import java.util.List;

import com.chinasoft.logindemo.po.Application;

public interface ApplicationDao {
	boolean addApp(String st_id,String p_name,String th_id);
	boolean deleteApp(String st_id,String p_name,String th_id);
	List<Application> findAppsByThID(String th_id);
	

}

