package method;

public class Test2 {

	public static void main(String[] args) {
		// 2. 매개변수는 없고, 리턴값만 있는 메서드 호출 연습
		// getName() 메서드를 호출한 후 리턴값(자신의 이름 = 문자열)을 변수에 저장 후 출력
		String name = getName();
		System.out.println("이름 : " + name);
		
		// getAge() 메서드를 호출하여 리턴되는 나이(age)를 변수에 저장하거나 직접 출력
		System.out.println("나이 : " + getAge());
		
		// sum() 메서드를 호출하여 1 ~ 10 까지의 합을 리턴받아 변수 sum 에 저장 후 출력
		int sum = sum();
		System.out.println("1 ~ 10 까지의 합 = " + sum);
		
		// check() 메서드를 호출하여 양수 or 음수 판별 결과를 리턴받아 출력
		System.out.println(check());
	}
	
	// 2. 매개변수는 없고, 리턴값만 있는 메서드 정의 연습
	// ----------------------------------------------------
	// 정수 1개를 저장한 후 양수 or 음수를 판별하여 결과(문자열)를 리턴하는 check() 메서드 정의
	public static String check() {
		int num = 10;
		
		// 양수 or 음수 판별
//		if(num >= 0) {
//			return "양수!";
//		}
		// => 위의 코드는 if문의 판별 결과가 true 일 때만 실행되므로
		//    false 일 경우에는 실행되는 return 문이 없다! 오류 발생함!
		
//		if(num >= 0) {
//			return "양수!";
//		} else if(num < 0) {
//			return "음수!";
//		}
		// => 양수와 음수를 모두 판별하고 있지만 else 문이 없으므로
		//    두 조건이 모두 false 일 때 실행할 return 문이 없어서 오류 발생함!
		
		// 해결책1) else if 문 대신 else 문으로 처리하면 return 문이 모든 조건에서 실행됨
//		if(num >= 0) { // 0 이거나 0보다 클 경우
//			return "양수!";
//		} else { // 0 이상이 아닐 경우(= 0보다 작을 경우)이므로 else 문 사용도 가능
//			return "음수!";
//		}
		
		// 해결책2) else if 문을 사용하더라도 if문 내에서는 리턴값을 생성하기만 하고 
		//          if문 바깥에서 return 문을 실행하는 경우 모든 조건에서 return 문이 실행됨
		String result = ""; // 리턴값을 저장할 변수 선언
		
		// 조건 판별 시 return 문을 실행하지 않고, 리턴값을 변수에 저장하는 작업만 수행
		if(num >= 0) {
			result = "양수";
		} else if(num < 0) {
			result = "음수";
		}
		
		// if문과 else if문의 조건이 모두 false 라 하더라도
		// 무조건 return 문은 실행되므로 오류 발생하지 않는다!
		return result;
		
		// return 문 아래쪽에 있는 코드는 실행될 수 없음(return 문을 만나면 원래 위치로 흐름 복귀)
//		System.out.println("이 코드는 실행될까?"); // 오류 발생(Unreachable code)
		
	}
	
	// ====================================================
	// 1 ~ 10 까지의 합(정수)을 리턴하는 sum() 메서드 정의
	public static int sum() {
		int total = 0;
		
		for(int i = 1; i <= 10; i++) {
			total += i;
		}
		
		return total;
	}
	
	// ====================================================
	// 자신의 나이(정수)를 리턴하는 getAge() 메서드 정의
	public static int getAge() {
		return 20;
	}
	
	// ====================================================
	// 자신의 이름(문자열)을 리턴하는 getName() 메서드 정의
	public static String getName() {
		return "이연태";
	}
	
}
