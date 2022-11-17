/*
 * Car 클래스 정의
 * 1. 구성요소(속성) - 멤버변수
 *   1) 제조사(company, 문자열)
 *   2) 모델명(modelName, 문자열)
 *   3) 배기량(cc, 정수)
 * 2. 동작(기능) - 메서드
 *   1) 속력증가(speedUp()) - "자동차 속력 증가!" 출력
 *   2) 속력감소(speddDown()) - "자동차 속력 감소!" 출력
 */

public class Car {
	
	// 멤버변수 선언
	String company;
	String modelName;
	int cc;
	
	// 메서드 정의
	public void speedUp() {
		System.out.println("자동차 속력 증가!");
	}
	
	public void speedDown( ) {
		System.out.println("자동차 속력 감소!");
	}

}
