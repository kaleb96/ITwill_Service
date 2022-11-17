package com.itwillbs.mvc_board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itwillbs.mvc_board.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	public Connection getConnection() {
		Connection con = null;
		
		try {
			// DB 작업에 필요한 문자열 선언
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/mvc_board2";
			String user = "root";
			String password = "1234";

			// 1단계. 드라이버 로드
			Class.forName(driver);
			System.out.println("드라이버 로드 성공!");

			// 2단계. DB 연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공!");
		} catch (ClassNotFoundException e) {
			// 1단계 작업(드라이버 로드) 과정 실패 시 수행할 코드를 기술하는 블록
			e.printStackTrace();
			System.out.println("드라이버 로드 실패!");
		} catch (SQLException e) {
			// 2단계 작업(DB 연결) 과정 실패 시 수행할 코드를 기술하는 블록
			e.printStackTrace();
			System.out.println("DB 연결 실패!");
		}
		
		return con;
	}
	
	// 2. 각종 DB 관련 자원을 반환하는 close() 메서드 정의 => 메서드 오버로딩 활용
	// => Connection, PreparedStatement, ResultSet
	public void close(Connection con) { // Connection 반환
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(PreparedStatement pstmt) { // PreparedStatement 반환
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(ResultSet rs) { // ResultSet 반환
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertMember(MemberVO member) {
		PreparedStatement pstmt = null;
		
		Connection con = getConnection();
		
		try {
			String sql = "INSERT INTO member VALUES (?,?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPasswd());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getPost_code());
			pstmt.setString(6, member.getAddress1());
			pstmt.setString(7, member.getAddress2());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - insertMember() 메서드 오류 : " + e.getMessage());
		} finally {
			close(pstmt);
		}
	}

}
