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
	<h1>write_form.jsp - 글쓰기 폼</h1>
	<form action="write.bo" method="post">
		이름 <input type="text" name="name"><br>
		패스워드 <input type="password" name="passwd"><br>
		제목 <input type="text" name="subject"><br>
		내용 <input type="text" name="content"><br>
		<input type="submit" value="글쓰기">
	</form>
</body>
</html>