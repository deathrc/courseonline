<%@page import="com.chinasoft.logindemo.po.Course"%>
<%@page import="com.chinasoft.logindemo.po.Student2"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择课程</title>
<style type="text/css">
<!--
.STYLE1 {font-size: 24px}
-->
</style>
</head>
<body>
<%List<Course> courses= (List<Course>)session.getAttribute("courses");
 Student2 student2=(Student2)session.getAttribute("user");%>
<table width="588" border="1" align="center">
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
    <td><a href="StudentController?option=choose&c_ID=<%=course.getC_ID() %>&st_ID=<%=student2.getSt_ID() %> ">选课</a></td>
  </tr>
     <% 
 }
  %>
</table>
<p align="center"><a href="StudentController?option=getc_courses&st_ID=<%=student2.getSt_ID() %>" class="STYLE1">返回</a> </p>
</body>
</html>