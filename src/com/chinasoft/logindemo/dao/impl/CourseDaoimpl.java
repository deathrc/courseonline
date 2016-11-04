package com.chinasoft.logindemo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.logindemo.dao.CourseDao;
import com.chinasoft.logindemo.dbutil.DBHelper;
import com.chinasoft.logindemo.po.Course;
import com.chinasoft.logindemo.po.Student1;

public class CourseDaoimpl implements CourseDao {

	private DBHelper dbHelper =new DBHelper();
	@Override
	public Course findCourseByCID(String c_ID) {
		DBHelper dbHelper2 =new DBHelper();
		String sql="select * from course where c_ID=?";		
			//执行sql语句
			ResultSet rst=dbHelper2.execQuery(sql,c_ID);
			
			//把结果集resultset转为list
			try {
				
				if(rst.next()){
					Course course=new Course();
					course.setC_name(rst.getString(1));
					course.setC_ID(rst.getString(2));
					course.setTh_ID(rst.getString(3));
					course.setStart_time(rst.getString(4));
					course.setApp_num(rst.getInt(5));
					course.setMax_num(rst.getInt(6));
					course.setCredit(rst.getFloat(7));
					rst.close();
					return course;
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{dbHelper2.closeAll();}
			return null;
		
	}

	@Override
	public List<Course> findAllCourses() {
		String sql="select * from course";		
		//执行sql语句
		ResultSet rst=dbHelper.execQuery(sql);
		
		//把结果集resultset转为list
		try {
			List<Course> courses=new ArrayList<Course>();
			while(rst.next()){
				Course course=new Course();
				course.setC_name(rst.getString(1));
				course.setC_ID(rst.getString(2));
				course.setTh_ID(rst.getString(3));
				course.setStart_time(rst.getString(4));
				course.setApp_num(rst.getInt(5));
				course.setMax_num(rst.getInt(6));
				course.setCredit(rst.getFloat(7));
				courses.add(course);
			}
			rst.close();
			return courses;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{dbHelper.closeAll();}
		return null;
	}

	@Override
	public List<Course> findCoursesByPage(int pagesize, int currpage) {
		// 声明SQL语句
				String sql = "select * from course limit ?,?";
				// 执行SQL语句
				ResultSet rst = dbHelper.execQuery(sql,pagesize*(currpage-1),pagesize);
				// 把结果集（ResultSet）转为List
				try {
					List<Course> courses = new ArrayList<Course>();
					while (rst.next()) {
						Course course=new Course();
						course.setC_name(rst.getString(1));
						course.setC_ID(rst.getString(2));
						course.setTh_ID(rst.getString(3));
						course.setStart_time(rst.getString(4));
						course.setApp_num(rst.getInt(5));
						course.setMax_num(rst.getInt(6));
						course.setCredit(rst.getFloat(7));
						courses.add(course);
					}
					rst.close();
					return courses;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					dbHelper.closeAll();
				}
				return null;
	}

	@Override
	public int getCourseCount() {
		DBHelper dbHelper2 = new DBHelper();
		String  sql="select count(*) from course";
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
	public List<Course> findCoursesByTh_id(String th_ID) {
		String sql="select * from course where th_ID=?";		
		//执行sql语句
		ResultSet rst=dbHelper.execQuery(sql,th_ID);
		
		//把结果集resultset转为list
		try {
			List<Course> courses=new ArrayList<Course>();
			while(rst.next()){
				Course course=new Course();
				course.setC_name(rst.getString(1));
				course.setC_ID(rst.getString(2));
				course.setTh_ID(rst.getString(3));
				course.setStart_time(rst.getString(4));
				course.setApp_num(rst.getInt(5));
				course.setMax_num(rst.getInt(6));
				course.setCredit(rst.getFloat(7));
				courses.add(course);
			}
			rst.close();
			return courses;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{dbHelper.closeAll();}
		return null;
	}

	@Override
	public boolean addAppNum(String c_ID,int appnum) {
		String sql ="update course set app_num=? where c_ID=?";
		int n=dbHelper.execOthers(sql,appnum+1,c_ID);
		if(n>0)
		    return true;
		// TODO Auto-generated method stub
		return false;
	}

}
