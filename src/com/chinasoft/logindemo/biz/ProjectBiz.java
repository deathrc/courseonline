package com.chinasoft.logindemo.biz;

import java.util.List;

import com.chinasoft.logindemo.po.Project;

public interface ProjectBiz {

	Project findProjectByStID(String st_id);
	List<Project> findProjectsByThID(String th_id);
	boolean addProject(String p_name,String st_id,String th_id);
	boolean gradeProject(Project project,String comments);
}
