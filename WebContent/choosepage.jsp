<%@page import="com.chinasoft.logindemo.po.Course"%>
<%@page import="com.chinasoft.logindemo.vo.CoursePageBean"%>
<%@page import="com.chinasoft.logindemo.po.Course"%>
<%@page import="com.chinasoft.logindemo.po.Student2"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%CoursePageBean pageBean=(CoursePageBean)request.getAttribute("coursepageBean");
List<Course> courses = pageBean.getData();
Student2 student2=(Student2)session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>选择课程</title>
<style type="text/css">
<!--
body {
	background-image: url(images/%E9%80%89%E8%AF%BE.jpg);
}
-->
</style></head>
<body>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="588" border="0" align="center">
  <tr>
    <td width="60"><div align="center">课程名</div></td>
    <td width="70"><div align="center">课程编号</div></td>
    <td width="72"><div align="center">教师名</div></td>
    <td width="81"><div align="center">开课时间</div></td>
    <td width="80"><div align="center">申请人数</div></td>
    <td width="72"><div align="center">最多人数</div></td>
    <td width="48"><div align="center">学分</div></td>
    <td width="53">&nbsp;</td>
  </tr>
   <%for(Course course:courses){%>
  <tr>
    <td><%=course.getC_name() %></td>
    <td><%=course.getC_ID() %></td>
    <td><%=course.getTh_ID() %></td>
    <td><%=course.getStart_time() %></td>
    <td><%=course.getApp_num() %></td>
    <td><%=course.getMax_num() %></td>
    <td><%=course.getCredit() %></td>
    <td><a href="StudentController?option=choose&c_ID=<%=course.getC_ID() %>&st_ID=<%=student2.getSt_ID() %> &page=<%=pageBean.getCurrpage()%>">选课</a></td>
  </tr>
     <% 
 }
  %>
</table>
<form name="frmGo" id="frmGO" action="StudentController?option=getcoursepage" method="post">
	<p align="center">
		[<%=pageBean.getCurrpage()%>/<%=pageBean.getPagecount()%>] <a
			href="StudentController?option=getcoursepage&page=1">首页</a> | <a
			href="StudentController?option=getcoursepage&page=<%=(pageBean.getCurrpage() - 1)==0?1:(pageBean.getCurrpage() - 1)%>">上一页</a>
		| <a
			href="StudentController?option=getcoursepage&page=<%=(pageBean.getCurrpage() + 1)==pageBean.getPagecount()?pageBean.getPagecount():(pageBean.getCurrpage() + 1)%>">下一页</a>
		| <a
			href="StudentController?option=getcoursepage&page=<%=pageBean.getPagecount()%>">末页</a>
		<input type="text" size="5" name="page" /><input type="submit" value="GO" />
	</p>
</form>
<p align="center"><a href="StudentController?option=getc_courses&st_ID=<%=student2.getSt_ID() %>">返回</a> </p>
</body>
</html>