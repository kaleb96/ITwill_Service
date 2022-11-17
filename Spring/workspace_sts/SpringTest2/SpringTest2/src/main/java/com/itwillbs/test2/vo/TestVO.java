package com.itwillbs.test2.vo;

// VO(Value Object) = Bean = DTO
public class TestVO {
	private String subject;
	private String content;
	
	
	// 파라미터 생성자
	public TestVO(String subject, String content) {
		super();
		this.subject = subject;
		this.content = content;
	}
	// 주의! 스프링에서 VO(DTO, Bean) 클래스 정의 시 반드시 기본 생성자 정의 필수!
	// (차후에 자동 주입 기능에서 활용되기 위함)
	// => 만약, 파라미터 생성자를 정의했을 경우 기본 생성자를 명시적으로 정의해야한다!
	public TestVO() {} // 기본 생성자
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
