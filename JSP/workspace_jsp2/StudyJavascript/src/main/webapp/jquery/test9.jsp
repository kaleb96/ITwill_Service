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
		// on("change", 함수() {}) 이벤트
		// 특정 대상의 '상태가 변하면' 동작하는 이벤트
		// => 주로, 셀렉트박스, 체크박스, 라디오버튼에 사용되며, 텍스트박스 입력값 변경에도 사용됨
		$("#selectBox").on("change", function() {
// 			alert("확인");
			// 셀렉트박스의 value 속성값 가져와서 출력하기
// 			alert($("#selectBox").val() + " 선택됨!");
			// 선택된 대상 구별하는 방법
			// 1) val() 함수를 통해 리턴받은 value 속성값에 대한 비교
			if($("#selectBox").val() == "VIP") {
				alert("VIP 선택됨!");
			}
		
			// --------------------------------------------------------------------------------
			// 2) 셀렉트박스 내부의 option 태그들 중 선택되는 태그를 감지
			// => 가상선택자 ":selected" 사용하여 선택됨을 감지
			if($("#selectBox > option").eq(2).is(":selected")) { // 세번째 요소 선택되었을 경우
				alert("일반 선택됨!");
			}
		});
		
		// 체크박스 체크 상태 변화 감지 이벤트
		// => 전체선택 체크박스가 체크되면 "전체선택" 출력하고, 해제되면 "전체해제" 출력
		// => 전체선택 체크박스가 체크되면 각각의 체크박스 모두 체크, 해제되면 체크박스 모두 해제
		$("#allCheck").on("change", function() {
// 			alert("체크");

			// prop() 함수를 통해 "checked" 속성값에 대한 체크 상태 판별할 경우
// 			if($("#allCheck").prop("checked")) { // 전체선택 체크 상태가 true 일 경우(= 체크)
// 				alert("전체선택");
// 			} else { // 전체선택 체크 상태가 false 일 경우(= 체크해제)
// 				alert("전체해제");
// 			}

			// is() 함수를 통해 가상선택자 ":checked" 값 선택 여부 판별
			if($("#allCheck").is(":checked")) { // 전체선택 체크 상태가 true 일 경우(= 체크)
// 				alert("전체선택");
			
				// 각 체크박스마다 체크 상태를 true 로 변경
				// => prop() 함수를 사용하여 파라미터로 "checked" 속성과 true 값 전달하여 체크
// 				$(".check").eq(0).prop("checked", true); // "check" 선택자 체크박스 중 첫 체크박스 체크
// 				$(".check").eq(1).prop("checked", true); // "check" 선택자 체크박스 중 첫 체크박스 체크
// 				$(".check").eq(2).prop("checked", true); // "check" 선택자 체크박스 중 첫 체크박스 체크

				// 실제 동작 시에는 체크박스가 몇 개 인지 상황에 따라 다르므로
				// 반복문을 통해 반복 작업으로 처리해야함
				// => each() 함수 내의 익명 함수 구현을 통해 대상에 대한 반복 작업 수행 가능
				// => 기본 문법 : $(선택자).each(function(index, item) {});
				//    (대상에 차례대로 접근하여 인덱스와 대상 요소를 파라미터로 전달받음)
				$(".check").each(function(index, item) {
// 					alert(index + " : " + item);
					// 파라미터 중 item 파라미터를 활용하여 체크박스 객체에 접근 가능
					// => 객체를 통해 직접 접근이 가능하므로 자바스크립트 형태의 제어를 수행하거나
					//    선택자 형태로 item 객체를 지정하여 prop() 함수를 통해 제어 수행
					item.checked = true; // 자바스크립트 기본 문법으로 제어
// 					$(item).prop("checked", true); // 선택자 형태로 제어
				}); 
			} else { // 전체선택 체크 상태가 false 일 경우(= 체크해제)
// 				alert("전체해제");
			
				// 각 체크박스마다 체크 상태를 false 로 변경
// 				$(".check").eq(0).prop("checked", false);
// 				$(".check").eq(1).prop("checked", false);
// 				$(".check").eq(2).prop("checked", false);

				// 가상선택자 ":checkbox" 사용 시 전체 체크박스를 대상으로 선택 가능
				$(":checkbox").each(function(index, item) {
// 					item.checked = false;
					// 단, 전체선택 체크박스를 제외하고 나머지만 체크 상태를 false 로 변경(중복되므로)
					if(index > 0) {
						item.checked = false;
					}
				});
			}
		});
		
	});
</script>
</head>
<body>
	<h1>jQuery - test9.jsp</h1>
	<table border="1">
		<tr>
			<td colspan="3">
				<select id="selectBox" name="subject">
					<option value="전체">전체</option>
					<option value="VIP">VIP</option>
					<option value="일반">일반</option>
				</select>
			</td>
		</tr>
		<tr>
			<th><input type="checkbox" id="allCheck"></th>
			<th>번호</th>
			<th>이름</th>
		</tr>
		<tr>
			<td><input type="checkbox" class="check"></td>
			<td>1</td>
			<td>홍길동</td>
		</tr>
		<tr>
			<td><input type="checkbox" class="check"></td>
			<td>2</td>
			<td>이순신</td>
		</tr>
		<tr>
			<td><input type="checkbox" class="check"></td>
			<td>3</td>
			<td>강감찬</td>
		</tr>
	</table>
</body>
</html>

















