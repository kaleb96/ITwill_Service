package jsp15_java_mail2;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLoginProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberLoginProAction");
		
		ActionForward forward = null;
		
//		String id = request.getParameter("id");
//		String passwd = request.getParameter("passwd");
		MemberDTO member = new MemberDTO();
		member.setId(request.getParameter("id"));
		member.setPasswd(request.getParameter("passwd"));
		
		MemberLoginProService service = new MemberLoginProService();
		
		// 로그인 작업 수행 전 인증여부 먼저 확인하기 위해
		// MemberLoginProService 객체의 isAuthenticatedUser() 메서드를 호출
		// => 파라미터 : MemberDTO 객체, 리턴타입 : boolean(isAuthenticatedUser)
		boolean isAuthenticatedUser = service.isAuthenticatedUser(member);
		
		// 인증여부 확인 결과에 대한 판별 작업 수행
		// => 미인증 회원의 경우 로그인 작업을 수행하지 않고 인증 요청메세지 출력(로그인 불가)
		if(!isAuthenticatedUser) { // 인증을 수행하지 않은 회원인 경우
			// 자바스크립트를 사용하여 "이메일 인증을 먼저 수행하세요!" 메세지 출력 후 이전페이지
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('이메일 인증을 먼저 수행하세요!')");
			out.println("history.back()");
			out.println("</script>");
		} else { // 인증을 수행한 회원인 경우
			// 로그인 작업 수행
			boolean isLoginSuccess = service.loginMember(member);
			
			// 로그인 실패 시 자바스크립트를 통해 "로그인 실패" 출력 후 이전페이지로 돌아가기
			// 아니면, 세션에 로그인 아이디를 "sId" 속성으로 저장 후 메인페이지 포워딩
			if(!isLoginSuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인 실패!')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				// request 객체로부터 HttpSession 객체(세션) 가져와서 아이디 저장
				HttpSession session = request.getSession();
				session.setAttribute("sId", member.getId());
				
				// 메인페이지로 포워딩
				forward = new ActionForward();
				forward.setPath("Main.auth");
				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}















