<%@ page import="java.util.Date"%>
<%@ page import="com.chinasoft.logindemo.po.Student2" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if (session.getAttribute("user")==null)
{
	response.sendRedirect("login.jsp");
	return;
	}
Student2 user=(Student2)session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页面</title>
<style type="text/css">
<!--
body {
	background-image: url(images/hello.jpg);
	background-repeat: no-repeat;
}
.STYLE1 {font-size: 24px}
-->
</style></head>
<body>
<p align="center">&nbsp; </p>
<p align="center">&nbsp;</p>
<p align="center">&nbsp;</p>
<p align="center">&nbsp;</p>
<p align="center">&nbsp;</p>
<p align="center">&nbsp;</p>
<p align="center">&nbsp;</p>
<p align="center" class="STYLE1">&nbsp;</p>
<p align="center" class="STYLE1"><%=user.getSt_name() %>你好，欢迎来进入学生系统！[<a href="UserController?option=logout">退出</a>]</p>
<p align="center" class="STYLE1">学号：<%=user.getSt_ID() %></p>
<p align="center" class="STYLE1">学院：<%=user.getCollege() %></p>
<p align="center" class="STYLE1">专业：<%=user.getMajor() %></p>
<p align="center" class="STYLE1">年级：<%=user.getGrade() %></p>
<p align="center" class="STYLE1">&nbsp;</p>
<p align="center" class="STYLE1"><a href="StudentController?option=getstudent1&st_ID=<%=user.getSt_ID() %>">学生信息</a></p>
<p align="center" class="STYLE1"><a href="StudentController?option=getc_courses&st_ID=<%=user.getSt_ID() %>">选课情况</a></p>
<p align="center" class="STYLE1"><span class="STYLE1"><a href="StudentController?option=getproject&st_ID=<%=user.getSt_ID() %>">课题研究</a></span></p>
</body>
</html>