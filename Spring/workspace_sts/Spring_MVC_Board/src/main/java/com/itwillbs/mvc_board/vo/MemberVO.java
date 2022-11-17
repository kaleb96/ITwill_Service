package com.itwillbs.mvc_board.vo;
import java.sql.Date;

/*
 [ 회원 테이블(member) ]
 이름(name) - 20글자, NN
 아이디(id) - 16글자, PK
 비밀번호(passwd) - 16글자, NN
 이메일(email) - 50글자, UN, NN
 우편번호(post_code) - 5글자, NN
 주소1(address1) - 50글자, NN
 주소2(address2) - 50글자, NN
 가입일(hire_date) - 날짜, NN
 ------------------------------
 CREATE TABLE member (
 	name VARCHAR(20) NOT NULL,
 	id VARCHAR(16) PRIMARY KEY,
 	passwd VARCHAR(16) NOT NULL,
 	email VARCHAR(50) UNIQUE NOT NULL,
 	post_code VARCHAR(5) NOT NULL,
 	address1 VARCHAR(50) NOT NULL,
 	address2 VARCHAR(50) NOT NULL,
 	hire_date DATE NOT NULL
 );
 */
public class MemberVO {
	private String name;
	private String id;
	private String passwd;
	private String email;
	// 실제 폼 파라미터명과 동일한 email1, email2 멤버변수 선언 필요
	// => Getter/Setter 를 활용하여 email 멤버변수로 변환 과정 추가
	private String email1;
	private String email2;
	private String post_code;
	private String address1;
	private String address2;
	private Date hire_date;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		
		// email 문자열을 분리하여 email1 과 email2 에 저장
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
		
		// email1, email2 문자열 결합 후 email 에 저장
		email = email1 + "@" + email2;
	}
	public String getPost_code() {
		return post_code;
	}
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
	
	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", id=" + id + ", passwd=" + passwd + ", email=" + email + ", post_code="
				+ post_code + ", address1=" + address1 + ", address2=" + address2 + ", hire_date=" + hire_date + "]";
	}
	
	
	
}









