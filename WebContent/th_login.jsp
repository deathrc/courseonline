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
	background-image: url(images/178126_668851.jpg);
	background-repeat: repeat;
}
.STYLE2 {font-size: 24px; }
-->
</style></head>
<body>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<form name="form1" method="post" action="TeacherController?option=login">
  <table width="373" height="196" border="0" align="center">
    <tr>
      <td colspan="2"><div align="center" class="STYLE2">教师登录</div></td>
    </tr>
    <tr>
      <td width="113"><div align="right" class="STYLE2">教师ID：</div></td>
      <td width="216"><span class="STYLE2">
        <label>
        <input name="th_ID" type="text" id="th_ID">
        </label>
      </span></td>
    </tr>
    <tr>
      <td height="25"><div align="right" class="STYLE2">密码：</div></td>
      <td><span class="STYLE2">
        <label>
        <input name="password" type="password" id="password">
        </label>
      </span></td>
    </tr>
    <tr>
      <td height="44" colspan="2"><span class="STYLE2">
        <label>
        </span>
        <div align="center" class="STYLE2">
          <input type="submit" name="Submit" value="登录">
          <label></label>
        </div>
        <span class="STYLE2">
        </label>
      </span></td>
    </tr>
  </table>
</form>
</body>
</html>