<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="inc/top.jsp"></jsp:include>
	<h1>list.jsp</h1>
	<%-- JSTL 과 EL 을 사용하여 ArrayList("boardList") 객체에 저장된 BoardVO 객체 데이터 출력 --%>
	<%-- JSTL 라이브러리는 pom.xml 을 통해 자동으로 추가되어 있음 --%>
	<%-- c:forEach items="전체 데이터 저장 객체" var="1개 데이터 저장할 객체명" --%>
	<c:forEach items="${boardList }" var="board">
		${board.name } ${board.passwd } ${board.subject } ${board.content }<br> 
	</c:forEach>
</body>
</html>














