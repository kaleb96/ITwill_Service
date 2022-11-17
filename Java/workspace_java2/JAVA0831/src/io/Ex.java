package io;

import java.io.IOException;
import java.io.InputStream;

public class Ex {

	public static void main(String[] args) {
		/*
		 * 자바 I/O(Input/Output)
		 * - java.io 패키지에서 입출력 관련 클래스 제공
		 * - 입출력 대상을 노드(Node) 라고 함
		 *   => 입력 장치 : 키보드, DB, 네트워크, 파일 등
		 *   => 출력 장치 : 모니터, DB, 네트워크, 파일 등
		 * - 스트림(Stream) 이란? 물 흐르듯 끊임없는 데이터를 의미하며
		 *   데이터 입출력에서 데이터를 2진수의 형태로 차례대로 전송한다는 의미로 사용
		 * - 입력 스트림과 출력 스트림으로 구분됨
		 *   => 기본 입력&출력 스트림은 2진수 형태로 데이터를 처리
		 *   => 기본 입력 스트림을 처리하는 객체 : InputStream
		 *      기본 출력 스트림을 처리하는 객체 : OutputStream
		 *      (두 객체 모두 데이터를 Byte 단위로 처리)
		 * - 입출력 스트림 역시 자원을 사용하므로 사용 후에는 반드시 반환 필수!
		 *   => 각 객체의 close() 메서드를 호출하여 자원 반환(= 입출력 스트림 종료)     
		 * 
		 * < 키보드로 데이터 입력 >
		 * 1. InputStream 객체를 사용하여 1Byte 단위로 데이터를 입력받아 처리하는 방법
		 *    - 표준 입력을 처리하기 위하 System 클래스의 in 상수를 사용하여 키보드로부터 입력 받기
		 *      이 때, System.in 을 통해 입력스트림을 연결하면 InputStream 타입 객체가 리턴됨
		 *    - 아무리 많은 데이터가 입력되어도 1Byte 만 다룰 수 있기 때문에
		 *      더 많은 데이터나 더 큰 단위 처리할 수 없음
		 *      => 영문 또는 숫자 등 1Byte 단위(= 아스키코드)만 입력 가능
		 *      => 한글, 한자 등 2Byte(또는 3Byte) 의 char 단위 문자들은 처리 불가능
		 *      => 별도로 char 타입으로 형변환 필요
		 *    - 가장 낮은 수준의 입력 처리 방법
		 */
		
//		InputStream is = null;
//		
//		try {
//			System.out.println("데이터를 입력하세요.");
//			
//			// System.in : 표준 입력 장치(키보드)로부터 데이터 입력받기
//			is = System.in; // 키보드로 입력되는 모든 데이터 스트림을 InputStream 객체로 리턴받아 관리
//			
//			// InputStream 객체의 read() 메서드를 호출하여 입력스트림 중 1Byte 만큼의 데이터 리턴받기
//			int n = is.read(); // 읽어들이는 데이터 중 1Byte 만큼 잘라서 int 형 변수에 저장
//			// 이 때, IOException 처리 필요함
//			
////			System.out.println("입력 데이터 : " + n);
//			System.out.println("입력 데이터 : " + (char)n);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				is.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		// =============================================
		// try ~ resources 구문을 사용하면 별도의 close() 메서드 호출 없이도
		// 작업이 끝난 후 자동으로 close() 메서드 호출을 통해 자원 반환 가능
		// => 자원을 사용하는 객체 생성 관련 코드를 try 문 뒤의 소괄호 내에 기술하면
		//    자원 사용이 끝난 후 자동으로 close() 메서드가 호출됨
		//    (단, auto closing 기능이 제공되는 객체만 사용 가능)
//		System.out.println("데이터를 입력하세요.");
//		
//		try (InputStream is = System.in) { // InputStream 객체가 사용이 끝나면 자동 close() 됨
//			int n = is.read();
//			
//			System.out.println("입력 데이터 : " + (char)n);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		// =========================================
		// 반복문을 사용하여 read() 메서드를 반복 호출하면
		// 입력 데이터가 없을 때까지 반복해서 입력 스트림을 읽어올 수 있다!
		// => read() 메서드 호출 시 입력 데이터가 없을 경우 -1 이 리턴됨
		System.out.println("데이터를 입력하세요.");
		
		try (InputStream is = System.in) { // InputStream 객체가 사용이 끝나면 자동 close() 됨
			int n = is.read(); // 1Byte 데이터 읽어오기
			
			// while 문을 사용하여 읽어들일 데이터가 없을 때까지 1Byte 씩 읽어오기
			while(n != -1) {
				System.out.println("읽어들인 데이터 : " + n + ", 문자 변환 결과 : " + (char)n);
				
				// 반복문 내에서 다음 1Byte 만큼 읽어오기
				n = is.read();
				// => 엔터키 입력도 키보드 입력이므로 /n(13), /r(10) 도 함께 읽어들임
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}













