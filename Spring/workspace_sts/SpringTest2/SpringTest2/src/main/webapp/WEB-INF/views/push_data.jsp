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
	<h1>push_data.jsp</h1>
	<!-- Dispatcher 방식 포워딩 시 함께 전달된 request 객체의 "msg" 속성값 가져오기 -->
	<!-- Model 객체 사용 시에도 동일한 방법으로 속성값 가져올 수 있음 -->
	<h3><%=request.getAttribute("msg") %></h3>
	<h3>${msg }</h3>
</body>
</html>