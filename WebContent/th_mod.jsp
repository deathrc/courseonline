<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@page import = "com.chinasoft.logindemo.po.Teacher1" %>
<%
Teacher1 teacher = (Teacher1)session.getAttribute("teacher");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教师信息</title>
<style type="text/css">
<!--
body {
	background-image: url(images/%E6%95%99%E5%B8%88.jpg);
	background-repeat: no-repeat;
}
.STYLE3 {font-size: 24px}
-->
</style></head>
<body>
 <p>&nbsp;</p>
 <p>&nbsp;</p>
 <table width="477" border="0" align="center">
  <tr>
    <td width="101" class="STYLE3">教师号</td>
    <td width="366" class="STYLE3"><%=teacher.getTh_ID() %></td>
  </tr>
  <tr>
    <td class="STYLE3">姓名</td>
    <td class="STYLE3"><%=teacher.getTh_name() %></td>
  </tr>
  <tr>
    <td class="STYLE3">性别</td>
    <td class="STYLE3"><%=teacher.getGender() %></td>
  </tr>
  <tr>
    <td class="STYLE3">居住地</td>
    <td class="STYLE3"><%=teacher.getCity() %></td>
  </tr>
</table>
<p align="center"><span class="STYLE3"><a href="teacher.jsp">返回</a></span></p>
</body>
</html>