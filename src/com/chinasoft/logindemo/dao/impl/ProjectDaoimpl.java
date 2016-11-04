package com.chinasoft.logindemo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.logindemo.dao.ProjectDao;
import com.chinasoft.logindemo.dbutil.DBHelper;
import com.chinasoft.logindemo.po.C_course;
import com.chinasoft.logindemo.po.Project;

public class ProjectDaoimpl implements ProjectDao {

	private DBHelper dbHelper =new DBHelper();
	@Override
	public Project findProjectByStID(String st_id) {
		String sql="select * from project where st_ID=?";		
		//执行sql语句
		ResultSet rst=dbHelper.execQuery(sql,st_id);
		//把结果集resultset转为list
		try {
			if(rst.next()){
				Project project=new Project();
				project.setP_name(rst.getString(1));
				project.setSt_ID(rst.getString(2));
				project.setTh_ID(rst.getString(3));
				project.setComments(rst.getString(4));
				project.setFinish(rst.getString(5));
				rst.close();
				return project;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{dbHelper.closeAll();}
		return null;
	}

	@Override
	public List<Project> findProjectsByThID(String th_id) {
		String sql="select * from project where th_ID=?";		
		//执行sql语句
		ResultSet rst=dbHelper.execQuery(sql,th_id);
		//把结果集resultset转为list
		try {
			List<Project> projects=new ArrayList<Project>();
			while(rst.next()){
				Project project=new Project();
				project.setP_name(rst.getString(1));
				project.setSt_ID(rst.getString(2));
				project.setTh_ID(rst.getString(3));
				project.setComments(rst.getString(4));
				project.setFinish(rst.getString(5));
				projects.add(project);
			}
			rst.close();
			return projects;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{dbHelper.closeAll();}
		return null;
	}

	@Override
	public boolean addProject(String p_name, String st_id, String th_id) {
		String sql ="insert into project(p_name,st_ID,th_ID) values(?,?,?)";
		int n=dbHelper.execOthers(sql,p_name,st_id,th_id);
		if(n>0)
		    return true;
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gradeProject(Project project,String comments){
		String sql ="update project set comments=? where st_ID=?";
		int n=dbHelper.execOthers(sql,comments,project.getSt_ID());
		if(n>0)
		    return true;
		// TODO Auto-generated method stub
		return false;
	}

}
