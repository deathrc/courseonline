package com.chinasoft.logindemo.dao;

import com.chinasoft.logindemo.po.Student2;

public interface Student2Dao {
	Student2 findUserByUsernameAndPassword(String username,String password);
	String findNameByStID(String st_ID);

}
