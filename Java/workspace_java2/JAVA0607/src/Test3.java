
public class Test3 {

	public static void main(String[] args) {
		// Animal 인스턴스 생성
		Animal animal = new Animal("멍멍이",1);
		animal.cry(); // "동물 울음 소리!"
		
		// Dog 인스턴스 생성
		Dog dog = new Dog();
		
//		dog = (Dog)animal; // 컴파일 오류 발생!
//		// => instanceof 연산자를 사용하여 해결
		if(animal instanceof Dog) {
			System.out.println("형 변환 가능!");
			dog = (Dog)animal;
		} else {
			System.out.println("형 변환 불가능!");
		}

		// 동적바인딩 확인
		animal = new Dog(); // 업캐스팅
		animal.cry(); // "멍멍!"
		
		animal = new Cat(); // 업캐스팅
		animal.cry(); // "냐옹!"

	}

}

// Animal 클래스 정의
// - 멤버변수 : private 접근제한자가 설정된 이름(name, 문자열)
//				private 접근제한자가 설정된 나이(age, 정수)
// - 파라미터 생성자(name, age)
// - 멤버변수에 대한 Getter, Setter 정의
// - cry() 메서드 정의 : 리턴값 X, 매개변수 X, "동물 울음소리!" 출력
class Animal {
	private String name;
	private int age;
	
	public Animal() {}
	
	public Animal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void cry() {
		System.out.println("동물 울음 소리!");
	}
	
}

// Dog 클래스 정의
// - Animal 클래스 상속 받음
// - 메서드 재정의 cry() : "멍멍!" 출력
class Dog extends Animal {

	@Override
	public void cry() {
		System.out.println("멍멍!");
	}
		
}

// Cat 클래스 정의
//- Animal 클래스 상속 받음
//- 메서드 재정의 cry() : "냐옹!" 출력
class Cat extends Animal {

	@Override
	public void cry() {
		System.out.println("냐옹!");
	}
		
}


