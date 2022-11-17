package enum_type;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class Ex {

	public static void main(String[] args) {
		/*
		 * 상수를 사용하여 한정된 데이터를 관리하는 경우
		 * 간편한 선언을 통해 관리할 수 있다는 장점이 있으나
		 * 해당 값의 범위를 벗어나는 값을 사용할 경우 컴파일 시점에서 오류가 발생할 수 있음
		 * 추가적인 작업을 통해 범위 내의 값인지 판별하는 작업이 별도로 필요함!
		 * => 이를 해결하기 위해 열거형(enum type) 필요
		 * 
		 * 열거형(Enumeration Type = Enum 타입)
		 * - 상수를 좀 더 확실한 형태로 다루기 위한 객체의 일종
		 * - 데이터타입이 일치하면 다른 데이터라도 사용 가능한 상수의 단점을 해결
		 * - enum 타입은 내부적으로 java.lang.Enum 클래스를 상속받음
		 * 
		 * < 열거타입 정의 방법 >
		 * [접근제한자] enum 열거타입명 {
		 *		// 열거타입에서 사용할 값(상수)을 차례대로 나열
		 *		상수1, 상수2, ... 상수 n
		 * }
		 * 
		 * - 기본적으로 클래스, 인터페이스 정의 문법과 유사함
		 *   단, 열거타입 중괄호 내에는 상수로 사용될 이름만 지정
		 *   
		 * < 열거타입 사용 방법 >
		 * 1. 열거타입 변수 선언 방법(클래스, 인터페이스와 동일)
		 *    열거타입명 변수명
		 *    ex) Car car
		 *  
		 * 2. 열거타입 비교 방법
		 * - if문 사용 시 동등비교 연산자 사용(==)
		 * - switch문 사용 가능 (단, case 문에서 열거타입명 없이 상수만 지정)
		 *   switch(열거타입변수) {
		 *     case 열거타입상수1 : 수행할 작업들...;
		 *     case 열거타입상수2 : 수행할 작업들...;
		 *     case 열거타입상수n : 수행할 작업들...;
		 *   }
		 */
		
		
		// 일반 상수를 파라미터로 사용하는 경우
		MyCalendar mc = new MyCalendar();
		mc.setMonth(20); // int 타입 데이터 전달 가능(잘못된 데이터)
//		mc.setMonth(WeekClass.MONDAY); // 요일도 전달 가능(잘못된 데이터)
		mc.setMonth(MonthClass.JANUARY); // 정상 데이터
		
//		if(WeekClass.MONDAY == MonthClass.JANUARY) {
//			System.out.println("리터럴 값으로 비교하면 같다고 인식됨!");
//		}
		
		System.out.println("============================================");

		// 열거타입 변수 today 선언 및 초기화 후 호출
		EnumWeek today = EnumWeek.TUSEDAY;
		System.out.println(today);
		
		// 열거 타입을 활용하는 클래스 사용
		GoodWeek gw = new GoodWeek();
		gw.setMyWeek(today);
		System.out.println("오늘의 요일 : " + gw.getMyWeek());
		
		gw.setMyWeek(EnumWeek.TUSEDAY);
		System.out.println("오늘의 요일 : " + gw.getMyWeek());
		
		// EnumWeek 타입 객체는 Enum 클래스의 서브 클래스 타입 객체입니까?
		if(today instanceof Enum) {
			System.out.println("Enum 클래스의 서브클래스이다!");
		} else {
			System.out.println("Enum 클래스의 서브클래스가 아니다!");
		}
		
		if(today instanceof Object) {
			System.out.println("Object 클래스의 서브클래스이다!");
		} else {
			System.out.println("Object 클래스의 서브클래스가 아니다!");
		}
		
		System.out.println("===========================================");
		
		// 열겨형 타입 사용 시 장점
		// => 정의 시 지정된 상수 이외의 다른값은 절대 전달 불가능!
//		gw.setMyWeek(5);
		// The method setMyWeek(EnumWeek) in the type GoodWeek
		//  is not applicable for the arguments (int)
//		gw.setMyWeek("MONDAY");
		// The method setMyWeek(EnumWeek) in the type GoodWeek
		// is not applicable for the arguments (String)
		// => 반드시 열거타입명.상수명 으로 지정된 값만 전달 해야 한다!
		gw.setMyWeek(EnumWeek.SATURDAY);
	}
	
	

}

// 열거 타입 정의
enum EnumWeek {
	// 열겨형 정의 시 중괄호 내에는 값을 갖는 상수 이름만 나열함
	// (별도의 값을 지정하지 않음)
	MONDAY, TUSEDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

enum EnumMonth {
	JANUARY, FEBRUARY
}

// 열거타입을 사용하는 클래스 정의
class GoodWeek {
	// 클래스 내에서 열거타입 변수 선언 가능(로컬변수로도 가능)
	EnumWeek myWeek;

	public EnumWeek getMyWeek() {
		return myWeek;
	}

	public void setMyWeek(EnumWeek myWeek) {
		this.myWeek = myWeek;
	}
	
	
	
}


// 요일 정보를 관리하는 WeekClass 클래스 정의
class WeekClass {
	// 요일 정보를 상수로 저장
//	public static final String MONDAY = "MONDAY";
	public static final int MONDAY = 0;
	public static final int TUSEDAY = 1;
	public static final int WEDNESDAY = 2;
	public static final int THURSDAY = 3;
	public static final int FRIDAY = 4;
	public static final int SATURDAY = 5;
	public static final int SUNDAY = 6;
}

// 월 정보를 관리하는 MonthClass 클래스 정의
class MonthClass {
	public static final int JANUARY = 0;
//  ...
	public static final int DECEMBER = 11;
}

class MyCalendar {
	
	private int myWeek;
	
		
	public int getMyWeek() {
		return myWeek;
	}

	public void setMyWeek(int myWeek) {
		if(myWeek >= WeekClass.MONDAY && myWeek <= WeekClass.SUNDAY) {
			this.myWeek = myWeek;
		} else {
			System.out.println("요일 입력 에러!");
		}
	}

	// setMonth() 메서드 파라미터로 int 타입을 전달받을 경우
	// MonthClass.JANUARY 값과 WeekClass.MONDAY 의 값이 동일한데
	// WeekClass.MONDAY 를 전달하면 문법적으로 오류가 발생하지 않으나
	// 정상적인 값이라도 볼 수가 없다!
	// 하지만, 외부에서 전달하는 값에 대한 제한을 할 수 없다! (일반 상수 문제점)
	public void setMonth(int month) {
		if(month >= MonthClass.JANUARY && month <= MonthClass.DECEMBER) {
			System.out.println((month + 1) + "월");		
		} else {
			System.out.println("월 입력 에러!");
		} 
	}
}





