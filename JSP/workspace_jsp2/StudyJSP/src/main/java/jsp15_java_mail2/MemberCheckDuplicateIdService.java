package jsp15_java_mail2;

import static jsp15_java_mail2.JdbcUtil.*;

import java.sql.Connection;

public class MemberCheckDuplicateIdService {

	public boolean checkDuplicateId(String id) {
		boolean isDuplicate = false;
		
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		// MemberDAO 의 selectDuplicateId() 메서드를 호출하여 아이디 검색 수행
		// => 파라미터 : 아이디(id)   리턴타입 : boolean(isDuplicate)
		isDuplicate = dao.selectDuplicateId(id);
		
		close(con);
		
		return isDuplicate;
	}

}










