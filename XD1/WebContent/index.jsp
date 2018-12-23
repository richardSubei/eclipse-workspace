<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${ctx }/js/jquery-1.9.1.min.js"></script>
	  <script>
   		function change() {
   			document.getElementById("test").setAttribute("placeholder","你想修改的内容");
   			document.getElementById("h1").innerHTML = "HELLO WORLD";
   		}
   		
   		
   		
  </script>

</head>
<body>

	<input type="text" id="test" placeholder="输入用户名">
	<input type="button" onclick="change()" value="change">
	<h1 id="h1"></h1>
	
</body>
</html>