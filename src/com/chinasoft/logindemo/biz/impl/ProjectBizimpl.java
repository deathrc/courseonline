package com.chinasoft.logindemo.biz.impl;

import java.util.List;

import com.chinasoft.logindemo.biz.ProjectBiz;
import com.chinasoft.logindemo.dao.ProjectDao;
import com.chinasoft.logindemo.dao.impl.ProjectDaoimpl;
import com.chinasoft.logindemo.po.Project;

public class ProjectBizimpl implements ProjectBiz {

	ProjectDao projectDao=new ProjectDaoimpl();
	@Override
	public Project findProjectByStID(String st_id) {
		// TODO Auto-generated method stub
		return projectDao.findProjectByStID(st_id);
	}

	@Override
	public List<Project> findProjectsByThID(String th_id) {
		// TODO Auto-generated method stub
		return projectDao.findProjectsByThID(th_id);
	}

	@Override
	public boolean addProject(String p_name, String st_id, String th_id) {
		// TODO Auto-generated method stub
		return projectDao.addProject(p_name, st_id, th_id);
	}

	@Override
	public boolean gradeProject(Project project, String comments) {
		// TODO Auto-generated method stub
		return projectDao.gradeProject(project, comments);
	}

}
