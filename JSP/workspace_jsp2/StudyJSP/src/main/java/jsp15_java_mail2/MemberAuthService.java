package jsp15_java_mail2;

import static jsp15_java_mail2.JdbcUtil.*;

import java.sql.Connection;

public class MemberAuthService {

	public boolean isAuthentication(AuthInfoDTO authInfo) {
		boolean isAuthenticationSuccess = false;
		
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		// MemberDAO 객체의 isAuthentication() 메서드를 호출하여 인증정보 비교
		// => 파라미터 : AuthInfoDTO 객체, 리턴타입 : boolean(isAuthenticationSuccess)
		isAuthenticationSuccess = dao.isAuthentication(authInfo);
		
		// 인증 성공 시 commit, 실패 시 rollback
		if(isAuthenticationSuccess) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return isAuthenticationSuccess;
	}

}










