package com.chinasoft.logindemo.po;

public class Student2 {//表名即类名，首字母大写
	private String st_name;
	private String st_ID;//学号
	private String password;
	private String college;
	private String major;
	private String grade;



	public String getSt_ID() {
		return st_ID;
	}
	public void setSt_ID(String st_ID) {
		this.st_ID = st_ID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	

}
