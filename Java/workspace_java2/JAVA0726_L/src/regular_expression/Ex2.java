package regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 2. java.util.regex.Matcher 클래스
		 * - 패턴 해석 및 입력 문자열 일치 여부를 파악하는 클래스
		 * - Pattern 클래스와 달리 정규표현식 일치 여부만 판단하는 것이 아니라
		 *   정규표현식의 내용을 포함하는지, 위치가 어디인지 등 자세한 정보까지 파악 가능
		 * - Patterh.matcher() 메서드를 사용하여 Matcher 객체 리턴받을 수 있음
		 *   (= 공개된 생성자가 없으므로 객체 직접 생성 불가능)
		 */
		
		String src = "Java and Javascript has no relation"; // 원본 문자열
		String regex = "Java"; // 정규표현식
		
		// 1. Pattern 클래스의 compile() 메서드를 호출하여 정규표현식을 갖는 Pattern 객체 생성
		// => 파라미터 : 정규표현식 패턴 문자열
		Pattern pattern = Pattern.compile(regex);
		
		// 2. 생성된 Pattern 객체의 matcher() 메서드를 호출하여 Matcher 객체 생성
		// => 파라미터 : 검증할 원본 문자열
		Matcher matcher = pattern.matcher(src);
		// => Matcher 객체에는 정규표현식 패턴과 함께 원본 문자열이 이미 보관되어 있음
		
		// 3. Matcher 객체의 각종 메서드를 호출하여 패턴에 대한 검증 수행
		// 3-1. matches() 메서드 : 정규표현식에 완전히 부합(= 일치)되는지 검사
		System.out.println("원본문자열이 정규표현식에 완전히 부합되는가? " + matcher.matches());
		
		// 3-2. lookingAt() : 정규표현식으로 시작하는지 검사
		System.out.println("원본문자열이 정규표현식으로 시작되는가? " + matcher.lookingAt());
		
		// 주의! lookingAt() 메서드 등을 사용하여 검사를 수행한 뒤에는
		// 검사 대상의 마지막 문자 위치로 커서가 이동한 상태(인덱스가 옮겨감)
		// 따라서, 다음 검사를 실행할 때 검사에 영향을 미칠 수 있다!
		// 결과적으로 다른 검사를 연속적으로 수행하는 경우 reset() 메서드로 인덱스 초기화 필요
		matcher.reset();
		// => 만약, Matcher 객체를 매번 새로 생성하는 경우에는 reset() 메서드 호출 불필요
		
		// 3-3. find() : 정규표현식을 포함하는지 검사
		System.out.println("원본문자열이 정규표현식을 포함하는가? " + matcher.find());
	}

}












