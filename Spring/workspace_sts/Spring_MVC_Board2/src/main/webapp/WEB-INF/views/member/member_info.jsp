<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 상세정보</h1>
	<%-- table 태그를 사용하여 Model 객체로 전달받은 MemberVO 객체(member) 데이터 출력 --%>
	<table border="1">
		<tr>
			<td>이름</td>
			<td>${member.name }</td>
		</tr>
		<tr>
			<td>ID</td>
			<td>${member.id }</td>
		</tr>
		<tr>
			<td>E-Mail</td>
			<td>${member.email }</td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td>${member.post_code }</td>
		</tr>
		<tr>
			<td>기본 주소</td>
			<td>${member.address1 }</td>
		</tr>
		<tr>
			<td>상세 주소</td>
			<td>${member.address2 }</td>
		</tr>
		<tr>
			<td>가입일</td>
			<td>${member.hire_date }</td>
		</tr>
	</table>
</body>
</html>















