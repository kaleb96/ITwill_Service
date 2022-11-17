package regular_expression;

import java.util.regex.Pattern;

public class Ex {

	public static void main(String[] args) {
		/*
		 * 정규표현식을 활용하는 클래스
		 * 1. java.util.regex.Pattern 클래스
		 *    - 정규표현식 패턴 문자열을 컴파일해서 객체 형태로 관리하는 클래스
		 *    - 해당 객체를 활용하여 전체 문자열이 정규표현식 패턴에 부합되는지(= 일치) 매칭 여부 판별
		 *      ex) 전화번호 형식 검증, 패스워드 길이 검증 등
		 *          => 단, 패스워드 길이 외의 복잡도(부분 규칙) 검사 불가
		 *    - 공개된 생성자는 없으며, Pattern.compile() 메서드를 통해 Pattern 객체를 리턴받아 사용
		 *    
		 * 2. java.util.regex.Matcher 클래스
		 */
		
		// 1. 전화번호 양식 검증
		// 1-1. 전화번호 검증에 사용될 정규표현식 패턴 문자열 작성
		// => 주의! 예외 문자(\ 기호를 사용) 사용 시 자바의 이스케이프 문자로 인식되지 않도록 \\ 형태로 작성
		String phoneRegex = "^(010|011)[-\\s]?\\d{3,4}[-\\s]?\\d{4}$";
		/*
		 * 1) ^(010|011) : 010 또는 011 로 시작
		 * 2) [-\s]? : - 기호 또는 공백이 포함될 수도 있고, 포함되지 않을 수도 있음
		 * 3) \d{3,4} : 숫자 3자리 또는 4자리
		 * 4) \d{4}$ : 숫자 4자리로 끝
		 */
		
		String phone = "010-1234-5678";
		// 1-2. Pattern 클래스의 static 메서드인 matches() 메서드를 사용하여 판별
		// => 파라미터 : 정규표현식 패턴 문자열, 검증할 원본 문자열
		//    리턴타입 : boolean
//		boolean result = Pattern.matches(phoneRegex, phone);
//		System.out.println(phone + " 검증 결과 : " + result);
		
		if(Pattern.matches(phoneRegex, phone)) {
			System.out.println(phone + " : 정상적인 번호입니다!");
		} else {
			System.out.println(phone + " : 잘못된 번호입니다!");
		}
		
	}

}





















