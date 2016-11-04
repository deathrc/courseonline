<%@page import="com.chinasoft.logindemo.po.Teacher2"%>
<%@page import="com.chinasoft.logindemo.vo.Teacher2PageBean"%>
<%@page import="com.chinasoft.logindemo.po.Student2"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%Teacher2PageBean pageBean=(Teacher2PageBean)request.getAttribute("teacger2pageBean");
List<Teacher2> teacher2s = pageBean.getData();
Student2 student2=(Student2)session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>申请指导老师</title>
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
<table width="312" height="53" border="0" align="center">
  <tr>
    <td class="STYLE3">教师姓名</td>
    <td class="STYLE3">教师ID</td>
    <td class="STYLE3">学院</td>
  </tr>
  <%for(Teacher2 teacher2:teacher2s){%>
  <tr>
    <td class="STYLE3"><%=teacher2.getTh_name() %></td>
    <td class="STYLE3"><%=teacher2.getTh_ID() %></td>
    <td class="STYLE3"><%=teacher2.getCollege() %></td>
    <td class="STYLE3"><a href="StudentController?option=app&th_ID=<%=teacher2.getTh_ID() %>">申请</a></td>
  </tr>
      <% 
 }
  %>
</table>
<form action="StudentController?option=getteacher2page" method="post" name="frmGo" class="STYLE3" id="frmGO">
	<p align="center">
		[<%=pageBean.getCurrpage()%>/<%=pageBean.getPagecount()%>] <a
			href="StudentController?option=getteacher2page&page=1">首页</a> | <a
			href="StudentController?option=getteacher2page&page=<%=(pageBean.getCurrpage() - 1)==0?1:(pageBean.getCurrpage() - 1)%>">上一页</a>
		| <a
			href="StudentController?option=getteacher2page&page=<%=(pageBean.getCurrpage() + 1)==pageBean.getPagecount()?pageBean.getPagecount():(pageBean.getCurrpage() + 1)%>">下一页</a>
		| <a
			href="StudentController?option=getteacher2page&page=<%=pageBean.getPagecount()%>">末页</a>
		<input type="text" size="5" name="page" /><input type="submit" value="GO" />
	</p>
</form>
<p align="center"><span class="STYLE3"><a href="index.jsp" >返回</a></span> </p>
</body>
</html>