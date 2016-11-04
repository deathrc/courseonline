<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@page import = "com.chinasoft.logindemo.po.Application" %>
<%@page import = "com.chinasoft.logindemo.po.Teacher2" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新课程</title>
<style type="text/css">
<!--
body {
	background-image: url();
	background-repeat: no-repeat;

}
.STYLE3 {font-size: 24px}
-->
</style></head>
<body>
<p>&nbsp;</p>
<p>
  <%
List<Application> apps = (List<Application>)session.getAttribute("apps");
Teacher2 teacher2 = (Teacher2)session.getAttribute("teacher2");
%>
</p>
<table width="642" border="0" align="center">
  <tr>
    <td colspan="3" class="STYLE3"><div align="center">课程申请表</div></td>
  </tr>
  <tr>
    <td width="207" class="STYLE3">学生ID</td>
    <td width="287" class="STYLE3">课程名称</td>
  </tr>
  <%

  	for(Application app:apps){
  %>
  <tr>
    <td class="STYLE3"><%=app.getSt_ID() %></td>
    <td class="STYLE3"><%=app.getP_name() %></td>
   <td width="134" class="STYLE3"><a href="TeacherController?option=accept&st_ID=<%=app.getSt_ID() %> &p_name=<%=app.getP_name() %> &th_ID=<%=teacher2.getTh_ID() %>">接受</a></td>
  </tr>
  <%
 	}
  %>
</table>
<p align="center"><span class="STYLE3"><a href="teacher.jsp">返回</a></span></p>
</body>
</html>