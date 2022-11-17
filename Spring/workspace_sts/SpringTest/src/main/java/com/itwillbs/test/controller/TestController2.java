package com.itwillbs.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class TestController2 {
	// 클래스 단의 RequestMapping("/main") 을 통해 먼저 매핑을 수행한 후
	// 메서드 단의 Requestmapping("/test" 를 통해 후속 매핑을 수행
	// => 결국, "/main/test" 주소가 매핑되어 test() 메서드가 호출됨
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("test() 메서드 호출됨!");
		return "";
	}
	
	// 위의 두 매핑을 하나로 결합도 가능
//	@RequestMapping("/main/test")
//	public String test() {
//		System.out.println("test() 메서드 호출됨!");
//		return "";
//	}
	
}
















