package com.chinasoft.logindemo.vo;

import java.util.List;

import com.chinasoft.logindemo.po.C_course;

public class C_coursePageBean {
	private int pagesize;
	private int rowcount;
	private int pagecount;
	private int currpage;
	private List<C_course> data;
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
	public List<C_course> getData() {
		return data;
	}
	
	public void setDate(List<C_course> data) {
		// TODO Auto-generated method stub
		this.data = data;
	}
	
}
