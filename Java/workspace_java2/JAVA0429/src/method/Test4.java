package method;

public class Test4 {

	public static void main(String[] args) {
		// 4. 매개변수도 있고, 리턴값도 있는 메서드 호출 연습
		// 1) 정수 1개(x)를 전달받아 1 ~ x 까지의 합을 계산하여 리턴하는 sum() 메서드 호출
		// => 호출한 곳에서 리턴받은 값을 변수에 저장 후 출력
		int sum = sum(100); // 5050 리턴됨
		System.out.println("합계 = " + sum);
		
		System.out.println("합계 = " + sum(10));
		
		System.out.println("--------------------------");
		
		// 2) 정수 1개(num) 를 전달받아 "양수", "음수" 를 리턴하는 check() 메서드 호출
		// => 리턴 결과를 전달받아 출력
		String result = check(-5);
		System.out.println(result);
		
	}
	
	// 4. 매개변수도 있고, 리턴값도 있는 메서드 정의 연습
	// 2) 정수 1개(num) 를 전달받아 "양수", "음수" 를 리턴하는 check() 메서드 정의(0은 양수에 포함)
	public static String check(int num) {
		String result = "";
		
		if(num >= 0) {
			result = "양수";
		} else if(num < 0) {
			result = "음수";
		}
		
		return result;
	}
	
	// -------------------------------------------------------------------------------
	// 1) 정수 1개(x)를 전달받아 1 ~ x 까지의 합을 계산하여 리턴하는 sum() 메서드 정의
	public static int sum(int x) {
		int total = 0; // 합계를 누적할 변수 선언
		
		for(int i = 1; i <= x; i++) {
			total += i;
		}
		
		// 합계 리턴
		return total;
	}
	
}










