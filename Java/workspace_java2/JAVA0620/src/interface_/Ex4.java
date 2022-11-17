package interface_;

public class Ex4 {

	public static void main(String[] args) {
		// 3. 서로 상속 관계에 있지 않는 클래스 간에 
		//    인터페이스를 통해 상속 관계 부여
		Ex4 ex = new Ex4();
		ex.noRelationship();
		System.out.println("-----------------");
		ex.hasRelationship();
		

	} // main() 메서드 끝
	
	public void noRelationship() {
//		NoteBook notebook = new NoteBook();
//		notebook.charge();
//		SmartPhone smartPhone = new SmartPhone();
//		smartPhone.charge();
		
		// 두 개의 인스턴스를 하나의 배열로 관리해야할 경우
		// NoteBook 과 SmartPhone 의 공통 타입은 Object 타입 밖에 없음
		Object[] objArr = {new NoteBook(), new SmartPhone()};
		
		// 반복문을 사용해서 배열 크기만큼 반복
		for(int i = 0; i < objArr.length; i++) {
//			objArr[i].charge();
			// => 참조 영역 축소로 인해 Object 타입으로 charge() 메서드 호출 불가!
			
			// instanceof 연산자를 사용하여 NoteBook 과 SmartPhone 타입 판별
			// => 다운캐스팅을 통해 각 인스턴스를 따로 접근해야 함
			if(objArr[i] instanceof NoteBook) {
				// Object -> NoteBook 타입으로 다운캐스팅 후 charge() 호출
				NoteBook notebook = (NoteBook)objArr[i];
				notebook.charge(); // 노트북의 충전기를 통해 충전
			} else if(objArr[i] instanceof SmartPhone) {
				// Object -> SmartPhone 타입으로 다운캐스팅 후 charge() 호출
				SmartPhone smartPhone = (SmartPhone)objArr[i];
				smartPhone.charge(); // 스마트폰의 충전기를 통해 충전
			}
			
		}
			
	}
	
	public void hasRelationship() {
		// 인터페이스를 사용하여 공통된 멤버를 갖는 상속 관계를 부여할 경우
		// 해당 인터페이스 타입으로 다운캐스팅 할 필요없이
		// 업캐스팅 된 상태로 그대로 멤버에 접근이 가능
		// => 다형성으로 인한 코드 절약
//		Chargeable c = new NoteBook2(); // NoteBook2 -> Chargeable (업캐스팅)
//		Chargeable c2 = new SmartPhone2(); // SmartPhone2 -> Chargeable (업캐스팅)
		
		// Chargeable 타입 배열로 두 클래스 인스턴스 모두 관리 가능(업캐스팅)
		Chargeable[] chargeableArr = {new NoteBook2(), new SmartPhone2()};
		// 업캐스팅 후에도 공통 메서드 charge()를 호출 가능하므로
		// 별도의 다운캐스팅 없이 바로 charge() 메서드 접근 가능
		for(int i = 0; i < chargeableArr.length; i++) {
			chargeableArr[i].charge();
		
	}
}
	

} // Ex4 class 끝

// Object 클래스외에 공통 슈퍼클래스가 없는 NoteBook 과 SmartPhone의 
// 공통 인터페이스 Chargeable 인터페이스 정의
interface Chargeable {
	// 두 클래스에서 공통으로 사용할 충전(charge()) 기능을 추상메서드로 정의
	public abstract void charge();
}

// 기존에 Pc 클래스를 상속받고 잇는 상태에서
// 추가로 인터페이스를 구현해야 하는 경우 상속 코드 뒤에 구현 코드를 기술
// => implements Charageable 코드 추가
// => 아무 관계 없던 두 클래스에 동일한 부모 인터페이스가 추가되어
//    서로 상속 관계에 묶이게 됨
class NoteBook2 extends Pc implements Chargeable {
	public void charge() {
		System.out.println("노트북 충전 중...");
	}
}

class SmartPhone2 extends HandPhone implements Chargeable {
	public void charge() {
		System.out.println("스마트폰 충전 중...");
	}
}


// =======================================================
class Pc {}

class NoteBook extends Pc {
	public void charge() {
		System.out.println("노트북 충전 중...");
	}
}

class HandPhone {}

class SmartPhone extends HandPhone {
	public void charge() {
		System.out.println("스마트폰 충전 중...");
	}
}









