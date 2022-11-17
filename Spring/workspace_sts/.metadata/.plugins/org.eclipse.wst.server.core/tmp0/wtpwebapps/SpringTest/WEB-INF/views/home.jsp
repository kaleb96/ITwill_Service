<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<hr>
<form action="main" method="get">
	<input type="submit" value="메인페이지(GET)">
</form>

<form action="main" method="post">
	<input type="submit" value="메인페이지(POST)">
</form>
</body>
</html>












