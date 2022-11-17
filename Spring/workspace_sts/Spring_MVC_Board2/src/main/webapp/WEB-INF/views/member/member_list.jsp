<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체 회원 목록</h1>
	<table border="1">
		<tr>
			<th>이름</th><th>아이디</th><th>E-Mail</th><th>가입일</th>
		</tr>
		<%-- JSTL 의 forEach 문 사용하여 Model 객체에 저장된 List<MemberVO> 객체(memberList) 반복 --%>
		<%-- 반복문을 통해 꺼낸 MemberVO 객체(member) 로부터 데이터 꺼내서 출력 --%>
		<c:forEach var="member" items="${memberList }">
			<tr>
				<td>${member.name }</td>
				<td>${member.id }</td>
				<td>${member.email }</td>
				<td>${member.hire_date }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>











