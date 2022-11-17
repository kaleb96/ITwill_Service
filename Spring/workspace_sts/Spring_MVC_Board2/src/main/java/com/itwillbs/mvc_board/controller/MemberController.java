package com.itwillbs.mvc_board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.mvc_board.service.MemberService;
import com.itwillbs.mvc_board.vo.MemberVO;

// 컨트롤러 역할을 수행하는 클래스 표시를 위한 @Controller 어노테이션 지정
@Controller
public class MemberController {
	// Service 객체를 직접 생성하지 않고 자동 주입 기능을 위한 어노테이션 사용
	// => @Inject(자바-플랫폼공용) 또는 @Autowired(스프링 전용) 어노테이션 중 선택 가능
	// => 어노테이션을 지정한 후 자동 주입으로 객체 생성 후 저장할 클래스 타입 변수 선언
	@Autowired
	private MemberService service;
	
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
	public String joinPro(@ModelAttribute MemberVO member, Model model) {
//		System.out.println(member);
		
		// MemberServiceImpl 객체 생성 후 joinMember() 메서드를 호출하여 회원 가입 작업 요청
		// => 파라미터 : MemberVO 객체(member)
//		MemberService service = new MemberService();
		
		// @Autowired 어노테이션으로 객체가 자동 주입되므로 객체 생성하지 않고도 메서드 호출 가능
		int insertCount = service.joinMember(member);
		
		// 가입 성공/실패에 따른 포워딩 설정
		if(insertCount > 0) { // 성공
			System.out.println("가입 성공!");
			
			// 메인페이지(index.jsp)로 이동
			return "redirect:/";
		} else { // 실패
			System.out.println("가입 실패!");
			
			// Model 객체에 "msg" 속성명으로 "가입 실패!" 문자열 저장 후
			// Dispatcher 방식으로 fail_back.jsp 페이지로 포워딩
			model.addAttribute("msg", "가입 실패!");
			
			// => 오류 메세지 출력 후 이전페이지로 돌아가는 작업을 수행하는 공통 페이지로 이동
			return "fail_back";
		}
		
	}
	
	// MemberLoginForm.me 서블릿 요청에 대한 member_login.jsp 페이지 포워딩(GET, Dispatcher)
	@RequestMapping(value = "/MemberLoginForm.me", method = RequestMethod.GET)
	public String login() {
		return "member/member_login";
	}
	
	// MemberLoginPro.me 서블릿 요청(POST 방식)에 대한 매핑 => loginPro() 메서드
	// 로그인 폼을 통해 전달받은 id, passwd 를 저장하기 위한 MemberVO 타입 파라미터 선언
	// 실패 시 메세지 저장을 위해 Model 타입 파라미터 선언
	// 성공 시 세션 아이디 저장을 위해 HttpSession 타입 파라미터 선언
	@RequestMapping(value = "/MemberLoginPro.me", method = RequestMethod.POST)
	public String loginPro(@ModelAttribute MemberVO member, Model model, HttpSession session) {
		// MemberService 객체의 loginMember() 메서드를 호출
		// => 파라미터 : MemberVO 객체, 리턴타입 : MemberVO(memberResult)
		//		MemberVO memberResult = service.loginMember(member);
		// -----------------------------------------------------------------------------
		// BCryptPasswordEncoder 클래스를 활용하여 암호화 된 패스워드 비교 작업 추가를 위해
		// MemberService 객체의 getPasswd() 메서드를 호출하여 암호화 된 패스워드 가져오기
		// => 파라미터 : MemberVO 객체, 리턴타입 : MemberVO(memberResult)
		MemberVO memberResult = service.getPasswd(member);
		// -----------------------------------------------------------------------------
		// SELECT 구문을 통해 조회 결과를 리턴받았을 때
		// 리턴받은 객체(MemberVO 타입 memberResult)가 null 이면 로그인 실패, 아니면 성공
		// => 로그인 실패 시 Model 객체에 "msg" 속성명으로 "로그인 실패!" 메세지 저장 후
		//    fail_back.jsp 페이지로 포워딩
		// => 로그인 성공 시 세션 객체에 "sId" 라는 속성명으로 로그인 아이디 저장 후 
		//    메인페이지로 포워딩
		// -----------------------------------------------------------------------------
		// BCryptPasswordEncoder 클래스를 활용하여 암호화 된 패스워드 비교 작업 추가
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// BCryptPasswordEncoder 객체의 matches() 메서드를 호출하여 두 패스워드 비교
		// => 파라미터 : 로그인 할 패스워드(평문), DB 에 저장된 패스워드(암호문)
		// => 평문을 동일한 Salt 값으로 단방향 암호화를 수행하여 두 패스워드 비교
		if(memberResult == null || !encoder.matches(member.getPasswd(), memberResult.getPasswd())) {
			model.addAttribute("msg", "로그인 실패!");
			return "fail_back";
		} else {
			System.out.println(memberResult);
			session.setAttribute("sId", memberResult.getId());
			return "redirect:/";
		}
	}
	
	// MemberLogout.me 서블릿 요청(GET)에 대한 로그아웃 처리 작업 수행 후 메인페이지로 포워딩
	@RequestMapping(value = "/MemberLogout.me", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// MemberInfo.me 서블릿 요청(GET) 에 해당 회원 정보 조회 작업 수행 - getMemberInfo()
	// => 파라미터 : HttpSession(session), Model(model)
	@RequestMapping(value = "/MemberInfo.me", method = RequestMethod.GET)
	public String getMemberInfo(HttpSession session, Model model) {
		// 세션 아이디 가져와서 String 타입 변수 id 에 저장
		String id = (String)session.getAttribute("sId");
		
		// 만약, 세션 아이디가 없을 경우 "잘못된 접근입니다!" 메세지를 저장 후 fail_back.jsp 로 이동
		if(id == null) {
			model.addAttribute("msg", "잘못된 접근입니다!");
			return "fail_back";
		} else {
			// 세션 아이디 있을 경우 Service 객체의 getMemberInfo() 메서드 호출하여
			// 조회된 회원 정보를 MemberVO 객체로 리턴받은 후 Model 객체에 저장("member")한 뒤
			// member/member_info.jsp 페이지로 포워딩(Dispatcher 방식)
			// => 파라미터 : 아이디(id)   리턴타입 : MemberVO(member)
			MemberVO member = service.getMemberInfo(id);
			
			model.addAttribute("member", member);
			
			return "member/member_info";
		}
		
	}
	
	// AdminMain.me 서블릿 요청(GET)에 대한 회원 목록 조회 작업 수행 - getMemberList()
	// => 세션 아이디가 없거나 세션 아이디가 "admin" 이 아닐 경우
	//    fail_back.jsp 페이지로 포워딩(메세지 : "잘못된 접근입니다!")
	// => 아니면, Service 객체의 getMemberList() 메서드를 호출하여 전체 회원 목록 조회 후
	//    조회된 객체 저장("memberList")한 뒤 member/member_list.jsp 페이지로 포워딩
	//    파라미터 : 없음    리턴타입 : List<MemberVO>(memberList)
	@RequestMapping(value = "/AdminMain.me", method = RequestMethod.GET)
	public String getMemberList(HttpSession session, Model model) {
		// 세션 아이디 가져와서 String 타입 변수 id 에 저장
		String id = (String)session.getAttribute("sId");
		
		// 만약, 세션 아이디가 없거나 "admin" 이 아닐 경우 "잘못된 접근입니다!" 메세지를 저장 후 fail_back.jsp 로 이동
		if(id == null || !id.equals("admin")) {
			model.addAttribute("msg", "잘못된 접근입니다!");
			return "fail_back";
		} else {
			// Service 객체의 getMemberList() 메서드를 호출하여 전체 회원 목록 조회
			// 파라미터 : 없음    리턴타입 : List<MemberVO>(memberList)
			List<MemberVO> memberList = service.getMemberList();
			
			// 조회 결과를 Model 객체에 저장("memberList")
			model.addAttribute("memberList", memberList);
			
			return "member/member_list";
		}
	}
	
}















