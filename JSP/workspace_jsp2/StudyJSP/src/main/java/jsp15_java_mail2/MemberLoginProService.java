package jsp15_java_mail2;

import static jsp15_java_mail2.JdbcUtil.*;

import java.sql.Connection;

public class MemberLoginProService {

	// 인증 여부 확인
	public boolean isAuthenticatedUser(MemberDTO member) {
		boolean isAuthenticatedUser = false;
		
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		isAuthenticatedUser = dao.isAuthenticatedUser(member);
		
		close(con);
		
		return isAuthenticatedUser;
	}
	
	public boolean loginMember(MemberDTO member) {
		boolean isLoginSuccess = false;
		
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		isLoginSuccess = dao.checkUser(member);
		
		close(con);
		
		return isLoginSuccess;
	}


}









