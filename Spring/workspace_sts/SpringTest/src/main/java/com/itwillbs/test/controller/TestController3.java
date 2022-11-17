package com.itwillbs.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class TestController3 {
	// 클래스단의 매핑 URL 패턴이 Wildcard(*) 로 끝나는 경우
	// 해당 와일드카드를 메서드 명으로 활용 가능

	public String login() {
		System.out.println("로그인 기능!");
		return "";
	}

	public String logout() {
		System.out.println("로그아웃 기능!");
		return "";
	}

	public String join() {
		System.out.println("회원가입 기능!");
		return "";
	}
	
}
















