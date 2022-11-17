package com.itwillbs.mvc_board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.itwillbs.mvc_board.mapper.MemberMapper;
import com.itwillbs.mvc_board.vo.MemberVO;

// 서비스 클래스 용도의 클래스 표시를 위한 @Service 어노테이션 지정
// => 객체 자동 주입 기능에 활용됨
@Service
public class MemberService {
	// MyBatis 의 SQL 구문 실행을 담당할 XXXMapper.xml 파일과 연동된 XXXMapper 객체 자동 주입 설정
	// MemberMapper 객체 자동 주입을 위한 @Autowired 어노테이션 설정
	@Autowired
	private MemberMapper mapper;
	
	// 추상메서드를 상속받아 오버라이딩을 통해 실제 비즈니스 로직 기술
	// 1. 회원 가입
	public int joinMember(MemberVO member) {
//		System.out.println("MemberService - joinMember()");
		
		// Mapper 객체의 메서드를 호출하여 SQL 구문 실행 요청(DAO 객체 없이 바로 실행)
		// => Mapper 객체의 메서드 실행 후 리턴되는 값을 받아 저장하거나
		//    직접 return 문을 통해 리턴값을 바로 리턴
		//    단, 리턴값이 없을 경우 메서드 호출 코드만 기술
		//    만약, 추가적인 작업이 필요한 경우에는 메서드 호출과 리턴값 리턴 작업을 분리
//		int insertCount = mapper.insertMember(member);
//		return insertCount;
		
		// 스프링시큐리티의 BCryptPasswordEncoder 를 활용한 단방향 암호화
		// BCryptPasswordEncoder 객체 생성
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		// BCryptPasswordEncoder 객체의 encode() 메서드를 호출하여 해싱
		// => 파라미터로 평문 암호 전달
		String securePasswd = encoder.encode(member.getPasswd());
//		System.out.println(securePasswd.length() + " : " + securePasswd);
		// 암호문을 MemberVO 객체에 저장
		member.setPasswd(securePasswd);
		
		return mapper.insertMember(member);
	}

	// 2. 로그인
	// => 파라미터 : MemberVO 객체, 리턴타입 : MemberVO
	public MemberVO loginMember(MemberVO member) {
		// Mapper 객체의 selectLoginMember() 메서드를 호출하여 로그인 작업 요청
		return mapper.selectLoginMember(member);
	}

	// 3. 회원 상세정보 조회
	// => 파라미터 : 아이디(id)  리턴타입 : MemberVO
	public MemberVO getMemberInfo(String id) {
		// Mapper 객체의 selectMemberInfo() 메서드를 호출하여 회원 정보 조회 작업 요청
		return mapper.selectMemberInfo(id);
	}

	// 4. 전체 회원 목록 조회
	// 파라미터 : 없음    리턴타입 : List<MemberVO>(memberList)
	public List<MemberVO> getMemberList() {
		// Mapper 객체의 selectMemberList() 메서드를 호출하여 회원 목록 조회 작업 요청
		return mapper.selectMemberList();
	}

	// 암호화 된 패스워드 가져오기
	// => 파라미터 : MemberVO 객체, 리턴타입 : MemberVO(memberResult)
	public MemberVO getPasswd(MemberVO member) {
		// Mapper 객체의 selectPasswd() 메서드를 호출하여 아이디에 해당하는 패스워드 가져오기 
		return mapper.selectPasswd(member);
	}

}









