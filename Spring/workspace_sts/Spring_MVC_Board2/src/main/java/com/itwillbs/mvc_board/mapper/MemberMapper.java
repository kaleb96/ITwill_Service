package com.itwillbs.mvc_board.mapper;

import java.util.List;

import com.itwillbs.mvc_board.vo.MemberVO;

// Service 객체에서 사용할(호출할) 메서드 형태를 추상메서드로 정의(DAO 클래스 대체)
// => 정의된 추상메서드는 XML(MemberMapper.xml 파일) 에서 활용됨
public interface MemberMapper {
	// 1. 회원 가입에 필요한 insertMember() 메서드 정의
	// => 파라미터 : MemberVO(member), 리턴타입 : int
	public int insertMember(MemberVO member);

	// 2. 로그인에 필요한 selectLoginMember() 메서드 정의
	// => 파라미터 : MemberVO(member), 리턴타입 : MemberVO
	public MemberVO selectLoginMember(MemberVO member);

	// 3. 회원 상세정보 조회에 필요한 selectMemberInfo() 메서드 정의
	// => 파라미터 : 아이디(id)  리턴타입 : MemberVO
	public MemberVO selectMemberInfo(String id);

	
	// 4. 회원 목록 조회에 필요한 selectMemberList() 메서드 정의
	// => 파라미터 : 없음   리턴타입 : List<MemberVO>
	public List<MemberVO> selectMemberList();

	// 5. 추가) 암호화 된 패스워드를 통한 로그인에 필요한 패스워드 가져오기
	// => 파라미터 : MemberVO 객체, 리턴타입 : MemberVO(memberResult)
	public MemberVO selectPasswd(MemberVO member);
	
	
}









