package com.chinasoft.logindemo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.logindemo.dao.Teacher2Dao;
import com.chinasoft.logindemo.dbutil.DBHelper;
import com.chinasoft.logindemo.po.Student2;
import com.chinasoft.logindemo.po.Teacher2;

public class Teacher2Daoimpl implements Teacher2Dao {
	private DBHelper dbHelper =new DBHelper();
	@Override
	public List<Teacher2> findAllTeachers() {
		       
				String sql="select * from teacher2";		
				//执行sql语句
				ResultSet rst=dbHelper.execQuery(sql);
				//把结果集resultset转为list
				try {
					List<Teacher2> teacher2s=new ArrayList<Teacher2>();
					while(rst.next()){
						Teacher2 teacher2=new Teacher2();
						teacher2.setTh_name(rst.getString(1));
						teacher2.setTh_ID(rst.getString(2));
						teacher2.setPassword(rst.getString(3));
						teacher2.setCollege(rst.getString(4));
						
						teacher2s.add(teacher2);
					}
					rst.close();
					return teacher2s;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{dbHelper.closeAll();}
				return null;
	}
	@Override
	public String findThnameByThID(String th_id) {
		DBHelper dbHelper3 =new DBHelper();
		String sql="select * from teacher2 where th_ID=?";
		//执行sql语句
		ResultSet rst=dbHelper3.execQuery(sql,th_id);
		//把结果集resultset转为list
		try {
			if(rst.next()){
				String name=rst.getString(1);
				rst.close();
				return name;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{dbHelper3.closeAll();}
		return null;
	}
	@Override
	public List<Teacher2> findTeacher2sByPage(int pagesize, int currpage) {
		// 声明SQL语句
				String sql = "select * from teacher2 limit ?,?";
				// 执行SQL语句
				ResultSet rst = dbHelper.execQuery(sql,pagesize*(currpage-1),pagesize);
				// 把结果集（ResultSet）转为List
				try {
					List<Teacher2> teacher2s=new ArrayList<Teacher2>();
					while(rst.next()){
						Teacher2 teacher2=new Teacher2();
						teacher2.setTh_name(rst.getString(1));
						teacher2.setTh_ID(rst.getString(2));
						teacher2.setPassword(rst.getString(3));
						teacher2.setCollege(rst.getString(4));
						
						teacher2s.add(teacher2);
					}
					rst.close();
					return teacher2s;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					dbHelper.closeAll();
				}
				return null;
	}
	@Override
	public int getTeacher2Count() {
		DBHelper dbHelper2 = new DBHelper();
		String  sql="select count(*) from teacher2";
		ResultSet rst=dbHelper2.execQuery(sql);
		//把结果集resultset转为list
		try {
			if(rst.next()){
				int count=rst.getInt(1);
				rst.close();
				return count;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{dbHelper2.closeAll();}
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Teacher2 findUserByUsernameAndPassword(String username,String password) {
		//准备sql语句
				String sql="select * from teacher2 where th_ID=? and password=?";
				ResultSet rst=dbHelper.execQuery(sql,username,password);
				try{
				    if(rst.next())
				 {
					Teacher2 user=new Teacher2();
					user.setTh_name(rst.getString(1));
					user.setTh_ID(rst.getString(2));
					
					user.setPassword(rst.getString(3));
					
					user.setCollege(rst.getString(4));
					rst.close();
					return user;
				 }
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
				finally{dbHelper.closeAll();}
				
				return null;
	}

}
