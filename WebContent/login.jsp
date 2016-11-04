<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生登录</title>
<style type="text/css">
<!--
body {
	background-image: url(images/178126_668851.jpg);
	background-repeat: no-repeat;
	background-attachment:fixed;
	background-position:center;
	width="10";
}
.STYLE1 {font-size: 36px}
.STYLE3 {font-size: 36px; font-family: "宋体"; }
.STYLE5 {font-size: 36px; font-family: "宋体"; font-weight: bold; }
-->
</style></head>
<body>
<form name="frmlogin" id="frmlogin" action="StudentController?option=login" method="post">
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <div align="center">
    <table width="454" height="210" border="0">
      <tr>
        <td colspan="2"><div align="center" class="STYLE5">学生登陆</div></td>
      </tr>
      <tr>
        <td width="128" class="STYLE3"> 学 号：</td>
        <td width="316"><span class="STYLE1">
          <label>
          <input name="username" id="username" type="text" size="30" />
          </label>
      </span>       </tr>
      <tr>
        <td width="128" class="STYLE3"> 密 码：</td>
        <td width="316"><span class="STYLE1">
          <label>
          <input name="password" id="password" type="password" size="30" />
          </label>
        </span></td>
      </tr>
    </table>
    <br/>
    <input name="submit" type="submit" style="background:url(images/ok1.jpg); width:150px; height:50px" value="登陆"/>
  </div>
</form>
</body>
</html>