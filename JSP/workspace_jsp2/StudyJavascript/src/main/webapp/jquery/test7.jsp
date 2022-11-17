<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(function() {
		/*
		submit() 함수
		- submit 동작에 대한 이벤트 처리 가능
		- 자바스크립트에서 submit 이벤트 처리하는 작업과 동일함
		- form 태그 요소를 대상으로 지정하여 submit() 함수를 호출하고
		  함수 내에 익명 함수를 구현하여 submit 버튼 클릭 시 수행할 동작을 지정
		*/
		$("form").submit(function() {
			// 셀렉트박스의 option 태그들 중 첫번째 option 태그의 selected 속성 상태 확인
// 			alert($("#selectBox > option").eq(0).prop("selected"));
// 			alert($("#selectBox > option[value=선택하세요]").prop("selected"));

			// 만약, 첫번째 항목 선택 시 "항목 선택 필수!" 메세지 출력 후 submit 동작 취소
			// 아니면, submit 동작 수행
			if($("#selectBox > option").eq(0).prop("selected")) {
				alert("항목 선택 필수!");
				return false;
			} else { // 다른 항목 선택 시
				return true;
			}
		});
	});
</script>
</head>
<body>
	<h1>jQuery - test7.jsp</h1>
	<form action="test7_result.jsp">
		<div id="inputBox">
			아이디 : <input type="text" name="id"><br>
			패스워드 : <input type="password" name="password">
		</div>
		<select id="selectBox" name="subject">
			<option value="선택하세요">선택하세요</option>
			<option value="자바">자바</option>
			<option value="JSP">JSP</option>
			<option value="스프링">스프링</option>
		</select>
		<br>
		<input type="submit" value="전송">
	</form>
</body>
</html>













