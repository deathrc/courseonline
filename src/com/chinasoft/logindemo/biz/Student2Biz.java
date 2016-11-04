package com.chinasoft.logindemo.biz;

import com.chinasoft.logindemo.po.Student2;

public interface Student2Biz {
 Student2 userLogin(String username,String password);
 String findNameByStID(String st_ID);
}
