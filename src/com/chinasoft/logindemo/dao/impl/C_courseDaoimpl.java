package com.chinasoft.logindemo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.logindemo.dao.C_courseDao;
import com.chinasoft.logindemo.dbutil.DBHelper;
import com.chinasoft.logindemo.po.C_course;

public class C_courseDaoimpl implements C_courseDao {

	private DBHelper dbHelper =new DBHelper();
	@Override
	public List<C_course> findCcourseByCID(String c_id) {
		String sql="select * from c_course where c_ID=?";		
		//执行sql语句
		ResultSet rst=dbHelper.execQuery(sql,c_id);
		//把结果集resultset转为list
		try {
			List<C_course> c_courses=new ArrayList<C_course>();
			while(rst.next()){
			
				C_course c_course=new C_course();
				c_course.setTh_ID(rst.getString(2));
				c_course.setSt_ID(rst.getString(1));
				c_course.setC_ID(rst.getString(3));
				c_course.setGrade(rst.getFloat(4));
				c_course.setCredit(rst.getFloat(5));
				c_course.setFinish(rst.getString(6));
				c_courses.add(c_course);
			}
			rst.close();
			return c_courses;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{dbHelper.closeAll();}
		return null;
	}

	@Override
	public List<C_course> findCcourseByStID(String st_id) {
		String sql="select * from c_course where st_ID=?";		
		//执行sql语句
		ResultSet rst=dbHelper.execQuery(sql,st_id);
		//把结果集resultset转为list
		try {
			List<C_course> c_courses=new ArrayList<C_course>();
			while(rst.next()){
				C_course c_course=new C_course();
				c_course.setTh_ID(rst.getString(2));
				c_course.setSt_ID(rst.getString(1));
				c_course.setC_ID(rst.getString(3));
				c_course.setGrade(rst.getFloat(4));
				c_course.setCredit(rst.getFloat(5));
				c_course.setFinish(rst.getString(6));
				c_courses.add(c_course);
			}
			rst.close();
			return c_courses;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{dbHelper.closeAll();}
		return null;
	}

	@Override
	public boolean addCCourse(String c_id,String t_id,String st_id, float credit) {
		String sql ="insert into c_course(st_ID,th_ID,c_ID,credit) values(?,?,?,?)";
		int n=dbHelper.execOthers(sql,st_id,t_id,c_id,credit);
		if(n>0)
		    return true;
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public C_course findCcourseByCIDSTID(String c_id, String st_id) {
		DBHelper dbHelper2 =new DBHelper();
		String sql="select * from c_course where c_ID=? and st_ID=?";		
		//执行sql语句
		ResultSet rst=dbHelper2.execQuery(sql,c_id,st_id);
		//把结果集resultset转为list
		try {
			
			if(rst.next()){
				C_course c_course=new C_course();
				c_course.setTh_ID(rst.getString(2));
				c_course.setSt_ID(rst.getString(1));
				c_course.setC_ID(rst.getString(3));
				c_course.setGrade(rst.getFloat(4));
				c_course.setCredit(rst.getFloat(5));
				c_course.setFinish(rst.getString(6));
				rst.close();
				return c_course;
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{dbHelper2.closeAll();}
		return null;
	
	}

	@Override
	public boolean gradeCcourse(C_course ccourse, float grade) {
		String sql1 ="update c_course set grade=? where st_ID=? and c_ID=? ";
		String sql2 ="update c_course set finish=? where st_ID=? and c_ID=? ";
		String f="1";
		int n=dbHelper.execOthers(sql1,grade,ccourse.getSt_ID(),ccourse.getC_ID());
	    n=dbHelper.execOthers(sql2,f,ccourse.getSt_ID(),ccourse.getC_ID());
		if(n>0)
		    return true;
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<C_course> findC_coursesByPage(int pagesize, int currpage) {
		// 声明SQL语句
				String sql = "select * from c_course limit ?,?";
				// 执行SQL语句
				ResultSet rst = dbHelper.execQuery(sql,pagesize*(currpage-1),pagesize);
				// 把结果集（ResultSet）转为List
				try {
						List<C_course> c_courses=new ArrayList<C_course>();
						while(rst.next()){
							C_course c_course=new C_course();
							c_course.setTh_ID(rst.getString(2));
							c_course.setSt_ID(rst.getString(1));
							c_course.setC_ID(rst.getString(3));
							c_course.setGrade(rst.getFloat(4));
							c_course.setCredit(rst.getFloat(5));
							c_course.setFinish(rst.getString(6));
							c_courses.add(c_course);
					}
					rst.close();
					return c_courses;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					dbHelper.closeAll();
				}
				return null;
	}
	@Override
	public int getC_courseCount() {
		DBHelper dbHelper2 = new DBHelper();
		String  sql="select count(*) from c_course";
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

}
