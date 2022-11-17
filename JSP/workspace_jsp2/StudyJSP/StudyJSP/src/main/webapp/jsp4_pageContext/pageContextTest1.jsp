<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// response 내장 객체를 활용하여 pageContextTest2.jsp 페이지로 이동(= 포워딩)
// response.sendRedirect("pageContextTest2.jsp");
// => pageContextTest2.jsp 페이지로 새로운 요청이 발생하며
//    지정된 페이지로 이동 시 웹브라우저 주소 표시줄의 주소(URL)가 pageContextTest2.jsp 로 변경됨
// => 이처럼, 새로운 요청에 의해 포워딩 시 주소표시줄의 주소가 변경되는 포워딩 방식을
//    "Redirect 방식" 의 포워딩이라고 한다!
// => 포워딩 결과 : http://localhost:8080/StudyJSP/jsp4_pageContext/pageContextTest2.jsp
// ----------------------------------------------------------------------------------------------
// 또 다른 내장 객체인 pageContext 객체의 forward() 메서드를 호출하여 
// pageContextTest2.jsp 페이지로 이동(= 포워딩)
pageContext.forward("pageContextTest2.jsp");
// => pageContextTest1.jsp 페이지에서 pageContextTest2.jsp 페이지로 포워딩 요청 발생하여
//    지정된 페이지로 이동 시 주소표시줄의 주소(URL)가 pageContextTest2.jsp 로 변경되지 않고
//    기존의 주소인 pageContextTest1.jsp 주소가 그대로 유지됨
// => 이처럼, 새로운 주소로 요청 시 기존 요청 주소가 그대로 유지되는(변경되지 않는) 포워딩 방식을
//    "Dispatcher 방식" 의 포워딩이라고 한다!
// => 포워딩 결과 : http://localhost:8080/StudyJSP/jsp4_pageContext/pageContextTest1.jsp
//    (단, 웹브라우저 화면에 표시되는 실제 내용은 요청된 pageContextTest2.jsp 내용이 표시됨)
// ----------------------------------------------------------------------------------------------
// 위의 두 가지 포워딩 방식(response.sendRedirect() & pageContext.forward()) 모두
// 지정한 페이지로 이동할 때 제어권도 함께 넘어가기 때문에
// 해당 코드 이후의 코드들은 실행되지 못한다!
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 윗쪽의 포워딩 코드로 인해 실행되지 못하는 코드들 -->
	<h1>pageContextTest1.jsp</h1>
	<script type="text/javascript">
		alert("확인!");
	</script>
</body>
</html>