<%@page import="com.chinasoft.logindemo.po.Teacher2"%>
<%@page import="com.chinasoft.logindemo.po.Student2"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>申请指导老师</title>
<style type="text/css">
<!--
body {
	background-image: url(%E6%95%99%E5%B8%88.jpg);
	background-repeat: no-repeat;

}
.STYLE4 {font-size: 24px}
-->
</style></head>
<body>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>
  <%List<Teacher2> teacher2s= (List<Teacher2>)request.getAttribute("teacher2s");%>
</p>
<table width="1038" height="53" border="0" align="center">
  <tr>
    <td class="STYLE4">教师姓名</td>
    <td class="STYLE4">教师ID</td>
    <td class="STYLE4">学院</td>
  </tr>
  <%for(Teacher2 teacher2:teacher2s){%>
  <tr>
    <td class="STYLE4"><%=teacher2.getTh_name() %></td>
    <td class="STYLE4"><%=teacher2.getTh_ID() %></td>
    <td class="STYLE4"><%=teacher2.getCollege() %></td>
    <td class="STYLE4"><a href="StudentController?option=app&th_ID=<%=teacher2.getTh_ID() %>">申请</a></td>
  </tr>
      <% 
 }
  %>
</table>
<p align="center"><span class="STYLE4"><a href="index.jsp" >返回</a></span> </p>
</body>
</html>