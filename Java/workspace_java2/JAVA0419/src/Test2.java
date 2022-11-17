
public class Test2 {

	public static void main(String[] args) {
		// 점수(score)에 따른 학점 계산을 switch 문으로 수행할 경우
		// case 문에서 값만 지정 가능하며 범위 지정이 불가능하므로
		// 각각의 점수를 모두 지정해야 함
		int score = 88;
		
		switch(score) {
			case 100 : System.out.println("A학점!"); break;
			case 99 : System.out.println("A학점!"); break;
			case 98 : System.out.println("A학점!"); break;
			// ... 생략 ...
			case 89 : System.out.println("B학점!"); break;
			case 88 : System.out.println("B학점!"); break;
			// ... 생략 ...
			case 1 : System.out.println("F학점!"); break;
			case 0 : System.out.println("F학점!"); 
		}
		
		System.out.println("=================================");
		
		// 위의 switch 문 코드를 줄이기 위해 연산식 활용
		// => 각 학점에 해당하는 점수의 공통점을 추출
		// A학점 : 90점대와 100점 (= 10의 자리 숫자가 9 또는 10)
		// B학점 : 80점대(= 10의 자리 숫자가 8)
		// C학점 : 70점대(= 10의 자리 숫자가 7)
		// D학점 : 60점대(= 10의 자리 숫자가 6)
		// F학점 : 나머지 점수
		// => 점수에서 10의 자리 값을 추출하여 switch 문에 전달
		score = 88;
		if(score >= 0 && score <= 100) {
			switch(score / 10) {
				// 문제점 : 101 ~ 109 점도 A학점으로 취급됨
				// => 해결책 : if문을 사용하여 0 ~ 100 사이일 때만 학점 계산
				case 10 : 
				case 9 : System.out.println(score + " : A학점!"); break;
				case 8 : System.out.println(score + " : B학점!"); break;
				case 7 : System.out.println(score + " : C학점!"); break;
				case 6 : System.out.println(score + " : D학점!"); break;
				default : System.out.println(score + " : F학점!");
				// 0 보다 작거나 100보다 큰 점수는 else 문이 실행되므로
				// 0 ~ 59점까지의 F학점을 default 문으로 처리 가능함!
			}
		
		} else {
			System.out.println(score + " : 점수 입력 오류!");
		}
		
	}

}
