<%@page import="com.chinasoft.logindemo.po.Project"%>
<%@page import="com.chinasoft.logindemo.po.Student2"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教师反馈</title>
<style type="text/css">
<!--
body {
	background-image: url(imagesyouhuayanliao-011.jpg);
	background-repeat: no-repeat;
	background-attachment:fixed;
	background-position:center;
	

}
.STYLE1 {font-size: 36px}
.STYLE2 {font-size: 24px}
-->
</style></head>
<body>
<p>&nbsp;</p>
<p>
  <% Project project= (Project)session.getAttribute("project");
   String tname=(String)session.getAttribute("tname");%>
</p>
<table width="500" height="145" border="0" align="center">
  <tr>
    <td width="127" class="STYLE2">课程名：</td>
    <td width="363" class="STYLE2"><%=project.getP_name() %></td>
  </tr>
  <tr>
    <td class="STYLE2">指导老师：</td>
    <td class="STYLE2"><%=tname %></td>
  </tr>
  <tr>
    <td class="STYLE2">反馈：</td>
    <td class="STYLE2"><%=project.getFinish()==null?"未处理":project.getComments() %></td>
  </tr>
</table>
<p align="center"><span class="STYLE2"><a href="index.jsp" class="STYLE1">返回</a></span></p>
</body>
</html>