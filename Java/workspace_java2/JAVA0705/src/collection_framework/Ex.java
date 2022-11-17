package collection_framework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex {

	public static void main(String[] args) {
		/*
		 * Collection Framework( 컬렉션 프레임워크)
		 * - 컴퓨터 시스템에서 데이터를 효율적으로 저장 및 관리하는 방법
		 *   => 자료구조(Data Structure) 라고 함
		 *   => 자료구조를 자바에서 구현하여 제공하는 클래스들의 모음(API)
		 * - Set, List, Map 인터페이스 계열로 구분됨
		 *   => Set 과 List는 공통적으로 Collection 인터페이스를 상속받으므로
		 *      제공하는 메서드가 거의 동일함.
		 * - 각 인터페이스들의 구현체 클래스를 사용하여 데이터를 관리함
		 * - java.util 패키지에 컬렉션 프레임워크 API 들이 제공됨
		 * - toString() 메서드가 오버라이딩 되어 있음.
		 * - 모든 데이터는 객체 형태로 관리되며, 기본 데이터타입을 사용할 경우
		 *   Wrapper 클래스 타입으로 오토 박싱이 일어남
		 *   
		 * 1. Set 계열
		 * - 저장 순서 유지 X, 데이터 중복 허용 X
		 *   => 주머니에 공을 무작위로 집어넣는 것과 유사한 구조로
		 *      데이터의 저장되는 순서 유지 및 중복이 불가능한 구조
		 *      => 매우 효율적인 중복 제거 수단으로 사용 가능
		 * - 인덱스를 사용하지 않음
		 * - 구현체 클래스 : HashSet, TreeSet 등
		 */
		// HashSet 객체 생성
//		HashSet set = new HashSet();
		// Set 인터페이스 구현체이므로 업캐스팅을 활용하여 주로 사용
		Set set = new HashSet(); // HashSet -> Set 업캐스팅
		
		// Set 계열의 메서드 사용
		// 1. boolean isEmpty() : 컬렉션 객체가 비어있는지 여부 리턴
		System.out.println("set 객체가 비어있는가? " + set.isEmpty());
		
		// 2. int size() : 컬렉션 객체에 저장된 요소(데이터, 객체) 객수 리턴
		System.out.println("set 객체의 저장된 요수 개수 : " + set.size());
		
		// 3. boolean add(Object o) : 컬렉션 객체에 요소(o, 데이터)를 추가
		// => 파라미터가 Object 타입이므로 모든 타입 데이터 추가 가능(기본형, 객체)
		// => 리턴타입 boolean 이므로 요소 추가 성공 여부 리턴(중복 시 추가 X)
		set.add(1); // int형 -> Integer -> Object 로 변환되어 저장됨
		set.add("TWO"); // String -> Object 로 변환
		set.add(3.14); // double -> Double -> Object 
		
		System.out.println("set 객체가 비어있는가? " + set.isEmpty());
		System.out.println("set 객체의 저장된 요수 개수 : " + set.size());
		// toString() 메서드가 오버라이딩이 되어 있으므로 출력문에 사용 가능(생략 가능)
		System.out.println("set 객체의 모든 요소 출력 : " + set);
		
		System.out.println("실수 3.14 추가 가능한가? " + set.add(3.14));
		// => 기존에 3.14가 저장되어 있으므로 중복이 불가능하여 저장되지 않고
		//    중복되어 저장이 실패했다는 의미로 false가 리턴됨.
		System.out.println("set 객체의 모든 요소 출력 : " + set);
		// => 컬렉션 객체에 저장된 요소는 변동 없음
		
		System.out.println("문자 '4' 추가 가능한가? " + set.add('4'));
		System.out.println("set 객체의 모든 요소 출력 : " + set);
		
		set.add(5);
		set.add("육");
		System.out.println("set 객체의 저장된 요수 개수 : " + set.size());
		System.out.println("set 객체의 모든 요소 출력 : " + set);
		
		System.out.println("---------------------------------------------");
		
		// boolean contains(Object o) : 컬렉션 객체 내의 요소 o 포함 여부 리턴
		System.out.println("실수 3.14가 존재하는가? : " + set.contains(3.14));
		System.out.println("정수 3이 존재하는가? : " + set.contains(3));
		
		// boolean remove(Object o) : 컬렉션 객체 내의 요소 o 삭제(결과 리턴)
		System.out.println("실수 3.14를 삭제 : " + set.remove(3.14));
		// => 3.14 삭제 후 ture를 리턴
		System.out.println("실수 3.14를 삭제 : " + set.remove(3.14));
		// => 3.14 는 이미 삭제된 후이므로 false 리턴
		
		// void clear() : 컬렉션 요소 초기화
//		set.clear();
		System.out.println("set 객체의 모든 요소 출력 : " + set);
		
		// Object[] toArray() : 컬렉션을 배열로 변환
		Object[] oArr = set.toArray();
		System.out.println(Arrays.toString(oArr));
		
//		for(int i = 0; i < oArr.length; i++) {
//			System.out.println(oArr[i]);
//		}
		
		System.out.println("==============================================");
		
		// Set 또는 List 계열 객체 생성 시 기존 객체 데이터 이전(복사) 가능
		Set set2 = new HashSet(set);
		// => set 객체를 set2 객체에 전달(= 요소 전체 복사)
		System.out.println("set2 객체의 모든 요소 출력 : " + set2);
		
		set2.remove(5);
		// 복사된 객체의 요소를 삭제하더라도 다른 객체의 요소에 영향을 주지 않음.
		System.out.println("set 객체의 모든 요소 출력 : " + set);
		System.out.println("set2 객체의 모든 요소 출력 : " + set2);
		
		Set set3 = new HashSet();
		set3.add(10);
		set3.add(5);
		
		// 객체 생성 후 addAll() 메서드를 통해 데이터를 한꺼번에 추출 가능
		set3.addAll(set);
		System.out.println(set3);
		
		System.out.println("=============================================");
		
		Set set4 = new HashSet();
		set4.add("300");
		set4.add("30");
		set4.add("200");
		set4.add("1");
		set4.add("100");
		set4.add("10");
		// TreeSet을 통한 정렬 => [1, 10, 100, 200, 30, 300]
		
//		set4.add(300);
//		set4.add(30);
//		set4.add(200);
//		set4.add(1);
//		set4.add(100);
//		set4.add(10);
		// TreeSet을 통한 정렬 =>  [1, 10, 30, 100, 200, 300]
		
		System.out.println("set 객체의 모든 요소 출력 : " + set4);
		
		// TreeSet 객체를 활용하면 같은 타입 데이터가 저장된 Set 객체 정렬
		// => 단, 같은 데이터 타입만 정렬 가능하며 다른 타입일 경우 예외 발생
		// => 수치데이터는 숫자 크기 순으로 오름차순 정렬되고,
		//    문자는 문자 코드 값 기준으로 오름차순 정렬됨
		//    (문자열은 첫번째 문자부터 차례대로 비교)
		TreeSet treeSet = new TreeSet(set4);
		System.out.println("TreeSet 객체의 모든 요소 출력 : " + treeSet);
		
		

	}

}

















