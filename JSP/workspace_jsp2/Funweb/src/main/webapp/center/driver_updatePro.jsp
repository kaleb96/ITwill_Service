<%@page import="board.FileBoardDAO"%>
<%@page import="board.FileBoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@page import="board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
//파라미터 가져와서 변수에 저장 및 확인
FileBoardDTO fileBoard = new FileBoardDTO();
fileBoard.setIdx(Integer.parseInt(request.getParameter("idx")));
fileBoard.setName(request.getParameter("name"));
fileBoard.setPass(request.getParameter("pass"));
fileBoard.setSubject(request.getParameter("subjent"));
fileBoard.setContent(request.getParameter("content"));

//BoardDAO객체의 checkPass()메서드를 호출하여 작성자가 입력한 패스워드 확인
//=>board테이블 idx가 일치하는 게시물의 패스워드 비교
//=>파라미터 : 글번호(idx), 리턴타입  : boolean(isCorrectPass)
FileBoardDAO dao = new FileBoardDAO();
boolean isCorrectPass = dao.checkPass(fileBoard);

//만약, 패스워드가 일치하지 않으면 자바스크립트를 통해 "수정 권한이 없습니다." 출력 후 이전페이지
//아니면, 글 수정 작업 수행
if(!isCorrectPass) {
	%>
	<script>
		alert("수정 권한이 없습니다!");
		history.back();
	</script>
	<%
} else {
	// BoardDAO 객체의 updateBoard() 메서드를 호출하여 글 수정 작업 수행
	// => 파라미터 : BoardDTO 객체, 리턴타입 : int(updateCount)
	int updateCount = dao.updateFileBoard(fileBoard);
	
	// 글 수정 실패 시 자바스크립트를 통해 "수정 실패!" 출력 후 이전페이지
	// 아니면, notice_content.jsp 페이지 포워딩(글번호와 페이지번호 전달)
	if(updateCount == 0) {
		%>
		<script>
			alert("수정 실패!");
			history.back();
		</script>
		<%
	} else {
		response.sendRedirect("driver_content.jsp?idx=" + fileBoard.getIdx() + "&pageNum=" + request.getParameter("pageNum"));
	}
}
    
//BoardDAO 객체의 updateBoard()메서드를 호출하여 글 수정 작업 수행
//=>파라미터 : BoardDTO객체, 리턴타입 : int(updateCount)



//글 수정 실패 시 자바스크립트를 통해 "수정 실패!" 출력 후 이전페이지
//아니면, notice_content.jsp페이지 포워딩
%>
