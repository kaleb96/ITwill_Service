<%@page import="board.FileBoardDAO"%>
<%@page import="board.FileBoardDTO"%>
<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@page import="org.omg.CORBA.BAD_INV_ORDER"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String pass = request.getParameter("pass");

FileBoardDTO fileBoard = new FileBoardDTO();
//dto.setIdx(idx);
fileBoard.setPass(pass);

FileBoardDAO dao = new FileBoardDAO();
int deleteCount = dao.deleteFileBoard(fileBoard);
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>center/driver_delete.jsp</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/subpage.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrap">
		<!-- 헤더 들어가는곳 -->
		<jsp:include page="../inc/top.jsp" />
		<!-- 헤더 들어가는곳 -->

		<!-- 본문들어가는 곳 -->
		<!-- 본문 메인 이미지 -->
		<div id="sub_img_center"></div>
		<!-- 왼쪽 메뉴 -->
		<nav id="sub_menu">
			<ul>
				<li><a href="./notice.jsp">Notice</a></li>
				<li><a href="#">Public News</a></li>
				<li><a href="./driver.jsp">Driver Download</a></li>
				<li><a href="#">Service Policy</a></li>
			</ul>
		</nav>
		<!-- 본문 내용 -->
		<article>
			<h1>Notice Delete</h1>
			<form action="driver_deletePro.jsp" method="post">
			<input type="hidden" name="num" value="<%=request.getParameter("idx") %>">
			<input type="hidden" name="pageNum" value="<%=request.getParameter("pageNum")%>"> 
				<table id="notice">
					<tr>
						<td>패스워드</td>
						<td><%=fileBoard.getPass() %></td>
						<td><input type="password" name="pass" required="required"></td>
					</tr>
				</table>
				

				<div id="table_search">
					<input type="submit" value="글삭제" class="btn" onclick="location.href='driver_delete.jsp?idx=<%=pass%>'">
				</div>
			</form>
			<div class="clear"></div>
		</article>


		<div class="clear"></div>
		<!-- 푸터 들어가는곳 -->
		<jsp:include page="../inc/bottom.jsp" />
		<!-- 푸터 들어가는곳 -->
	</div>
</body>
</html>
