<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	/*
	DOM 객체 탐색 및 접근을 통해 조작하는 방법(이벤트)
	=> on("이벤트명", 익명함수() {}) 형식을 사용
	
	1. on("click", 함수)
	- 특정 대상을 "클릭" 시 동작하는 이벤트
	- $("선택자").click(함수) 함수 호출하는 것과 동일하나 다른 이벤트들과 같은 방법으로 처리 가능
	*/
	$(function() {
		// 모든 버튼에 click 이벤트 연결
		// 1) click() 함수 호출
// 		$("input[type=button]").click(function() {
// 			alert("버튼 클릭!");
// 		});
	
		// 가상 선택자 :button 사용 시 <input> 태그 버튼과 <button> 버튼 구분없이 모든 버튼 지정
// 		$(":button").click(function() {
// 			alert("버튼 클릭!");
// 		});
		
		// 2) on("click") 함수 호출
// 		$(":button").on("click", function() {
// // 			alert("버튼 클릭! - on()");
			
// 			// 버튼들 중에서 클릭된 버튼을 구분하는 방법 : 포커스가 주어진 버튼 탐색
// 			// => 가상선택자 :focus 를 사용하여 포커스가 주어진 요소 선택하고 value 속성값 확인
// 			alert($(":button:focus").val() + "버튼 클릭! - on()");
// 		});
		
		// -----------------------------------------------------------
		// 첫번째 버튼(확인)에만 click 이벤트 연결
		// => 각 입력 항목 요소의 value 속성값 가져와서 #resultArea 에 출력
		// => 셀렉트박스의 옵션들 중 선택 항목 값 가져올 때 가상선택자 :selected 사용 가능
		$(":button").eq(0).on("click", function() {
			$("#resultArea").html(
				"아이디 : " + $("input[name=id]").val() + "\n"
				+ "패스워드 : " + $("input[name=password]").val() + "\n"
				+ "선택과목 : " + $("#selectBox > option:selected").val()
			);
		});
		
		// 버튼 외의 항목도 클릭이 가능
		$("#clickDiv").on("click", function() {
			alert("div 태그 클릭됨!");
		});
		
		// 특정 요소에 포커스가 주어질 때 동작하는 이벤트 : "focus"
		$("#resultArea").on("focus", function() {
			$("#resultArea").html("textarea focus in");
		});
		
		// 특정 요소에 포커스가 해제될 때 동작하는 이벤트 : "blur"
		$("#resultArea").on("blur", function() {
			$("#resultArea").html("textarea focus out");
		});
	});
</script>
</head>
<body>
	<h1>jQuery - test8.jsp</h1>
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
	<textarea rows="5" cols="20" id="resultArea"></textarea>
	<br>
	<input type="button" value="확인">
	<input type="button" value="취소">
	<br>
	=====<div id="clickDiv">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>=====
</body>
</html>








