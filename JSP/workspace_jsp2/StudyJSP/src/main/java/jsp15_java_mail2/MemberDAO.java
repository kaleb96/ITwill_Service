package jsp15_java_mail2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static jsp15_java_mail2.JdbcUtil.*;

public class MemberDAO {
	// 1. 멤버변수 선언 및 인스턴스 생성
	private static MemberDAO instance = new MemberDAO();
	// 2. 생성자 정의
	private MemberDAO() {}
	// 3. Getter 정의(자동 생성)
	public static MemberDAO getInstance() {
		return instance;
	}
	// ----------------------------------------------------------------------------------------
	// 외부(Service 클래스)로부터 Connection 객체를 전달받아 관리하기 위해
	// Connection 타입 멤버변수와 Setter 메서드 정의
	private Connection con;
	public void setConnection(Connection con) {
		this.con = con;
	}
	// ----------------------------------------------------------------------------------------

	// 회원 추가 작업을 수행하는 insertMember() 메서드 정의
	// => 파라미터 : MemberDTO, 리턴타입 : int(insertCount)
	public int insertMember(MemberDTO dto) {
		int insertCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			// 3단계. SQL 구문 작성 및 전달
			String sql = "INSERT INTO auth_member VALUES (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPasswd());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getGender());
			pstmt.setString(6, "N"); // 인증 여부 기본값 "N" 설정
			
			// 4단계. SQL 구문 실행 및 결과 처리
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 반환
			close(pstmt);
		}
		
		return insertCount;
	}
	
	// 로그인 수행 전 인증 여부를 판별하는 메서드
	public boolean isAuthenticatedUser(MemberDTO member) {
		boolean isAuthenticatedUser = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// auth_member 테이블에서 아이디가 일치하는 레코드의 인증상태(auth_status)를 조회
			String sql = "SELECT auth_status FROM auth_member WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 아이디에 해당하는 인증상태가 존재할 경우
				// 인증상태(auth_status) 값이 "Y" 인지 판별
				if(rs.getString("auth_status").equals("Y")) {
					isAuthenticatedUser = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return isAuthenticatedUser;
	}
	
	// 로그인 작업 수행하는 checkUser() 메서드 정의
	// => 파라미터 : MemberDTO 객체, 리턴타입 : boolean(isLoginSuccess)
	public boolean checkUser(MemberDTO dto) {
		boolean isLoginSuccess = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 3단계. SQL 구문 작성 및 전달
			// => 전달받은 아이디, 패스워드를 사용하여 일치하는 레코드 조회
			String sql = "SELECT * FROM auth_member WHERE id=? AND passwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			
			// 4단계. SQL 구문 실행 및 결과 처리
			rs = pstmt.executeQuery();
			
			// ResultSet 객체의 다음 레코드가 존재할 경우 = 로그인 성공
			if(rs.next()) {
				// 조회 성공 시(= 로그인 성공) isLoginSuccess 값을 true 로 변경
				isLoginSuccess = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 반환
			close(rs);
			close(pstmt);
		}
		
		return isLoginSuccess;
	}
	
	// 인증코드 등록 작업 수행
	// => 파라미터 : 아이디, 인증코드   리턴타입 : int(registCount)
	public int registAuthCode(String id, String authCode) {
		int registCount = 0;
		
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		
		try {
			// 전달받은 ID 에 대한 기존 인증코드가 존재하는지 확인 후
			// 만약, 기존 인증코드가 존재하면 새 인증코드로 덮어쓰고(UPDATE),
			// 아니면, 아이디와 인증코드를 새로 등록(INSERT)
			String sql = "SELECT auth_code FROM auth_info WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 기존 인증코드가 이미 존재하는 경우
				// UPDATE 구문을 사용하여 인증코드 갱신(새로운 인증코드로 덮어씀)
				sql = "UPDATE auth_info SET auth_code=? WHERE id=?";
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setString(1, authCode);
				pstmt2.setString(2, id);
				registCount = pstmt2.executeUpdate();
				System.out.println("인증코드 갱신 성공!");
			} else { // 기존 인증코드가 존재하지 않는 경우
				// INSERT 구문을 사용하여 아이디와 인증코드 추가
				sql = "INSERT INTO auth_info VALUES (?,?)";
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setString(1, id);
				pstmt2.setString(2, authCode);
				registCount = pstmt2.executeUpdate();
				System.out.println("인증코드 등록 성공!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(pstmt2);
		}
		
		return registCount;
	}
	
	public boolean isAuthentication(AuthInfoDTO authInfo) {
		boolean isAuthenticationSuccess = false;
		
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		
		try {
			// 전달받은 AuthInfoDTO 객체의 인증정보(아이디, 인증코드)를 사용하여
			// auth_info 테이블의 인증 정보와 비교
			// => 결과가 일치하면 isAuthenticationSuccess 를 true 로 변경
			String sql = "SELECT * FROM auth_info WHERE id=? AND auth_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, authInfo.getId());
			pstmt.setString(2, authInfo.getAuthCode());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 조회 성공 시 인증 코드가 일치
				// auth_member 테이블 중 id 가 일치하는 레코드의 auth_status 값을 'Y' 로 변경하고
				// auth_info 테이블 중 id 가 일치하는 레코드 삭제
				sql = "UPDATE auth_member SET auth_status='Y' WHERE id=?";
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setString(1, authInfo.getId());
				int updateCount = pstmt2.executeUpdate();
				
				sql = "DELETE FROM auth_info WHERE id=?";
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setString(1, authInfo.getId());
				int deleteCount = pstmt2.executeUpdate();
				
				// updateCount 또는 deleteCount 가 둘 다 0보다 크면 인증성공여부를 true 로 변경
				if(updateCount > 0 && deleteCount > 0) {
					isAuthenticationSuccess = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return isAuthenticationSuccess;
	}
	
	
	
}














