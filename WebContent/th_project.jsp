<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>>
<%@page import = "com.chinasoft.logindemo.po.Project" %>  
<%@page import = "com.chinasoft.logindemo.po.Teacher2" %>  
<%
List<Project> projects = (List<Project>)session.getAttribute("projects");
Teacher2 teacher2 = (Teacher2)session.getAttribute("teacher2");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新课程</title>
<style type="text/css">
<!--
body {
	background-image: url(images/%E8%AF%BE%E9%A2%98%E7%A0%94%E7%A9%B6.jpg);
	background-repeat: no-repeat;
}
.STYLE4 {font-size: 24px}
-->
</style></head>
<body>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="679" border="0" align="center">
  <tr>
    <td width="271" class="STYLE4">学号</td>
    <td width="293" class="STYLE4">课程名</td>
    <td width="24" class="STYLE4">分数</td>   
  </tr>
 <%
 for(Project project:projects){%>
  <tr onMouseOver="this.bgColor='#FF9933'" onMouseOut="this.bgColor='#FFFFFF'">
    <td class="STYLE4"><%=project.getSt_ID()%></td>
    <td class="STYLE4"><%=project.getP_name()%></td>
    <td class="STYLE4"><%=project.getComments%></td>
    <td width="73" class="STYLE4"><a href ="TeacherController?option=gradepro&st_ID=<%=project.getSt_ID()%>">评分</a></td>
  </tr>
   <% 
   }
  %>
</table>
<p align="center" class="STYLE4"><a href= "TeacherController?option=showapp&th_ID=<%=teacher2.getTh_ID() %>">学生申请情况</a></p>
<p align="center"><span class="STYLE4"><a href="teacher.jsp">返回</a></span></p>
</body>
</html>