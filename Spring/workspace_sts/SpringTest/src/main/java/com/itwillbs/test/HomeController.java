package com.itwillbs.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
		// => servlet-context.xml 파일에 정의된 설정에 의해
		//    "/WEB-INF/views/" 디렉토리명과 "home" 파일명과 ".jsp" 확장자가 결합되어 파일 지정
		//    즉, "/WEB-INF/views/home.jsp" 경로와 동일한 문자열이 생성됨
		// => Dispatcher 방식으로 포워딩
	}
	
	// "/myservlet" 요청 시 views 디렉토리 내의 test.jsp 페이지로 포워딩(Dispatcher 방식)
	@RequestMapping(value = "/myservlet")
	public String test() {
		return "test";
	}
	
}













