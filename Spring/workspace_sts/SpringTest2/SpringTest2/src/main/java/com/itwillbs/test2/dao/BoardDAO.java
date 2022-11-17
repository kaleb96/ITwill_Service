package com.itwillbs.test2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.itwillbs.test2.vo.BoardVO;

public class BoardDAO {

	public void insert(BoardVO board) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/study_jsp2";
		String user = "root";
		String password = "1234";
		
		try {
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			// board 테이블에 데이터 추가(INSERT)
			String sql = "INSERT INTO board VALUES (null,?,?,?,?,now(),0)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getPasswd());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContent());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}













