<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="inc/top.jsp"></jsp:include>
	<h1>redirect.jsp</h1>
	<h3>이름 : ${param.name }</h3>
	<h3>나이 : ${param.age }</h3>
	<br>
	<h3>이름 : ${name2 }</h3>
	<h3>나이 : ${age2 }</h3>
</body>
</html>