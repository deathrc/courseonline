<%@page import="com.chinasoft.logindemo.po.Student1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% Student1 student1=(Student1)request.getAttribute("student1");
   String name=(String)request.getAttribute("name");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生个人信息详情</title>
<style type="text/css">
<!--
body {
	background-image: url();
	background-repeat: no-repeat;

}
.STYLE2 {font-size: 24}
-->
</style></head>
<body>
<table width="382" height="334" border="0" align="center">
  <tr>
    <td width="68" class="STYLE2">学号</td>
    <td width="116"><%=student1.getSt_ID() %></td>
  </tr>
  <tr>
    <td>姓名</td>
    <td><%=name %></td>
  </tr>
  <tr>
    <td>性别</td>
    <td><%=student1.getGender() %></td>
  </tr>
  <tr>
    <td>居住地</td>
    <td><%=student1.getCity() %></td>
  </tr>
</table>
<p align="center"><a href="index.jsp">返回</a></p>
</body>
</html>