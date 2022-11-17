<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	function getTime() {
		// Date 객체를 활용하여 현재 시스템의 시각 정보를 "시:분:초" 로 리턴
		var now = new Date();
		var hour = now.getHours();
		var min = now.getMinutes();
		var sec = now.getSeconds();
		
		return hour + " : " + min + " : " + sec;
	}
	
	$(function() {
		var isStop = false; // 인터벌 동작을 중지시킬 중지 신호를 저장하는 변수 선언
		
		// 시계 표시 버튼 클릭 시 현재 시각(getTime() 함수 리턴값)을 timer 선택자 위치에 표시
		$("input[type=button]").eq(0).on("click", function() {
			$("#timer").html("<h1>" + getTime() + "</h1>");

			// 어떤 작업을 정해진 인터벌(Interval)에 맞춰 반복해야할 경우
			// => setInterval() 함수로 시작하고 clearInterval() 함수로 중단
			// 1) setInterval(함수() {}, 시간간격); => 시간간격은 ms(밀리초, 1/1000초) 단위로 지정
			//    ex) setInterval(function() {}, 1000); => 1초마다 함수 내의 코드 실행
			// 2) clearInterval(반복 중단할 객체);
			//    => 주로, setInterval() 내의 익명함수 내에서 조건에 따라 clearInterval() 함수 호출하고
			//       파라미터로 setInterval() 함수 내의 익명함수를 this 로 전달
			
			isStop = false; // 버튼을 누를때마다 false 값으로 설정하기 위함
			
			// 시계 표시 작업을 1초마다 수행(= 시계 갱신)
			setInterval(function() {
				// 단, 타이머 중단 신호(isStop)가 false 일 때만 타이머 갱신 
				if(!isStop) {
					$("#timer").html("<h1>" + getTime() + "</h1>");
				} else {
					// setInterval() 함수를 통해 반복되는 작업 중단하기 위해 clearInterval() 함수 호출
					// => 이 때, 현재 익명함수 객체를 파라미터로 전달
					clearInterval(this);
				}
			}, 1000);
			
			
		});
		
		// 시계 제거 버튼 클릭 시 표시된 시각을 제거(= timer 선택자 내의 요소 제거) = empty()
		$("input[type=button]").eq(1).on("click", function() {
			$("#timer").empty(); // 선택자는 제외하고 선택자 내의 요소만 제거
			// setInterval() 을 통해 동작되는 타이머를 중단하기 위한 중단신호 설정(true 로 변경)
			// => 반복 작업을 수행하는 객체 외부에서 반복 작업을 중지시키는 방법
			isStop = true;
		});
	});
	
</script>
</head>
<body>
	<h1>jQuery - test10.jsp</h1>
	<input type="button" value="시계 표시"> <input type="button" value="시계 제거">
	<div id="timer">
		<!-- 시간이 표시될 공간 -->
	</div>
</body>
</html>












