package jsp15_java_mail2;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberAuthAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberAuthAction");
		ActionForward forward = null;
		
		AuthInfoDTO authInfo = new AuthInfoDTO();
		authInfo.setId(request.getParameter("id"));
		authInfo.setAuthCode(request.getParameter("authCode"));
//		System.out.println(authInfo.getId() + ", " + authInfo.getAuthCode());
		
		// MemberAuthService 객체의 selectAuthInfo() 메서드를 호출하여 인증정보 비교
		// => 파라미터 : AuthInfoDTO 객체, 리턴타입 : boolean(isAuthenticationSuccess)
		MemberAuthService memberAuthService = new MemberAuthService();
		boolean isAuthenticationSuccess = memberAuthService.isAuthentication(authInfo);
		
		if(!isAuthenticationSuccess) { // 인증 실패 시
			// 자바스크립트를 사용하여 "인증 실패!" 출력 후 이전페이지로 돌아가기
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('인증 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else { // 인증 성공 시
			// 로그인 페이지(MemberLoginForm.auth)로 이동
			// 자바스크립트를 사용하여 "인증 실패!" 출력 후 이전페이지로 돌아가기
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('인증 성공! - 로그인 페이지로 이동합니다.')");
			out.println("location.href = 'MemberLoginForm.auth'");
			out.println("</script>");
		}
		
		return forward;
	}

}















