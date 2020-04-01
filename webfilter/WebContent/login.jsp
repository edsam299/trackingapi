<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp"%>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
Login
<form action="LoginServlet">  
Name:<input type="text" name="user"/><br/>  
Password:<input type="password" name="pwd"/><br/>  
  
<input type="submit" value="login">  
  
</form>  
</body>
</html>