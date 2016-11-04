<%@page import="com.chinasoft.logindemo.po.Student2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>申请新课程</title>
<style type="text/css">
<!--
body {
	background-image: url(images/%E6%95%99%E5%B8%88.jpg);
	background-repeat: no-repeat;

}
.STYLE1 {font-size: 24px}
-->
</style></head>
<body>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p class="STYLE1">
  <%String th_id=(String)session.getAttribute("th_id");
Student2 student2=(Student2)session.getAttribute("user");%>
</p>
<form action="StudentController?option=appproject&st_ID=<%=student2.getSt_ID()%>&th_ID=<%=th_id%>" method="post" name="form1" class="STYLE1">
  <div align="center">
    <p>教师：<%=th_id %></p>
    <p>程名称 ：    </p>
  </div>
  <label>
  <div align="center">
    <input type="text" name="p_name">
  </div>
  </label>
  <p align="center">
    <label>
    <input type="submit" name="Submit" value="提交申请">
    </label>
  </p>
</form>
</body>
<p align="center"><a href="StudentController?option=getteacher2page" >返回</a> </p>

</html>