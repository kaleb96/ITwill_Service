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
	특정 요소에 대한 조작 이벤트 - 2
	1. append()
	   - 지정한 내용을 선택자 내부의 '마지막'에 추가
	   - appendTo() 함수와 문장 구조의 차이를 제외하면 기능은 동일함
	   - $('선택자').append('추가할내용');
	     $('추가할내용').appendTo('선택자');
	2. prepend()
	   - 지정한 내용을 선택자 내부의 '처음'에 추가
	   - prependTo() 함수와 문장 구조의 차이를 제외하면 기능은 동일함
	   - $('선택자').prepend('추가할내용');
	     $('추가할내용').prependTo('선택자');
	3. after()
	   - 지정한 내용을 선택자 요소 '뒤'에 삽입
	   - insertAfter() 함수와 문장 구조의 차이를 제외하면 기능은 동일함
	   - $('선택자').after('삽입할내용');
	     $('삽입할내용').insertAfter('선택자');
	4. before()
	   - 지정한 내용을 선택자 요소 '앞'에 삽입
	   - insertBefore() 함수와 문장 구조의 차이를 제외하면 기능은 동일함
	   - $('선택자').before('삽입할내용');
	     $('삽입할내용').insertBefore('선택자');
	*/
	$(function() {
		$("#wrap_append").append("<div>append() 로 삽입한 div 태그</div>");
		// => #wrap_append 선택자 내부 div 태그들의 아래(가장 마지막)쪽에 추가됨
// 		$("<div>appendTo() 로 삽입한 div 태그</div>").appendTo("#wrap_append");
		
		$("#wrap_prepend").prepend("<div>prepend() 로 삽입한 div 태그</div>");
		// => #wrap_prepend 선택자 내부 div 태그들의 위(가장 처음)쪽에 추가됨
// 		$("<div>prependTo() 로 삽입한 div 태그</div>").prependTo("#wrap_prepend");
		
		$("#wrap_after").after("<div>after() 로 삽입한 div 태그</div>");
		// => wrap_after 선택자 외부에서 해당 선택자 다음 요소로 추가됨
// 		$("<div>insertAfter() 로 삽입한 div 태그</div>").insertAfter("#wrap_after");
		
		$("#wrap_before").before("<div>before() 로 삽입한 div 태그</div>");
		// => wrap_before 선택자 외부에서 해당 선택자 이전 요소로 추가됨
// 		$("<div>insertBefore() 로 삽입한 div 태그</div>").insertBefore("#wrap_before");
		
		// 적용 결과 확인을 위해 textarea(id="ta") 에 id 가 "wrap" 인 div 태그 내용 전체 출력
		$("#ta").val($("#wrap").html());
	});
</script>
</head>
<body>
	<h1>jQuery - test5.jsp</h1>
	<div id="wrap">
		<div id="wrap_append">
			<div>
				<div>div 태그1</div>
				<div>div 태그2</div>
			</div>
		</div>
		<hr>
		<div id="wrap_prepend">
			<div>
				<div>div 태그1</div>
				<div>div 태그2</div>
			</div>
		</div>
		<hr>
		<div id="wrap_after">
			<div>
				<div>div 태그1</div>
				<div>div 태그2</div>
			</div>
		</div>
		<hr>
		<div id="wrap_before">
			<div>
				<div>div 태그1</div>
				<div>div 태그2</div>
			</div>
		</div>
	</div>
	<!-- 결과 확인을 위한 태그 출력용 textarea -->
	<textarea rows="20" cols="100" id="ta"></textarea>
</body>
</html>
















