<%@page import="com.chinasoft.logindemo.po.C_course"%>
<%@page import="com.chinasoft.logindemo.po.Student1"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>已选课程</title>
<style type="text/css">
<!--
.STYLE3 {font-size: 24px}
body {
	background-image: url(images/%E9%80%89%E8%AF%BE.jpg);
	background-repeat: no-repeat;

}
-->
</style>
</head>
<body>
<p class="STYLE3">
  <%  List<C_course> c_courses = (List<C_course>)session.getAttribute("c_courses");
List<String> cnames=(List<String>)session.getAttribute("cnames");
List<String> tnames=(List<String>)session.getAttribute("tnames");
String max1=(String)session.getAttribute("max");
String min1=(String)session.getAttribute("min");
String GPA1=(String)session.getAttribute("GPA");
String avg1=(String)session.getAttribute("avg");
String credit=(String)session.getAttribute("cre");
float max=Float.parseFloat(max1);
float min=Float.parseFloat(min1);
float GPA=Float.parseFloat(GPA1);
float avg=Float.parseFloat(avg1);
float money=Float.parseFloat(credit)*50;
 %>

</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="741" border="0" align="center">
  <tr>
    <td width="149" class="STYLE3">课程名</td>
    <td width="151" class="STYLE3">任课教师</td>
    <td width="110" class="STYLE3">成绩</td>
    <td width="313" class="STYLE3">学分</td>
  </tr>
 <%
 int i=0;
 for(C_course c_course:c_courses){%>
  <tr onMouseOver="this.bgColor='#FF9933'" onMouseOut="this.bgColor='#FFFFFF'">
    <td class="STYLE3"><%=cnames.get(i) %></td>
    <td class="STYLE3"><%=tnames.get(i) %></td>
    <td class="STYLE3"><%=(c_course.getFinish()==null?"未修完":c_course.getGrade()) %></td>
    <td class="STYLE3"><%=c_course.getCredit() %></td>
  </tr>
   <% 
 i++;}
  %>
</table>
<p align="center" class="STYLE3">学费：<%=money %>  学分绩：<%=GPA %>  最高分：<%=max %>  最低分：<%=min %>  平均分：<%=avg %></p>
<p align="center" class="STYLE3"><a href="StudentController?option=getcoursepage"><strong>选课</strong></a>|<a href="index.jsp"><strong>返回</strong></a></p>
</body>
</html>