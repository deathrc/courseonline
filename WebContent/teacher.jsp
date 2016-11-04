<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.chinasoft.logindemo.po.Teacher2" %>
<%
	if(session.getAttribute("teacher2")==null){
		response.sendRedirect("th_login.jsp");
		return ;
	}
Teacher2 teacher2 = (Teacher2)session.getAttribute("teacher2");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
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
<p align="center">&nbsp;</p>
<p align="center">&nbsp;</p>
<p align="center">&nbsp;</p>
<p align="center">&nbsp;</p>
<p align="center">&nbsp;</p>
<p align="center">&nbsp;</p>
<p align="center">&nbsp;</p>
<p align="center">&nbsp;</p>
<p align="center" class="STYLE1"><%=teacher2.getTh_name() %>老师，欢迎进入教师登录界面！</p>
<table width="490" border="0" align="center">
 
  <tr>
    <td class="STYLE1">教师ID：</td>
    <td class="STYLE1"><%=teacher2.getTh_ID() %></td>
  </tr>
  <tr>
    <td class="STYLE1">所属学院：</td>
    <td class="STYLE1"><%=teacher2.getCollege() %></td>
  </tr>
</table>
<p align="center" class="STYLE1"><a href= "TeacherController?option=logout" >登出</a></p>
<span class="STYLE1">
<label></label>
</span>
<hr>
<p align="center" class="STYLE1"><a href= "TeacherController?option=showthinfo&th_ID=<%=teacher2.getTh_ID() %>" >教师详细信息</a></p>
<p align="center" class="STYLE1"><a href= "TeacherController?option=showthcourse&th_ID=<%=teacher2.getTh_ID()%>">授课情况</a></p>
<p align="center"><span class="STYLE1"><a href= "TeacherController?option=showthproject&th_ID=<%=teacher2.getTh_ID()%>" >新课程申请</a></span></p>
</body>
</html>