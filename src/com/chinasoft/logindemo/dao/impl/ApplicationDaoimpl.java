package com.chinasoft.logindemo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.logindemo.dao.ApplicationDao;
import com.chinasoft.logindemo.dbutil.DBHelper;
import com.chinasoft.logindemo.po.Application;

public class ApplicationDaoimpl implements ApplicationDao {

	private DBHelper dbHelper =new DBHelper();
	@Override
	public boolean addApp(String st_id, String p_name, String th_id) {
		String sql ="insert into application(st_ID,p_name,th_ID) values(?,?,?)";
		int n=dbHelper.execOthers(sql,st_id,p_name,th_id);
		if(n>0)
		    return true;
		// TODO Auto-generated method stub
		return false;
			
	}

	@Override
	public boolean deleteApp(String st_id, String p_name, String th_id) {
		String sql="delete from application where st_ID=?and p_name=?and th_ID=?";
		int n=dbHelper.execOthers(sql, st_id,p_name,th_id);
		if(n>0)
			return true;
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Application> findAppsByThID(String th_id) {
	
		// 声明sql语句
				String sql="select * from application where th_ID=?";		
				//执行sql语句
				ResultSet rst=dbHelper.execQuery(sql,th_id);
				//把结果集resultset转为list
				try {
					List<Application> apps=new ArrayList<Application>();
					while(rst.next()){
						Application app=new Application();
						app.setSt_ID(rst.getString(1));
						app.setP_name(rst.getString(2));
						app.setTh_ID(rst.getString(3));
						
						apps.add(app);
					}
					rst.close();
					return apps;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{dbHelper.closeAll();}
				return null;
			}

}
