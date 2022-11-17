<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	// check_id.html 파일을 새창에서 열기
	function checkDuplicateId() {
		window.open("check_id.jsp", "check_id", "width=400,height=300");
	}
	
	// 아이디 길이 판별
	function checkIdLength() {
		// 입력된 아이디가 4자리 ~ 8자리 사이가 아닐 경우
		if(document.fr.id.value.length < 4 || document.fr.id.value.length > 8) {
			alert("아이디는 4~8자리 필수!");
			document.fr.id.select();
		}
	}
	
	// 비밀번호 길이 판별
	function checkPasswdLength() {
		// 입력된 패스워드가 8자리 ~ 16자리 사이가 아닐 경우
		if(document.fr.passwd.value.length < 8 || document.fr.passwd.value.length > 16) {
			alert("패스워드는 8~16자리 필수!");
			document.fr.passwd.select();
		}
	}
	
	// 비밀번호 & 비밀번호확인란이 같은지 판별(패스워드확인란 글자 입력할 때마다 호출 = onkeyup)
	function checkConfirmPasswd() {
		// 결과를 표시할 span 태그 영역 객체 가져오기
		let confirmPasswdResult = document.getElementById("confirmPasswdResult");
		
		// 입력된 두 패스워드 가져오기
		let passwd = document.fr.passwd.value;
		let passwd2 = document.fr.passwd2.value;
		
		// 두 패스워드 비교
		if(passwd == passwd2) {
			confirmPasswdResult.innerHTML = "비밀번호 일치";
			confirmPasswdResult.style.color = "GREEN";
		} else {
			confirmPasswdResult.innerHTML = "비밀번호 불일치";
			confirmPasswdResult.style.color = "RED";
		}
	}
	
	// 주민번호 길이 체크 후 포커스 이동
	function checkJumin1() {
		if(document.fr.jumin1.value.length == 6) { // 6자리 입력 시
			// jumin2 항목으로 포커스 이동
			document.fr.jumin2.focus();
		}
	}
	
	function checkJumin2() {
		if(document.fr.jumin2.value.length == 7) { // 7자리 입력 시
			// jumin2 항목에서 포커스 해제
// 			document.fr.jumin2.blur();
			// 또는 email1 항목으로 포커스 이동
			document.fr.email1.focus();
		}
	}
	
	// 이메일 도메인 선택 시 email2 영역에 선택된 도메인 표시
	function changeDomain() {
		document.fr.email2.value = document.fr.emailDomain.value;
	}
	
	// 취미의 전체선택 체크박스 선택 시 모든 항목 체크, 전체선택 체크 해제 시 모든 항목 체크 해제
	function checkAll() {
		// 전체선택 체크박스 체크 상태 판별
		if(document.fr.check_all.checked) { // 체크
			// hobby 체크박스는 복수개의 항목이 배열로 관리되므로 hobby[인덱스] 로 접근 가능
			document.fr.hobby[0].checked = true;
			document.fr.hobby[1].checked = true;
			document.fr.hobby[2].checked = true;
		} else { // 체크 해제
// 			document.fr.hobby[0].checked = false;
// 			document.fr.hobby[1].checked = false;
// 			document.fr.hobby[2].checked = false;

			// for문(for...of)을 사용하여 작업 시
			for(let item of document.fr.hobby) {
				item.checked = false;
			}
		}
	}
	
	// submit 버튼 클릭 시 모든 입력 항목에 대한 확인 작업
	function checkForm() {
		// 입력되지 않은 항목이 있을 경우 해당 항목 입력 요청 메세지 출력 및 포커스 요청
		if(document.fr.name.value == "") { // document.fr.name.value.length == 0 과 동일 
			alert("이름 입력 필수!");
			document.fr.name.focus();
		} else if(document.fr.id.value == "") {
			alert("아이디 입력 필수!");
			document.fr.id.focus();
		} else if(document.fr.passwd.value == "") {
			alert("패스워드 입력 필수!");
			document.fr.passwd.focus();
		} else if(document.fr.passwd2.value == "") {
			alert("패스워드 확인 입력 필수!");
			document.fr.passwd2.focus();
		} else if(document.fr.jumin1.value == "") {
			alert("주민번호 앞자리 입력 필수!");
			document.fr.jumin1.focus();
		} else if(document.fr.jumin2.value == "") {
			alert("주민번호 뒷자리 입력 필수!");
			document.fr.jumin2.focus();
		} else if(document.fr.email1.value == "") {
			alert("email 계정명 입력 필수!");
			document.fr.email1.focus();
		} else if(document.fr.email2.value == "") {
			alert("email 도메인 입력 필수!");
			document.fr.email2.focus();
		} else if(document.fr.job.value == "") { // selectedIndex == 0 과 동일
			alert("직업 선택 필수!");
			document.fr.job.focus();
		} else if(!document.fr.gender[0].checked && !document.fr.gender[1].checked) {
			alert("성별 선택 필수!");
			document.fr.gender.focus();
		} else {
			// 모든 항목 입력 완료 시 true 리턴하여 submit 동작
			return true;
		}
		
		// 하나라도 입력되지 않은 경우 공통적으로 false 리턴하여 submit 동작 취소
		return false;	
	}
</script>
</head>
<body>
	<!-- id 중복확인 버튼 클릭 시 새 창 띄우기(check_id.html 파일 열기)  -->
	<h1>회원가입</h1>
	<form action="join_pro.jsp" method="post" name="fr" onsubmit="return checkForm()">
		<table border="1">
			<tr><td>이름</td><td><input type="text" name="name"></td></tr>
			<tr>
				<td>ID</td>
				<td>
					<input type="text" name="id" placeholder="4 ~ 8글자 사이 입력" 
							onchange="checkIdLength()">
					<input type="button" value="ID중복확인" onclick="checkDuplicateId()">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="passwd" placeholder="8 ~ 16글자 사이 입력" 
							onchange="checkPasswdLength()">
				</td>
			</tr>
			<tr>
				<td>비밀번호확인</td>
				<td>
					<input type="password" name="passwd2" onkeyup="checkConfirmPasswd()">
					<span id="confirmPasswdResult"></span>
				</td>
			</tr>
			<tr>
				<td>주민번호</td>
				<td>
					<input type="text" name="jumin1" onkeyup="checkJumin1()"> -
					<input type="text" name="jumin2" onkeyup="checkJumin2()">
				</td>
			</tr>
			<tr>
				<td>E-Mail</td>
				<td>
					<input type="text" name="email1">@
					<input type="text" name="email2">
					<select name="emailDomain" onchange="changeDomain()">
						<option value="">직접입력</option>
						<option value="naver.com">naver.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="nate.com">nate.com</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>직업</td>
				<td>
					<select name="job">
						<option value="">항목을 선택하세요</option>
						<option value="개발자">개발자</option>
						<option value="DB엔지니어">DB엔지니어</option>
						<option value="관리자">관리자</option>
						<option value="기타">기타</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="gender" value="남">남
					<input type="radio" name="gender" value="여">여
				</td>
			</tr>
			<tr>
				<td>가입동기</td>
				<td><textarea name="content" cols="40" rows="10"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="가입">
					<input type="reset" value="초기화">
					<input type="button" value="돌아가기" onclick="history.back()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

















    