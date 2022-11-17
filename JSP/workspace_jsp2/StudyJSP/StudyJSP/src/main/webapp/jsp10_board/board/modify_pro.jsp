<%@page import="jsp10_board.BoardDAO"%>
<%@page import="jsp10_board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
int idx = Integer.parseInt(request.getParameter("idx"));
// String name = request.getParameter("name");
// String passwd = request.getParameter("passwd");
// String subject = request.getParameter("subject");
// String content = request.getParameter("content");
// out.println(idx + ", " + name + ", " + passwd + ", " + subject + ", " + content); 

// BoardDTO 객체에 폼파라미터 데이터 저장
BoardDTO dto = new BoardDTO();
dto.setIdx(idx);
dto.setName(request.getParameter("name"));
dto.setPasswd(request.getParameter("passwd"));
dto.setSubject(request.getParameter("subject"));
dto.setContent(request.getParameter("content"));

// BoardDAO 객체의 update() 메서드 호출하여 게시물 수정 작업 요청
// => 패스워드가 틀렸을 경우 등 실패 여부를 판단하기 위해 int 타입 값 리턴받기
// => 파라미터 : BoardDTO 객체   리턴타입 : int(updateCount)
BoardDAO dao = new BoardDAO();
int updateCount = dao.update(dto);

// 수정 작업 결과 판별
// => 만약, updateCount 가 0일 경우 실패이므로
//    자바스크립트 통해 "패스워드 틀림!" 출력 후 이전페이지로 돌아가기
// => 아니면, 성공이므로 detail.jsp 페이지로 포워딩
if(updateCount == 0) {
	%>
	<script>
		alert("패스워드 틀림!");
		history.back();
	</script>
	<%
} else {
	response.sendRedirect("detail.jsp?idx=" + idx);
}
%>











