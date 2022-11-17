package method;

public class Test5 {

	public static void main(String[] args) {
		// 매개변수가 2개 이상인 메서드 호출 연습
		// 1) 문자열 1개와 정수 1개를 전달받아 문자열을 정수만큼 반복 출력하는 메서드 호출
		print("Hello, World!", 5); // "Hello, World!" 문자열 5번 반복 출력
		print("JAVA", 3); // "JAVA" 문자열 3번 반복 출력
		System.out.println("------------------------------------");
		
		// 2) 정수 2개를 전달받아 최대값을 판별하여 최대값을 리턴하는 max() 메서드 호출
		// ex) 10, 20 전달하면 20 리턴
		int maxNum = max(10, 20); // 10 < 20 이므로 20 리턴됨
		System.out.println("최대값 : " + maxNum);
		System.out.println("최대값 : " + max(100, 100)); // 두 수가 같으므로 코드 상 두번째 숫자 리턴됨
		
		// 실제 자바에서 미리 만들어놓은 클래스와 메서드를 활용하여 최대값 계산 가능
		System.out.println("최대값 : " + Math.max(50, 20));
		
	}

	// 매개변수가 2개 이상인 메서드 정의 연습
	// 2) 정수 2개를 전달받아 최대값을 판별하여 최대값을 리턴하는 max() 메서드 정의
	public static int max(int num1, int num2) {
		// if문을 사용하여 두 정수의 크기 비교
		if(num1 > num2) { // num1 이 더 클 경우
			return num1;
		} else { // num2 가 더 크거나 두 수가 같을 경우
			// 만약, 두 숫자가 같을 경우에는 "동일한 숫자입니다!" 출력
			if(num1 == num2) {
				System.out.println("동일한 숫자입니다!");
			}
			
			return num2;
		}
		
	}
	
	// -------------------------------------------------------------------------------
	// 1) 문자열 1개와 정수 1개를 전달받아 문자열을 정수만큼 반복 출력하는 메서드 정의
	public static void print(String str, int count) {
		for(int i = 1; i <= count; i++) {
			System.out.println(str);
		}
	}
	
}
