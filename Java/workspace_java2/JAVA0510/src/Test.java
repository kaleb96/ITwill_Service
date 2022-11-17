
public class Test {

	public static void main(String[] args) {
		MyDate d1 = new MyDate();
		System.out.println(d1.year + "/" + d1.month + "/" + d1.day);
		
		MyDate d2 = new MyDate(1999);
		System.out.println(d2.year + "/" + d2.month + "/" + d2.day);
		
		MyDate d3 = new MyDate(1999,12);
		System.out.println(d3.year + "/" + d3.month + "/" + d3.day);
		
		MyDate d4 = new MyDate(1999,12,31);
		System.out.println(d4.year + "/" + d4.month + "/" + d4.day);

	}

}

/*
 * 날짜를 관리하는 MyDate 클래스 정의
 * - 멤버변수 : 연도(year, 정수), 월(month, 정수), 일(day, 정수)
 * - 생성자
 *   1) 기본생성자 : 2022년 5월 10일로 초기화
 *   2) 파라미터 생성자
 *      2-1. 연도(year)를 전달받아 초기화하고, 5월 10일로 초기화
 *      2-2. 연도(year), 월(month)을 전달받아 초기화하고, 30일로 초기화
 *      2-3. 연도(year), 월(month), 일(day)을 전달받아 초기화
 */

class MyDate {
	int year;
	int month;
	int day;
	
	public MyDate() {
		System.out.println("MyDate() 생성자 호출됨!");
		year = 2022;
		month = 5;
		day = 10;
	}
	
	public MyDate(int newYear) {
		System.out.println("MyDate(int) 생성자 호출됨!");
		year = newYear;
		month = 5;
		day = 10;
	}
	
	public MyDate(int newYear, int newMonth) {
		System.out.println("MyDate(int, int) 생성자 호출됨!");
		year = newYear;
		month = newMonth;
		day = 10;
	}
	
	public MyDate(int newYear, int newMonth, int newDay) {
		System.out.println("MyDate(int, int, int) 생성자 호출됨!");
		year = newYear;
		month = newMonth;
		day = newDay;
	}
	
}




