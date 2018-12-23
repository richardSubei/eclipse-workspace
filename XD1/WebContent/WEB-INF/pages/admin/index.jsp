<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../base/base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>网上商城管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="${ctx }/css/general.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/css/main.css" rel="stylesheet" type="text/css" />

<style type="text/css">
body {
  color: white;
}
</style>

<body style="background: #278296">
<form method="post" action="${ctx }/adminLogin.action" target="_parent" name='theForm' onsubmit="return validate()">
  <table cellspacing="0" cellpadding="0" style="margin-top: 100px" align="center">
  <tr>
    <td><img src="${ctx }/img/itcast/login.jpg" width="178" height="256" border="0" alt="SHOP" /></td>
    <td style="padding-left: 50px">
      <table>
      <c:out value="${msg }"/>
      <tr>
        <td>管理员姓名：</td>
        <td><input type="text" name="adminName" /></td>
      </tr>
      <tr>
        <td>管理员密码：</td>
        <td><input type="password" name="adminPassword" /></td>
      </tr>
	  <tr>
	  	<td>
	  		<input type="submit" value="登录"/>
	  	</td>
	  </tr>
      <tr>
        <td colspan="2" align="right">&raquo; <a href="" style="color:white">返回首页</a> &raquo; <a href="" style="color:white">您忘记了密码吗?</a></td>
      </tr>
      </table>
    </td>
  </tr>
  </table>
  <input type="hidden" name="act" value="signin" />
</form>

</body>