package abstract_package;

public class Ex2 {

	public static void main(String[] args) {
		
	}

}

abstract class AbstractClass2 {
	public abstract void method1();
	public abstract void method2();
}

// 추상메서드 2개를 갖는 추상클래스를 상속받은 서브클래스 정의
abstract class MiddleClass extends AbstractClass2 {
	// 상속받은 추상메서드 2개 중 하나만 구현하는 경우
	// => 추상메서드가 구현되지 않은 채 그대로 존재할 경우
	//    해당 서브클래스도 추상클래스로 선언해야 함!
	
	@Override
	public void method1() {
		System.out.println("MiddleClass 에서 구현한 method1()");
		
	}
	
//	@Override
//	public void method2() {
//		System.out.println("MiddleClass 에서 구현한 method2()");
//		
//	}
}

// 추상메서드를 모두 구현하지 않은 서브클래스(추상클래스) MiddleClass를
// 상속받는 서브클래서 SubClass2 정의
class SubClass2 extends MiddleClass {
	// The type SubClass2 must implement the inherited abstract method AbstractClass2.method2()
	// method1() 메서드는 MiddleClass 에서 이미 구현되어 있으므로 강제성X
	// 그러나 여전히 남아 있는 method2() 메서드는 반드시 구현해야 한다!
	@Override
	public void method2() {
		System.out.println("SubClass2 에서 구현한 method2()");
		
	}
	
}









