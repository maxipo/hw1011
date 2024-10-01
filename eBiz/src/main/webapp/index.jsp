<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome To My Spring Boot Playground!</title>
<link href="<%= request.getContextPath() %>/style/myStyle.css" rel="stylesheet"></link>
</head>
<body>
	<h1>Welcome To My Spring Boot Playground!</h1>
	<p>Current Time is : <%= SimpleDateFormat.getInstance().format(new Date()) %></p>
	<p>
		<a href="main">Lottery</a>
		<a href="user/login">Sign in</a>
		<a href="user/register">Sign up</a>
		<a href="${pageContext.request.contextPath}/user/logout">Log out</a>
	</p>
</body>
</html>