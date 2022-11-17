package wrapper_class;

import java.util.Arrays;

public class Test5 {

	public static void main(String[] args) {
		/*
		 * 문자열을 char[] 배열에 분리하여 저장 후
		 * 해당 문자열에 대한 간단한 암호화 작업
		 * - 문자열을 분리하여 저장한 배열을 메서드 encrypt()에 전달
		 * - 전달받은 배열의 문자에 대해 아스키코드값 3만큼 증가한 문자를
		 *   별도의 배열에 저장한 후 문자열로 변환하여 리턴
		 *   ex) 'A'(65) -> 'D'(68)
		 *   ex) "Hello" -> 'H', 'e', 'l', 'l', 'o' 형태로 배열에 저장됨
		 *       암호화 작업 결과물 : 'K', 'h', 'o', 'o', 'r' 이고
		 *       리턴되는 데이터 : "Khoor"
		 */
//		char[] chArr = { 'H', 'e', 'l', 'l', 'o' };
		
		// String 변수를 선언 후 초기화
		String str = "admin123";
		
		// String 타입 문자열을 char 타입 배열로 변환 : toCharArray() 사용
		char[] chArr = str.toCharArray();
		
		
		// 인스턴스 생성
		Test5 ex = new Test5();
				
		// encrypt() 메서드를 호출하여 배열 chArr 을 전달하고,
		// 리턴되는 배열을 전달받아 반복문으로 모든 문자 출력
		// ex) 'H', 'e', 'l', 'l', 'o' 가 저장된 배열 전달 시
		//     'K', 'h', 'o', 'o', 'r' 문자를 결합한 문자열을 리턴받아 출력
		
		// String 타입 변수 encryptResult에 encrypt 메서드 호출 후 리턴되는 값 대입
		String encryptRestult = ex.encrypt(chArr);
		
		// 출력예시
		// 암호화 전 : 'H', 'e', 'l', 'l', 'o'
		// 암호화 후 : 'K', 'h', 'o', 'o', 'r'
		System.out.println("암호화 전 : " + Arrays.toString(chArr));
		System.out.println("암호화 후 : " + encryptRestult);
		
		
	} // main 메서드 끝
	
	// public String encrypt 메서드
	// 암호화 작업 수행
	// => 전달받은 배열 내의 모든 문자 값을 +3 하여 새 배열에 저장 후
	//    문자열로 결합하여 리턴
	// => 전달받은 배열의 크기를 새 배열의 크기로 지정
	// ※ 전달받은 = 매개변수가 존재
	public String encrypt(char[] chArr) {
		// 전달받은 배열과 크기가 같은 새 배열 설정
		char[] encryptArr = new char[chArr.length];
		
		for(int i = 0; i < chArr.length; i++) {
			// 각 배열의 문자 +3 수행 결과를 새 배열에 저장
			encryptArr[i] = (char)(chArr[i] + 3);
		}
		
//		String str = new String(encryptArr);
//		String str = String.valueOf(encryptArr);
//		return str;
		
		// 배열 내의 모든 문자를 문자열로 결합하여 리턴
		// => Arrays 클래스의 toString() 메서드 활용
		return Arrays.toString(encryptArr);
	}
	
	
	

} // Test5 클래스 끝














