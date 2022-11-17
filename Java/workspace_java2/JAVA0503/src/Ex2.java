
public class Ex2 {

	public static void main(String[] args) {
		
		Person p1 = new Person();
		p1.name = "홍길동";
		p1.age = 20;
//		System.out.println("이름 : " + p1.name);
//		System.out.println("나이 : " + p1.age);
		p1.print();
		
		Person p2 = new Person();
		p2.name = "이순신";
		p2.age = 40;
//		System.out.println("이름 : " + p2.name);
//		System.out.println("나이 : " + p2.age);
		p2.print();
		

	} // main() 메서드 끝

} // Ex2 클래스 끝

// 사람(Person) 클래스 정의
class Person {
	// 멤버변수 선언
	String name; // 이름
	int age; // 나이
	
	// 메서드 정의
	// 자신의 인스턴스에 저장된 이름, 나이를 출력하는 print() 메서드 정의
	// => 매개변수 없음, 리턴값 없음
	public void print() {
		// 클래스 내의 메서드에서 자신의 클래스 멤버변수에 자유롭게 접근 가능
		// => 즉, 변수명만으로도 메모리에 생성된 자신의 인스턴스 내의
		//    멤버변수 값을 사용할 수 있음
		//    => 단, 동일한 코드라 하더라도 인스턴스에 따라 저장된 값은 달라짐
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}






