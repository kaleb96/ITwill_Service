<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// session 객체의 getAttribute() 메서드를 호출하여
// 세션에 저장된 "sId" 속성값을 가져와서 String 타입 변수 sId 에 저장
// => getAttribute() 메서드 리턴타입이 Object 타입이므로 String 타입 변수에 저장 시 형변환 필수!
//    형변환 연산자 (String) 을 사용하여 강제 형변환 수행
String sId = (String)session.getAttribute("sId");
// out.println(sId);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="right">
		<h5>
			<!-- 로그인 성공(= 세션 아이디가 존재할 경우), 실패에 따른 작업 수행 -->
			<!-- 세션 아이디가 없을 경우(null) 로그인, 회원가입 링크 표시 -->
			<!-- 세션 아이디가 있을 경우 세션 아이디, 로그아웃 링크 표시 -->
			<%if(sId == null) { %>
				<a href="MemberLoginForm.auth">로그인</a> | 
				<a href="MemberJoinForm.auth">회원가입</a>
			<%} else { %>
				<%=sId %> 님 | <a href="MemberLogout.auth">로그아웃</a>
			<%} %>
		</h5>
	</div>
	
	<h1 align="center">메인화면</h1>
	<hr>
	<h3 align="center">
		<a href="board/write_form.jsp">글쓰기</a><br>
		<a href="board/list.jsp">글목록</a>
	</h3>
</body>
</html>










