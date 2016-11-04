package com.chinasoft.logindemo.vo;

import java.util.List;

import com.chinasoft.logindemo.po.Teacher2;

public class Teacher2PageBean {
	private int pagesize;
	private int rowcount;
	private int pagecount;
	private int currpage;
	private List<Teacher2> data;
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getRowcount() {
		return rowcount;
	}
	public void setRowcount(int rowcount) {
		this.rowcount = rowcount;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public int getCurrpage() {
		return currpage;
	}
	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}
	public List<Teacher2> getData() {
		return data;
	}
	public void setDate(List<Teacher2> data) {
		// TODO Auto-generated method stub
		this.data = data;
	}
	
}
