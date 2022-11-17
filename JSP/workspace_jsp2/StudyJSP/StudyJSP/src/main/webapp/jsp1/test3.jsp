<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
// -----------------------------------------------------------------
// 이 곳은 JSP 선언문(Declaration) 으로 JSP 파일 전체에서 사용 가능한
// 멤버변수(전역변수)를 선언하거나 및 메서드를 정의하는 곳입니다.
// => 자바클래스의 멤버레벨(= 클래스 내부, 메서드 외부)에 
//    변수 및 메서드가 위치하는 것과 동일
// => 또는, 자바스크립트 <script> 태그 내에 변수 및 함수 정의와 동일
String str1 = "멤버(전역) 변수입니다."; // 멤버변수 선언

public void method1() { // 메서드 정의
	System.out.println("선언문 내의 method1() 메서드 호출됨!");
}

// "method2() 메서드의 리턴값" 문자열을 리턴하는 method2() 정의
public String method2() {
	return "method2() 메서드의 리턴값";
}
// -----------------------------------------------------------------
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test3.jsp</h1>
	<%--
	표현식 <%= %>
	- 선언문 또는 스크립틀릿에서 선언된 변수에 접근하여 값을 출력하거나
	  메서드를 호출 후 리턴되는 리턴값을 출력할 수 있다!
	- 자바 코드에서의 System.out.print() 메서드와 동일한 역할을 수행
	  단, System.out.print() 메서드는 이클립스의 콘솔에 데이터를 출력하지만
	  표현식은 웹페이지 내에 출력하므로 out.print() 와 동일한 역할 수행
	--%>
	<h3>전역변수 str1 = <%=str1 %></h3> <!-- 표현식 내부의 변수 값을 웹브라우저에 출력 -->
	<h3>method2() 메서드 리턴값 = <%=method2() %></h3> <!-- method2() 메서드 리턴값을 출력 -->
	
	<%-- 
	스크립틀릿 <% %>
	- 자바 문장을 그대로 표현 가능한 블럭
	- 스크립틀릿 내부는 자바에서 메서드 내부와 동일한 위치
	  => 메서드 내에서 수행 가능한 작업들을 스클립틀릿 내부에 기술 가능
	  => 스크립틀릿 내부의 코드는 자동 생성된 클래스 내의 jsp_service() 메서드 내에 코드로 변환됨
	  => 스크립틀릿 내부에 선언된 변수는 로컬(지역) 변수로 취급됨
	  => 스크립틀릿 내부에는 메서드를 정의할 수 없음
	--%>
	
	<%-- 스크립틀릿에서 선언되는 변수보다 윗쪽(앞쪽)에서 해당 변수 접근 불가 --%>
<%-- 	<!-- <h3>로컬변수 str2 = <%=str2 %></h3> --> --%>
	<%-- 주의! 만약, 위의 표현식 코드가 포함된 문장을 HTML 주석 처리할 경우 오류 발생! --%>
	
	<%
	// 이 곳은 스크립틀릿 내부입니다.
	// 따라서, 자바의 메서드 내부와 동일한 성격을 가짐
	// 변수 선언이 가능하며, 해당 변수는 로컬 변수로 취급됨
	String str2 = "로컬(지역)변수입니다!";
	
	// 스크립틀릿 내부에서는 다른 메서드를 호출하거나 객체 생성 등의 다양한 작업 가능
	// => 선언문에서 정의한 method1() 메서드 호출
	method1();
	
	// JSP 파일의 스크립틀릿 내부에서 out.print() 또는 println() 메서드로 웹브라우저 출력 가능
	// => HTML 형식의 문법도 모두 적용됨
	out.println("<h3>이 문장은 웹브라우저에 출력됩니다.</h3>");
	System.out.println("이 문장은 이클립스 콘솔에 출력됩니다.");
	
	// out.println() 메서드로 str2 변수값을 웹브라우저에 출력
// 	out.println(str2); // 자바코드이므로 자바 변수는 변수명만 그대로 지정하여 접근 가능

	// 스크립틀릿 내에서는 메서드 정의 불가(메서드 내에 메서드 정의 불가)
// 	public void method3() {} // 오류 발생
	%>
	
	<h3>로컬변수 str2 = <%=str2 %></h3>
	
	<%-- 선언문보다 윗쪽(앞쪽)에서 멤버변수에 접근할 경우 --%>
	<h3>멤버변수 str3 = <%=str3 %></h3>
	
	<%-- 선언문 내에서 str3 변수 선언하고 "멤버변수 str3 입니다" 문자열 초기화 --%>
	<%! String str3 = "멤버변수 str3 입니다"; %>
	
	<h3>멤버변수 str3 = <%=str3 %></h3>
	
</body>
</html>














