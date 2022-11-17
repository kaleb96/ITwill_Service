package com.itwillbs.mvc_board.service;

import com.itwillbs.mvc_board.vo.MemberVO;

// 서비스 클래스 역할의 서브클래스가 정의해야할 메서드를 추상메서드 형태로 제공하는 인터페이스 정의
// => 구현체 클래스인 MemberServiceImpl 클래스에서 실제 작업(= 비즈니스 로직) 수행을 하기 위한
//    가이드라인 제공하는 역할
public interface MemberService {
	// 추상메서드 정의
	// 1. 회원 가입 작업을 수행할 joinMember() 메서드 정의
	// => 파라미터 : MemberVO(member)   리턴타입 : void
	public void joinMember(MemberVO member);
	
	
}
