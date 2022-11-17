package method;

public class Test3 {

	public static void main(String[] args) {
		// 3. 매개변수만 있고, 리턴값은 없는 메서드 호출 연습
		// 1) 문자열 1개 전달받아 해당 문자열을 10번 반복 출력하는 print() 메서드 호출
		print("JAVA"); // "JAVA" 문자열 10번 출력
		System.out.println("-----------------------");
		
		// 정수 1개를 전달받아 매개변수 dan 에 저장 후 구구단을 출력하는 gugudan() 메서드 호출
		// => ex) 2 전달 시 구구단 2단 출력, 5 전달 시 구구단 5단 출력
		gugudan(2); // 구구단 2단 출력
		gugudan(5); // 구구단 5단 출력
		System.out.println("-----------------------");
		
		// 3) 정수 1개(x)를 전달받아 1 ~ x 까지의 합을 출력하는 sum() 메서드 호출
		// ex) 10 전달하면 1 ~ 10 까지의 합 55 출력, 100 전달하면 1 ~ 100 까지의 합 5050 출력
		sum(100); // 5050 출력
		
	} // main() 메서드 끝

	// 3. 매개변수만 있고, 리턴값은 없는 메서드 정의 연습
	// 3) 정수 1개(x)를 전달받아 1 ~ x 까지의 합을 출력하는 sum() 메서드 정의
	public static void sum(int x) {
		int total = 0; // 합계를 누적할 변수 선언
		
		for(int i = 1; i <= x; i++) {
			total += i;
		}
		
		System.out.println("1 ~ " + x + " 까지의 합 = " + total);
	}
	
	// --------------------------------------------------------------------------------------
	// 2) 정수 1개를 전달받아 매개변수 dan 에 저장 후 구구단을 출력하는 gugudan() 메서드 정의
	public static void gugudan(int dan) {
		System.out.println(" < " + dan + "단 >");
		
		for(int i = 1; i <= 9; i++) {
			System.out.println(dan + " * " + i + " = " + (dan * i));
		}
	}
	
	// --------------------------------------------------------------------------------------
	// 1) 문자열 1개 전달받아 해당 문자열을 10번 반복 출력하는 print() 메서드 정의
	public static void print(String str) {
		for(int i = 1; i <= 10; i++) {
			System.out.println(str);
		}
	}
	
} // Test3 클래스 끝














