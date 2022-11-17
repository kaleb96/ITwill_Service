package com.itwillbs.mvc_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwillbs.mvc_board.service.MemberService;
import com.itwillbs.mvc_board.service.MemberServiceImpl;
import com.itwillbs.mvc_board.vo.MemberVO;

@Controller
public class MemberController {
	@RequestMapping(value = "/MemberJoinForm.me", method = RequestMethod.GET)
	public String join() {
		// 현재 서블릿 주소가 "루트/MemberJoinForm.me" 이므로
		// 뷰페이지의 루트인 views 디렉토리에서 출발하는 상대경로 지정
		return "member/member_join";
	}
	
	@RequestMapping(value = "/MemberCheckIdForm.me", method = RequestMethod.GET)
	public String checkId() {
		return "member/check_id";
	}
	
	// 회원 가입 폼에서 입력받은 데이터를 자동 주입을 통해 MemberVO 객체로 관리
	// => MemberVO 타입 파라미터 선언부 앞에 @ModelAttribute 어노테이션 사용하여 표시(생략 가능)
	@RequestMapping(value = "/MemberJoinPro.me", method = RequestMethod.POST)
	public String joinPro(@ModelAttribute MemberVO member) {
//		System.out.println(member);
		
		// MemberServiceImpl 객체 생성 후 joinMember() 메서드를 호출하여 회원 가입 작업 요청
		// => 파라미터 : MemberVO 객체(member)
		MemberServiceImpl service = new MemberServiceImpl();
		service.joinMember(member);
		
		return "";
	}
}















