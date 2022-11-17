package com.itwillbs.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	// main() 메서드 정의 => 파라미터 없음, 리턴타입 String
	// => "main" 문자열 리턴
	// => "/main" 서블릿 주소 매핑 - POST 방식 요청 처리
	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public String main() { // POST 방식 요청 중 서블릿 주소 "/main" 요청 시 자동으로 호출
		// 주의! GET 방식으로 요청 시 HTTP 상태코드 405 에러 발생!
		return "main";
	}
	
	// GET 방식 요청으로 전달받은 "/board/write" 서블릿 요청에 대해
	// /WEB-INF/views/board 디렉토리 내의 write.jsp 페이지 지정
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		return "board/write"; // "/WEB-INF/views/board/write.jsp"
	}
	
	// GET 방식 요청으로 전달받은 "*.me" 패턴 서블릿 요청에 대해 처리할 member() 메서드 정의
	@RequestMapping(value = "*.me", method = RequestMethod.GET)
	public String member() {
		System.out.println("*.me 서블릿 요청됨!");
		return "";
	}
	
}










