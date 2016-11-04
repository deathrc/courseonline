<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@page import = "com.chinasoft.logindemo.po.C_course" %>
<%@ page import = "java.util.List" %>
<%
List<C_course> ccourses = (List<C_course>)session.getAttribute("ccourses");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>课程评分</title>
<style type="text/css">
<!--
body {
	background-image: url(images/%E5%AD%A6%E7%94%9F%E4%BF%A1%E6%81%AF.jpg);
	background-repeat: no-repeat;

}
.STYLE3 {font-size: 24px}
-->
</style></head>
<body>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="732" border="0" align="center">
  <tr>
    <td width="103" class="STYLE3">学生ID</td>
    <td width="120" class="STYLE3">学生成绩</td>
  </tr>
  <%
		for(C_course ccourse:ccourses)  {
  %>
  <tr>
    <td class="STYLE3"><%=ccourse.getSt_ID() %>&nbsp;</td>
    <td class="STYLE3"><%=ccourse.getGrade() %>&nbsp;</td>
    <td class="STYLE3"><a href ="TeacherController?option=grade1&st_ID=<%=ccourse.getSt_ID()%>&c_ID=<%=ccourse.getC_ID()%>">修改</a></td>
  </tr>
  <%
		}
  %>
</table>
<p align="center"><span class="STYLE3"><a href="teacher.jsp">返回</a></span></p>
</body>
</html>