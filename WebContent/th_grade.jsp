<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
<!--
body {
	background-image: url(images/%E5%AD%A6%E7%94%9F%E4%BF%A1%E6%81%AF.jpg);
	background-repeat: no-repeat;
}
.STYLE1 {font-size: 24px}
-->
</style></head>
<body>
<p>&nbsp;</p>
<p>
  <%
String st_ID=(String)session.getAttribute("st_ID");
String c_ID=(String)session.getAttribute("c_ID");
%>
</p>
<p>&nbsp; </p>
<form action="TeacherController?option=setgrade&st_ID=<%=st_ID%>&c_ID=<%=c_ID%>" method="post" name="form1" class="STYLE1">
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
    <input type="submit" name="Submit" value="提交申请">
    </label>
  </p>
</form>
</body>
<p align="center"><a href="TeacherController?option=showthgrade&c_ID=<%=c_ID %>" >返回</a> </p>
</html>