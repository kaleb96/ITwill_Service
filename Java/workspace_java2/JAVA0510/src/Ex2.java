import java.security.Principal;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 메서드 오버로딩 시 문제점
		 * - 동일한 작업을 수행하는 코드들의 중복이 발생
		 *   => 만약, 특정 메서드의 코드를 수정해야 할 경우
		 *      동일한 코드를 여러번 수정해야하는 번거로움이 발생 할 수 있음.
		 *   => 코드의 유지보수성이 나쁘다!!
		 *   
		 * [ 해결책 ]
		 * 오버로딩 된 메서드에서 또 다른 오버로딩 된 메서드를 호출하여
		 * 중복되는 작업을 대신 처리하도록 할 수 있다!
		 * => 메서드 호출 시 자신의 전달받은 파라미터를 다시 전달
		 * => 이처럼 클래스 내의 다른 메서드를 호출하여 사용 = 코드의 재사용
		 *      
		 */
		PrintClass pc = new PrintClass();
		pc.print();
		System.out.println("--------------------");
		pc.print("홍길동");
		System.out.println("--------------------");
		pc.print("홍길동", "이순신");
		System.out.println("--------------------");
		pc.print("홍길동", "이순신", "강감찬");
		
	}

}

class PrintClass {
	// 최대 3명까지의 초대 인원에 대한 이름을 입력받아 출력하는 print() 메서드 정의
	// => 단, 입력되지 않은 이름은 "없음"으로 출력
	// ex) print("홍길동", "이순신", "강감찬") 형태로 호출 시
	//     초대 멤버 : "홍길동 이순신 강감찬" 출력
	// ex) print("홍길동") 형태로 호출 시 
	//     초대 멤버 : "홍길동 없음 없음" 출력
	// ex) print() 형태로 호출 시
	//     초대 멤버 : "없음 없음 없음" 출력
	
	public void print() {
		System.out.println("print() 메서드 호출됨!");
//		System.out.println("초대 멤버 : 없음 없음 없음");
		
		// print(String, String, String) 메서드를 호출하여
		// 없음, 없음, 없음 문자열을 대신 출력
		print("없음","없음","없음");
	}
	
	public void print(String name1) {
		System.out.println("print(String) 메서드 호출됨!");
//		System.out.println("초대 멤버 : " + name1 + " 없음 없음");
		
		// print(String, String, String) 메서드를 호출하여
		// 전달받은 이름, 없음, 없음 문자열을 대신 출력
		print(name1, "없음", "없음");
	}
	
	public void print(String name1, String name2) {
		System.out.println("print(String, String) 메서드 호출됨!");
//		System.out.println("초대 멤버 : " + name1 + " " + name2 + " 없음");
		
		// 2명의 이름과 "없음" 문자열을 직접 출력하지 않고
		// 3명의 이름을 전달받아 출력하는 print(String, String, String) 메서드를
		// 호출하여 2명의 이름과 "없음" 문자열을 전달하면 대신 출력 가능
		print(name1, name2, "없음");
	}
	
	public void print(String name1, String name2, String name3) {
		System.out.println("print(String, String, String) 메서드 호출됨!");
		System.out.println("초대 멤버 : " + name1 + " " + name2 + " " + name3);
	
		// 주의! 모든 파라미터를 전달받는 마지막 메서드는
		// 자기 자신을 호출하지 않고 반드시 직접 작업 수행해야 함!
//		print(name1, name2, name3);	// 재귀 호출(오류 발생!)	
	}
	
}









