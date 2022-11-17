
public class Ex {

	public static void main(String[] args) {
		/*
		 * 다형성(Polymorphism)
		 * - 하나의 데이터타입(참조변수)으로 여러 인스턴스를 참조하는 특성
		 * - 어떤 인스턴스를 업캐스팅하여 슈퍼클래스 타입 변수로 다루면
		 *   하나의 슈퍼클래스 타입으로 여러 서브클래스 타입 인스턴스를 다룰 수 있음.
		 */

		// Circle 인스턴스(c) 생성
		Circle c = new Circle();
		c.CirclePaint();
		
		// Rectangle 인스턴스(r) 생성
		Rectangle r = new Rectangle();
		r.rDraw();
		
		// Triangle 인스턴스(t) 생성
		Triangle t = new Triangle();
		t.design();
		
		// 슈퍼클래스의 메서드를 상속받아 오버라이딩을 하는 경우
		// 코드의 통일성을 향상시킬 수 있다.
		c.draw();
		r.draw();
		t.draw();
		
		System.out.println("-------------------------------");
		
		// 코드의 통일성을 더 향상시키기 위한 방법 : 업캐스팅 활용
		// => Circle, Rectangle, Triangle 의 공통 슈퍼클래스인
		//    Shape 타입(s)으로 세 인스턴스를 컨트롤 가능
		
		// Circle -> Shape 업캐스팅
		Shape s = new Circle();
		s.draw(); // Circle 인스턴스의 draw() 메서드 호출
		
		// Rectangle -> Shape 업캐스팅
		s = new Rectangle();
		s.draw(); // Rectangle 인스턴스의 draw() 메서드 호출
		
		// Triangle -> Shape 업캐스팅
		s = new Triangle();
		s.draw(); // Triangle 인스턴스의 draw() 메서드 호출
		
		System.out.println("-------------------------------");
		
		// 다형성을 배열에 적용시키는 경우
		// => 슈퍼클래스 타입으로 배열을 생성하여
		//    배열의 각 인덱스에 각각의 서브클래스 인스턴스를 저장 가능
//		Shape[] sArr = new Shape[3]; // Shape 타입 배열 3개 생성
//		
//		// 0번 인덱스에 Circle 인스턴스 생성하여 저장
//		sArr[0] = new Circle(); // Circle -> Shape 업캐스팅
//		
//		// 1번 인덱스에 Rectangle 인스턴스 생성하여 저장
//		sArr[1] = new Rectangle(); // Rectangle -> Shape 업캐스팅
//		
//		// 2번 인덱스에 Triangle 인스턴스 생성하여 저장
//		sArr[2] = new Triangle(); // Triangle -> Shape 업캐스팅
		
		Shape[] sArr = {new Circle(), new Rectangle(), new Triangle()};
		// 배열의 각 인덱스에는 인스턴스 주소가 저장되므로
		// 참조변수와 마찬가지로 배열명[인덱스].메서드명() 형태로 호출이 가능
//		sArr[0].draw();
//		sArr[1].draw();
//		sArr[2].draw();
		
		// 반복문을 사용하여 Shape 배열 크기만큼 반복하면서
		// 각 인덱스에 저장된 인스턴스의 draw() 메서드 호출
		for(int i = 0; i < sArr.length; i++) {
			sArr[i].draw();
		}
		
		System.out.println("===============================");
		
		// 메서드에 다형성 활용
		// 1. 이미 다형성이 적용된 배열을 메서드 파라미터로 전달
		polymorphismDraw(sArr);
		
		System.out.println("----------------------------------");
		
		// 2. 메서드 파라미터로 인스턴스를 전달
		polymorphismDraw2(new Circle());
		polymorphismDraw2(new Rectangle());
		polymorphismDraw2(new Triangle());
					
	} // main() 메서드 끝
	
	public static void polymorphismDraw(Shape[] sArr) {
		// 반복문을 사용하여 배열 내의 모든 인스턴스의 draw() 메서드 호출
		for(int i = 0; i < sArr.length; i++) {
			sArr[i].draw();
		}
	}
	
	public static void polymorphismDraw2(Shape s) {
		s.draw();		
	}

} // Ex 클래스 끝

// 여러 도형의 특징을 공통적으로 포함하는 슈퍼클래스 Shape 정의
class Shape {
	// 여로 도형의 공통점인 '그리다' 기능을 수행하는 draw() 메서드 정의
	public void draw() {
		System.out.println("도형 그리기!");
	}
	
}

// Shape 클래스를 상속받는 Circle 클래스 정의
// => draw() 메서드 오버라이딩 : "원 그리기!" 출력
class Circle extends Shape {

	@Override
	public void draw() {
		System.out.println("원 그리기");
	}
	
	public void CirclePaint() {
		System.out.println("원 그리기!");
	}
	
}

// Shape 클래스를 상속받는 Rectangle 클래스 정의
// => draw() 메서드 오버라이딩 : "사각형 그리기!" 출력
class Rectangle extends Shape {

	@Override
	public void draw() {
		System.out.println("사각형 그리기");
	}
	
	public void rDraw() {
		System.out.println("사각형 그리기");
	}
	
	
}

// Shape 클래스를 상속받는 Triangle 클래스 정의
// => draw() 메서드 오버라이딩 : "삼각형 그리기!" 출력
class Triangle extends Shape {

	@Override
	public void draw() {
		System.out.println("삼각형 그리기");
	}
	
	public void design() {
		System.out.println("삼각형 그리기");
	}
	
}










