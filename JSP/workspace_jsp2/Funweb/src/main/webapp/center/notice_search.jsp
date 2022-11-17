<%@page import="java.util.ArrayList"%>
<%@page import="org.omg.CORBA.BAD_INV_ORDER"%>
<%@page import="board.BoardDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 검색어(keyword) 가져오기
String keyword = request.getParameter("keyword");

// BoardDAO 객체의 selectBoardList() 메서드를 호출하여 게시물 조회
// => 단, 메서드 오버로딩을 통해 동일한 이름으로 검색어를 포함하는 메서드 호출 
// => 파라미터 : 검색어, 현재 페이지 번호, 페이지 당 게시물 수
// => 리턴타입 : List(ArrayList 객체)
BoardDAO dao = new BoardDAO();
List list = new ArrayList();
List boardList = dao.selectBoardList(keyword, pageNum, listLimit);

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>





