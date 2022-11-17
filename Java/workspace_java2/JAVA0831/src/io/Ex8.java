package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Ex8 {

	public static void main(String[] args) {
		/*
		 * 객체 입출력을 위한 스트림
		 * - ObjectInputStream, ObjectOutputStream
		 * - 단, 객체는 메모리 상에 생성되어 있는 고유 정보이므로
		 *   다른 노드를 통해 전송하더라도 참조값을 전송하게 되어 전송된 곳에서는 의미가 없음
		 *   => 반드시 객체의 직렬화를 통해 객체를 출력하고, 역직렬화를 통해 입력받아야 함
		 * 
		 * 객체 직렬화(Serialization) & 역직렬화(Deserialization)
		 * - 자바에서 사용하는 객체에 영속성을 부여하여 
		 *   파일 또는 네트워크 등으로 내보내는 것을 직렬화라고 하며
		 *   파일이나 네트워크로부터 데이터를 읽어 객체로 변환(복원)하는 것을 역직렬화라고 함
		 * - 직렬화에 사용되는 클래스는 선언부터 Serializable 인터페이스를 상속받아야 함
		 *   (구현해야할 추상메서드는 아무것도 없음 = 마커(Marker) 인터페이스 라고 함)
		 *   => 또한, 클래스 내에서 다른 클래스를 사용하는 경우
		 *      연관된 모든 클래스가 Serializable 인터페이스를 상속받아야 함
		 */
		
		// 외부로 출력할 Person 객체 생성
//		Person p = new Person("이순신", 44, "701010-1122334");
		Person p = new Person("이순신", 44, "701010-1122334", new Car());
		
		// File 객체를 생성하여 D드라이브 temp 폴더 내의 serial_person.dat 파일 지정
		File f = new File("d:\\temp", "serial_person.dat");
		
		// Person 객체를 외부 파일로 출력하기(= 직렬화)
		// => ObjectOutputStream 객체를 생성하여 출력스트림 객체(FileOutputStream) 연결
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
			// ObjectOutputStream 객체의 writeObject() 메서드를 호출하여 객체 출력하기
			oos.writeObject(p); // Person 객체 출력
			// => 주의! 직렬화에 사용되는 객체의 클래스는 반드시 Serializable 인터페이스 상속 필수!
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// ====================================================================
		// D:\temp\serial_person.dat 파일에 저장되어 있는 Person 객체를
		// ObjectInputStream 객체를 통해 읽어와서 Person 객체로 복원
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
			// ObjectInputStream 객체의 readObject() 메서드를 호출하여
			// 파일에 저장된 객체를 Object 타입으로 읽어오기
			// => 리턴타입이 Object 이므로 실제 객체 사용을 위해서는 다운캐스팅 필요
			Person person = (Person)ois.readObject(); // ClassNotFoundException
			
			// 리턴받은 Person 객체내의 멤버변수에 접근
			System.out.println(person.name);
			System.out.println(person); // toString() 호출
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}

// Person 클래스 정의
// => 직렬화 대상으로 지정되는 클래스이므로 Serializable 인터페이스를 구현(implements)
// => 이 인터페이스는 추상메서드가 없는 단순한 마커(Marker) 역할의 인터페이스
class Person implements Serializable {
	String name;
	int age;
	// 만약, 직렬화 대상에서 제외시키고 싶은 멤버 변수가 있을 경우 선언부에 transient 키워드 명시  
	transient String jumin; // 직렬화 시 제외되므로 null 값이 전달됨
	
	// 다른 클래스를 사용할 경우 해당 클래스도 implements Serializable 필수!
	Car myCar;
	
	public Person(String name, int age, String jumin, Car myCar) {
		super();
		this.name = name;
		this.age = age;
		this.jumin = jumin;
		this.myCar = myCar;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", jumin=" + jumin + "]";
	}
	
}

class Car implements Serializable {
	String carName;
}













