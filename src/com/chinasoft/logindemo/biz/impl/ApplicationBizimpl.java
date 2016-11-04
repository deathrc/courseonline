package com.chinasoft.logindemo.biz.impl;

import java.util.List;

import com.chinasoft.logindemo.biz.ApplicationBiz;
import com.chinasoft.logindemo.dao.ApplicationDao;
import com.chinasoft.logindemo.dao.impl.ApplicationDaoimpl;
import com.chinasoft.logindemo.po.Application;

public class ApplicationBizimpl implements ApplicationBiz {

	ApplicationDao appDao=new ApplicationDaoimpl();
	@Override
	public boolean addApp(String st_id, String p_name, String th_id) {
		// TODO Auto-generated method stub
		return appDao.addApp(st_id, p_name, th_id);
	}

	@Override
	public boolean deleteApp(String st_id, String p_name, String th_id) {
		// TODO Auto-generated method stub
		return appDao.deleteApp(st_id, p_name, th_id);
	}

	@Override
	public List<Application> findAppsByThID(String th_id) {
		// TODO Auto-generated method stub
		return appDao.findAppsByThID(th_id);
	}

}
