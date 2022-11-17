package com.itwillbs.mvc_board.service;

import org.springframework.stereotype.Service;

import com.itwillbs.mvc_board.dao.MemberDAOImpl;
import com.itwillbs.mvc_board.vo.MemberVO;

// 가이드라인 역할을 수행하는 MemberService 인터페이스 구현체 클래스 정의
public class MemberServiceImpl implements MemberService {
	// 추상메서드를 상속받아 오버라이딩을 통해 실제 비즈니스 로직 기술
	@Override
	public void joinMember(MemberVO member) {
		// MemberDAOImpl 객체 생성 후 insertMember() 메서드 호출하여 회원 가입 작업 실행
		// => 파라미터 : MemberVO 객체
		MemberDAOImpl dao = new MemberDAOImpl();
		dao.insertMember(member);
	}

}









