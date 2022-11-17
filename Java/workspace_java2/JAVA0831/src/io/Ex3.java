package io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 기본 입출력 스트림인 InputStream 과 OutputStream 은 byte 단위로 처리하지만
		 * InputStreamReader 와 OutputStreamReader 객체를 활용하면 char 단위로 처리 가능함
		 * => XXXInputStream & XXXOutputStream 클래스 : byte 단위 처리하는 클래스
		 *    XXXReader & XXXWriter 클래스 : char 단위 처리하는 클래스
		 * => 단, 기본 입출력 스트림으로부터 데이터 읽어들이는 과정은 동일함
		 * 
		 * < 키보드로 데이터를 입력받는 방법 >
		 * 3. InputStream 객체를 그대로 사용하지 않고 InputStreamReader 객체를 통해
		 *    char 단위로 데이터를 처리하는 방법
		 *    - read() 메서드를 사용하여 char 단위로 데이터를 가져올 수 있음
		 *    - 아무리 많은 데이터가 입력되어도 char 타입 크기 만큼만 다룰 수 있기 때문에
		 *      더 많은 데이터나 더 큰 단위 처리할 수 없음
		 *      => 영문 또는 숫자 등 1글자 입력 가능
		 *      => 한글, 한자 등도 처리 가능
		 *      => 별도로 char 타입으로 형변환 필요
		 *    - 한글 등의 char 타입 처리가 가능해 졌지만, 여전히 낮은 수준의 입력 처리 방법
		 */
		
		System.out.println("데이터를 입력하세요.");
		
		// 1. 키보드로 표준 입력 처리를 위한 InputStream 객체 연결(System.in 호출)
//		InputStream is = System.in; // byte 단위로 처리하는 InputStream 객체 생성
		
		// 2. InputStream 객체 -> InputStreamReader 객체로 변환
		//    => InputStreamReader 객체 생성자에 InputStream 객체를 파라미터로 전달
//		InputStreamReader reader = new InputStreamReader(is); // byte -> char 단위로 묶어서 처리
		
		// 위의 두 문장을 한 문장으로 결합
//		InputStreamReader reader = new InputStreamReader(System.in);
		
//		try(InputStreamReader reader = new InputStreamReader(System.in)) {
//			// InputStreamReader 객체의 read() 메서드를 호출하여 char 단위 데이터 1개 읽어오기
//			int n = reader.read();
//			System.out.println("읽어들인 데이터 : " + n + ", 문자 변환 결과 : " + (char)n);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		// char 타입 배열을 사용하여 여러개의 문자 처리 가능
		try(InputStreamReader reader = new InputStreamReader(System.in)) {
			char[] chArr = new char[10]; // 10개 문자 저장 가능한 배열 생성
			
			// InputStreamReader 객체의 read() 메서드를 호출하여 파라미터로 char[] 배열 전달 시
			// 배열 크기만큼 문자 데이터 읽어올 수 있음
			int n = reader.read(chArr);
			
			// 반복문을 사용하여 String 객체 생성을 통해 복수개의 문자 처리 가능
			String str = new String(chArr);
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
















