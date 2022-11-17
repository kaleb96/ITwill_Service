<%@page import="board.FileBoardDTO"%>
<%@page import="board.FileBoardDAO"%>
<%@page import="board.BoardDAO"%>
<%@page import="board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
FileBoardDTO fileBoard = new FileBoardDTO();
fileBoard.setIdx(Integer.parseInt(request.getParameter("idx")));
fileBoard.setPass(request.getParameter("pass"));

//BoardDAO 객체의 checkPass() 메서드를 재사용하여 삭제 권한 판별
//=> 파라미터 : BoardDTO 객체, 리턴타입 : boolean(isCorrectPass)
FileBoardDAO dao = new FileBoardDAO();
boolean isCorrectPass = dao.checkPass(fileBoard);

//삭제 권한이 없을 경우 자바스크립트를 통해 "삭제 권한이 없습니다!" 출력 후 이전페이지로 돌아가기
//아니면, BoardDAO 객체의 deleteBoard() 메서드를 호출하여 삭제
//=> 파라미터 : BoardDTO 객체, 리턴타입 : int(deleteCount)
if(!isCorrectPass) {
	%>
	<script>
		alert("삭제 권한이 없습니다!");
		history.back();
	</script>
	<%
} else {
	// BoardDAO 객체의 updateBoard() 메서드를 호출하여 글 수정 작업 수행
	// => 파라미터 : BoardDTO 객체, 리턴타입 : int(updateCount)
	int deleteCount = dao.deleteFileBoard(fileBoard);
	
	// 글 수정 실패 시 자바스크립트를 통해 "삭제 실패!" 출력 후 이전페이지
	// 아니면, 글목록(notice.jsp) 페이지 포워딩
	if(deleteCount == 0) {
		%>
		<script>
			alert("삭제 실패!");
			history.back();
		</script>
		<%
	} else {
		response.sendRedirect("driver.jsp?idx=" + fileBoard.getIdx() + "&pageNum=" + request.getParameter("pageNum"));
	}
}
%> 
