<%@page import="com.chinasoft.logindemo.po.Course"%>
<%@page import="com.chinasoft.logindemo.po.Teacher2"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>课程</title>
<style type="text/css">
<!--
body {
	background-image: url(images/%E9%80%89%E8%AF%BE.jpg);
	background-repeat: no-repeat;

}
.STYLE3 {font-size: 24px}
-->
</style></head>
<body>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>
  <%  List<Course> courses = (List<Course>)session.getAttribute("courses");
 %>
</p>
<table width="200" border="0" align="center">
  <tr>
    <td class="STYLE3">课程名</td>
    <td class="STYLE3">开课时间</td>
  </tr>
 <%

 for(Course course:courses){%>
  <tr onMouseOver="this.bgColor='#FF9933'" onMouseOut="this.bgColor='#FFFFFF'">
    <td class="STYLE3"><%=course.getC_name()%></td>
    <td class="STYLE3"><%=course.getStart_time()%></td>
    <td class="STYLE3"><a href="TeacherController?option=showthgrade&c_ID=<%=course.getC_ID() %>">评分</a></td>
  </tr>
   <% 
   }
  %>
</table>
<p align="center"><span class="STYLE3"><a href="teacher.jsp">返回</a></span></p>
</body>
</html>