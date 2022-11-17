package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * < 키보드로 데이터를 입력받는 방법 >
		 * 4. InputStreamReader 객체를 그대로 사용하지 않고
		 *    BufferedReader 객체를 사용하여 String 단위로 데이터를 처리하는 방법
		 *    => BufferedReader 객체 생성 시 생서자에 InputStreamReader 객체를 전달하여 얻을 수 있음
		 *    - readLine() 메서드를 사용하여 String 단위(라인)로 데이터를 가져올 수 있음
		 *    - 한 개의 라인(= 한 문장 = 엔터키 입력 전까지) 내에서는 모든 문자 처리 가능
		 *      => 영문 또는 숫자 한글, 한자 등도 처리 가능
		 *      => 별도의 형변환도 불필요
		 *    - 가장 고수준의 입력 처리 방법
		 *    - Scanner 객체 처리 방법과 거의 유사한 형태로 처리
		 */
		
		// 1. 키보드로 표준 입력 처리를 위한 InputStream 객체 연결(System.in 호출)
//		InputStream is = System.in; // byte 단위로 처리하는 InputStream 객체 생성
		
		// 2. InputStream 객체 -> InputStreamReader 객체로 변환
		//    => InputStreamReader 객체 생성자에 InputStream 객체를 파라미터로 전달
//		InputStreamReader reader = new InputStreamReader(is); // byte -> char 단위로 묶어서 처리
		
		// 3. InputStreamReader 객체 -> BufferedReader 객체로 변환
		//    => BufferedReader 객체 생성자에 InputStreamReader 객체를 파라미터로 전달
//		BufferedReader buffer = new BufferedReader(reader); // char -> String 단위로 묶어서 처리
		
		// 위의 세 문장을 한 문장으로 결합
//		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("데이터를 입력하세요.");
		
//		try(BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
//			// BufferedReader 객체의 readLine() 메서드를 호출하여 입력스트림으로부터 한 문장 읽기
//			// => 리턴타입 : String
//			String str = buffer.readLine();
//			System.out.println("읽어온 데이터 : " + str);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		// 위의 동일한 작업(한 문장 처리)을 Scanner 객체로 구현하기
//		Scanner s = new Scanner(System.in);
//		System.out.println(s.next());
		
//		try(BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
//			// BufferedReader 객체의 readLine() 메서드를 호출하여 입력스트림으로부터 한 문장 읽기
//			// => 리턴타입 : String
////			String str = buffer.readLine();
////			System.out.println("읽어온 데이터 : " + str);
//			
//			// 연속적으로 여러 문장을 읽어오기
//			// 단, Ctrl + Z 키가 입력되면 입력 중단
//			// => Ctrl + Z 누를 때 정수로 -1, 문자열일 경우 null 값이 전달됨
//			String str = buffer.readLine(); // 첫 문장 읽어오기
//			
//			// 읽어온 첫 문장이 null 이 아닐 경우 while 문으로 반복
//			while(str != null) {
//				System.out.println("읽어온 데이터 : " + str);
//				str = buffer.readLine(); // 다음 라인 읽어오기
//			}
//			
//			System.out.println("입력을 종료합니다.");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		// ============================================
		// 한 문장씩 입력받아 하나의 문자열로 묶어서 처리할 경우
		try(BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
			String text = ""; // 전체 문장을 저장할 변수 선언
			
			String str = buffer.readLine(); // 첫 문장 읽어오기
			
			// 읽어온 첫 문장이 null 이 아닐 경우 while 문으로 반복
			while(str != null) {
				// 읽어온 한 문장을 전체 문장 저장 변수인 text 에 결합
				text += str + "\n";
				
				str = buffer.readLine(); // 다음 라인 읽어오기
			}
			
			System.out.println("입력을 종료합니다.");
			System.out.println("------------------");
			System.out.println(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}














