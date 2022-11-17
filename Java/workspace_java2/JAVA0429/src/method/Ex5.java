package method;

public class Ex5 {

	public static void main(String[] args) {
		// 추가사항) 3-2. 매개변수가 2개 이상인 메서드
		// => 단, 리턴값은 무관함
		System.out.println("동생아! 새우깡과 1000원 줄테니 쿠쿠다스로 바꿔온나!");
		String snack = sister_5("새우깡", 1000);
		System.out.println("동생이 바꿔다 준 것 : " + snack);
		
	} // main() 메서드 끝
	
	// 전달인자가 2개 이상일 경우 전달된 순서대로 매개변수에 저장되므로
	// 전달인자의 순서와 타입에 맞게 매개변수도 선언해야한다!
	// ex) 문자열, 정수 형태의 전달인자일 경우 String, int 형태의 변수 선언 필수!
	public static String sister_5(String snack, int money) {
		System.out.println("동생 : 오빠가 과자 바꿔오라고 " + snack + " & " + money + "원을 줬다!");
		snack = "쿠쿠다스";
		money -= 1000;
		System.out.println("동생 : " + snack + " 바꿈!");
		
		return snack;
	}

} // Ex5 클래스 끝

















