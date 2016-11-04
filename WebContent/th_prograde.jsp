<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.chinasoft.logindemo.po.Teacher2" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
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
<p>
  <%
String st_ID=(String)request.getAttribute("st_ID");
Teacher2 teacher2 = (Teacher2)session.getAttribute("teacher2");
%>
</p>
<p>&nbsp;</p>
<form action="TeacherController?option=gradeproject&st_ID=<%=st_ID%>" method="post" name="form1" class="STYLE1">
  <div align="center">
    <p>学号：<%=st_ID %></p>
    <p>分数 ：    </p>
  </div>
  <label>
  <div align="center">
    <input type="text" name="grade">
  </div>
  </label>
  <p align="center">
    <label>
    <input type="submit" name="Submit" value="评分">
    </label>
  </p>
</form>
</body>

<p align="center"><a href="TeacherController?option=showthproject&th_ID=<%=teacher2.getTh_ID() %>" >返回</a> </p>
</html>