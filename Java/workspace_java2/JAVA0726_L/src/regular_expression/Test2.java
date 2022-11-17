package regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * Pattern 클래스와 Matcher 클래스를 활용하여 
		 * 입력된 패스워드에 대한 규칙(= 패스워드 복잡도) 검사
		 * 
		 * 규칙1. 패스워드 길이 : 영문자, 숫자, 특수문자(!@#$%) 조합 8 ~ 16자리
		 * 
		 */
		
		String[] passwords = {"Abcde123!", "abcde123@", "abcde123", "12345678", "abcde한글!"};
		
		// 패스워드 길이를 판별하는 정규표현식
		// => 영문자, 숫자, 특수문자(!@#$%) 조합 8 ~ 16자리(시작과 끝 포함)
		String lengthRegex = "^[A-Za-z0-9!@#$%]{8,16}$";
		
		// 부분 검사 수행을 위한 정규표현식(대문자, 소문자, 숫자, 특수문자)
		String engUpperRegex = "[A-Z]"; // 대문자
		String engLowerRegex = "[a-z]"; // 소문자
		String numRegex = "[0-9]"; // 숫자(\\d 도 가능)
		String specRegex = "[!@#$%]"; // 특수문자(!@#$%)
		
		// 패스워드 배열만큼 반복
		for(String password : passwords) {
			// 패스워드 길이 규칙 검사 => Pattern.matches() 메서드 활용
			if(Pattern.matches(lengthRegex, password)) { // 길이체크 정규표현식 패턴과 일치할 경우
//				System.out.println(password + " : 길이 규칙 적합!");
				
				// 패스워드 길이 체크를 통과했을 경우
				// 각 패턴(영문 대문자, 소문자, 숫자, 특수문자)이 포함되는지 부분 검사 수행
				// => 검사 결과를 포인트화하여 패스워드 복잡도(안전, 보통, 위험) 계산 용으로 사용
				int count = 0;
				
				// 검사할 정규표현식 패턴 문자열을 사용하여 Pattern 객체 생성 및
				// Pattern 객체로 Matcher 객체를 생성하여 검사
//				Pattern pattern = Pattern.compile(engUpperRegex); // 대문자 검사 정규표현식
//				Matcher matcher = pattern.matcher(password); // 검사할 패스워드
				// Matcher 객체의 find() 메서드로 해당 정규표현식이 포함되는지를 검사하여
				// 포함될 경우 포인트(count 변수) 1 증가시킴
//				if(matcher.find()) {
//					count++;
//				}
				
				// Pattern 객체 생성과 Matcher 객체 생성 및 find() 메서드 호출을 하나로 결합
//				if(Pattern.compile(engUpperRegex).matcher(password).find()) {
//					count++;
//				}
//				
//				// 주의! 다음 정규표현식을 추가로 검사하는 경우 else if 사용하면 안된다!
//				if(Pattern.compile(engLowerRegex).matcher(password).find()) {
//					count++;
//				}
//				
//				if(Pattern.compile(numRegex).matcher(password).find()) {
//					count++;
//				}
//				
//				if(Pattern.compile(specRegex).matcher(password).find()) {
//					count++;
//				}
				
				// 삼항연산자(?:) 를 사용하여 동일한 작업 수행
				// => 판별 결과가 true 이면 +1, 아니면 +0
				count += Pattern.compile(engLowerRegex).matcher(password).find() ? 1 : 0;
				count += Pattern.compile(engUpperRegex).matcher(password).find() ? 1 : 0;
				count += Pattern.compile(numRegex).matcher(password).find() ? 1 : 0;
				count += Pattern.compile(specRegex).matcher(password).find() ? 1 : 0;
				
//				System.out.println(password + " 패스워드 복잡도 검사 결과 : " + count);
				
				// 점수에 따른 패스워드 복잡도 검사 결과 판별 후 출력
				switch (count) {
					case 4 :
						System.out.println(password + " : 안전!");
						break;
					case 3 :
						System.out.println(password + " : 보통!");
						break;
					case 2 :
						System.out.println(password + " : 위험!");
						break;
					default :
						System.out.println(password + " : 사용 불가능한 패스워드! (2가지 이상 조합 필수)");
				}
				
			} else { // 길이체크 정규표현식 패턴과 일치하지 않을 경우
				System.out.println(password + " : 영문자, 숫자, 특수문자 조합 8~16자 필수!");
			}
			
		}
		
	}

}















