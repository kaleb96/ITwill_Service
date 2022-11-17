
public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 대입연산자(=)
		 * - 우변의 데이터를 좌변의 변수에 대입(저장)
		 *   => 연산 방향이 우 -> 좌로 진행됨
		 *      ex) x = y = 3 의 경우 y에 3을 대입하고, x에 y를 대입
		 * - 모든 연산자 중에서 우선순위가 가장 낮음
		 *   즉, 다른 모든 작업을 수행한 후 대입연산을 수행
		 *      
		 * 확장(복합) 대입연산자 (+=, -=, *=, /=, %=)
		 * - 대입연산자와 산술연산자를 조합한 연산자
		 * - 좌변과 우변의 데이터끼리 산술연산을 먼저 하고
		 *   그 결과값을 다시 좌변의 변수에 대입(저장)
		 *   => a = a + b 는 a += b로 표현 가능
		 *      
		 */

		int a = 10; // 우변의 데이터 10을 좌변의 변수 a에 대입(저장)
		int b;
		
		b = a; // 우변의 변수 a의 값을 좌변의 변수 b에 대입(저장)
		System.out.println(a);
		System.out.println(b);
		
		System.out.println("------------------------");
		
		// b와 a의 덧셈 결과를 다시 변수 b에 저장
		// => 마치, b에 a 값을 누적하는 것과 동일
//		b = b + a; // 10 + 10 = 20이 변수 b에 저장됨(b에 a값을 누적)
		b += a; 
		System.out.println(b);
		

		// b와 a의 뺄셈 결과를 다시 변수 b에 저장
		// => 마치, b에 a 값을 빼는 것과 동일
//		b = b - a; // 20 - 10 = 10이 변수 b에 저장됨(b에 a값을 누적)
		b -= a; 
		System.out.println(b);
		
		// b와 a의 곱셈 결과를 다시 변수 b에 저장
		// => 마치, b에 a 값을 곱하는 것과 동일
//		b = b * a; // 10 * 10 = 100이 변수 b에 저장됨(b에 a값을 누적)
		b *= a; 
		System.out.println(b);
		
		// b와 a의 나눗셈 결과 중 몫을 다시 변수 b에 저장
//		b = b / a; // 100 / 10 = 10 이 변수 b에 저장됨(b에 a값을 누적)
		b /= a; 
		System.out.println(b);
		
		// b와 a의 나눗셈 결과 중 나머지를 다시 변수 b에 저장
//		b = b / a; // 10 % 10 = 0 이 변수 b에 저장됨(b에 a값을 누적)
		b %= a; 
		System.out.println(b);
		
		System.out.println("===================================");
		
		byte b1 = 10;
		// b1과 정수 10을 더한 값을 다시 b1에 저장
//		b1 = b1 + 10; // byte + int = int + int가 되어 결과값이 int가 됨
		// => 결과값이 다시 byte 타입으로 변환해야 함!
		b1 = (byte)(b1 + 10);
		System.out.println(b1);
		
		// 확장 대입연산자를 사용하여 b1 + 10의 값을 b1에 저장
		// => b1 에 정수 10을 누적
		b1 += 10; // b1 = b1 + 10;
		System.out.println(b1);
		
		System.out.println("===================================");
		
		char ch = 'A';
//		ch = ch + 3; //오류발생!
		
//		ch = (char)(ch + 3); // 형변환을 수행하거나
		ch += 3; // 확장 대입연산자를 사용하면 강제 형변환이 필요 없다!
		System.out.println(ch);
		
		
	}

}








