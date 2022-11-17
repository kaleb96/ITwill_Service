package method;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * < 메서드 정의 기본 문법 >
		 * [제한자] 리턴타입 메서드명([매개변수...]) {
		 * 		// 메서드 호출 시 수행할 코드들...
		 * 		[return [리턴값];]
		 * }
		 * 
		 * < 메서드 정의 형태 4가지 분류 >
		 * 1. 매개변수도 없고, 리턴값도 없는 메서드
		 * 2. 매개변수는 없고, 리턴값만 있는 메서드
		 * 3. 매개변수만 있고, 리턴값은 없는 메서드
		 * 4. 매개변수도 있고, 리턴값도 있는 메서드
		 */
		
		// 4. 매개변수도 있고, 리턴값도 있는 메서드 호출
		System.out.println("동생아! 1000원 줄테니 내 새우깡도 사온나!");
		String snack = sister_4(1000);
		System.out.println("동생이 사다준 것 : " + snack);
		
	} // main() 메서드 끝

	// 4. 매개변수도 있고, 리턴값도 있는 메서드 정의
	// => 전달인자(정수)가 있으므로, 정수를 전달받을 매개변수 1개 선언
	public static String sister_4(int money) {
		System.out.println("동생 : 오빠한테 " + money + "원을 받았다!");
		money -= 200;
		String snack = "새우깡";
		System.out.println("동생 : " + snack + " 사고 " + money + "원이 남았다!");
		
		// 주의! 자바 문법 구조 상 리턴값은 한 번에 하나만 지정 가능하므로
		// "새우깡" 문자열과 200 정수 중 하나만 리턴 가능하다!
		// (차후에 자료 구조 등의 클래스를 활용 시 리턴 가능)
//		return snack, money; // 사용 불가능한 문법
		return snack; // "새우깡" 만 리턴(잔돈 800원 리턴 불가!)
	}
	
} // Ex4 클래스 끝


















