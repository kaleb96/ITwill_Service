package interface_;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Photoshop p = new Photoshop();
		p.draw(new Circle()); // Shape s = new Circle() 과 동일 
		// => p.draw(s.draw() = Circle.draw())
		p.draw(new Rectangle());
		
		System.out.println("------------------------");
		
		Car car = new Taxi();
		car.speedUp();
		car.speedDown();
//		car.lift(); // 참조 영역 축소로 호출 불가
//		car.drop(); // 참조 영역 축소로 호출 불가
		
		// 다운캐스팅을 통해 Taxi 타입으로 변환 후 lift(), drop() 호출
		if(car instanceof Taxi) {
			Taxi taxi = (Taxi)car; // 다운캐스팅
			taxi.lift();
			taxi.drop();
		}
		
		car = new Truck();
		car.speedUp();
		car.speedDown();
//		car.dump(); // 참조 영역 축소로 호출 불가
		
		if(car instanceof Truck) {
			Truck truck = (Truck)car; // 다운캐스팅
			truck.dump();
			
		}
		
	}

}

// 모든 도형의 그리기 기능을 제공하는 Shape 인터페이스 정의
// => draw() 추상메서드 정의(리턴값 없음, 파라미터 없음)
interface Shape {
	public abstract void draw();
}
// ----------------------------------------------------------------------------------
// Shape 인터페이스를 구현하는 Circle, Rectangle 클래스 정의 
// => 추상메서드 draw() 를 오버라이딩하여 각자 도형 그리기 기능을 구현
//    ex) Circle 은 "원 그리기 - 반지름 : 3.0!",
//        Rectangle 은 "가로 3 , 세로 4의 사각형 그리기!" 출력
// => Circle - 멤버변수 : 반지름(radius, 실수형)
//           - Setter() 메서드
// => Rectangle - 멤버변수 : 가로(Line1Length, 실수형), 세로(Line2Length, 실수형)
//              - Setter() 메서드 
class Circle implements Shape {
	private double radius = 3.0;

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println("원 그리기 - 반지름 : " + radius + "!");
		
	}
}

class Rectangle implements Shape {
	private double Line1Length = 2.0;
	private double Line2Length = 1.5;
	
	public void setLine1Length(double line1Length) {
		Line1Length = line1Length;
	}
	
	public void setLine2Length(double line2Length) {
		Line2Length = line2Length;
	}

	@Override
	public void draw() {
		System.out.println("가로 " + Line1Length +" ,  세로 " + Line2Length + "의 사각형 그리기!");
		
	}
}
// ----------------------------------------------------------------------------------
// Circle과 Rectagle 인스턴스를 전달받아 해당 인스턴스의 draw()를 호출하는
// Photoshop 클래스 정의
class Photoshop {
	// draw 메서드 정의
	// => Circle과 Rectagle 인스턴스를 전달받아 해당 인스턴스의 draw()를 호출
	//    두 인스턴스의 공통 타입으로 Shape 인터페이스를 파라미터 타입으로 지정
	public void draw(Shape s) {
		s.draw();
	}
}

// =======================================================================================
// Car 인터페이스를 정의
// - speedUp(), speedDown() 추상메서드
interface Car {
	public abstract void speedUp();
	public abstract void speedDown();
}

// Taxi (Car 인터페이스를) 구현클래스를 정의
// - 메서드 : speedUp(), speedDown(), lift(), drop()
class Taxi implements Car {

	@Override
	public void speedUp() {
		System.out.println("Taxi 속력 증가!");
	}

	@Override
	public void speedDown() {
		System.out.println("Taxi 속력 감소!");
	}
	
	public void lift() {
		System.out.println("Taxi 승객 탑승!");
	}
	
	public void drop() {
		System.out.println("Taxi 승객 하차!");
	}
}

// Truck 구현클래스를 정의
// - 메서드 : speedUp(), speedDown(), dump()
class Truck implements Car {

	@Override
	public void speedUp() {
		System.out.println("Truck 속력 증가!");
	}

	@Override
	public void speedDown() {
		System.out.println("Truck 속력 감소!");
	}
	
	public void dump() {
		System.out.println("덤프!");
	}
}

// 활용(main 메서드)
/*
 * Car car = new Taxi();
 * car.lift() 와 car.drop() 메서드는 호출 불가!
 * 다운캐스팅을 통해 lift(), drop() 메서드를 호출
 */






























