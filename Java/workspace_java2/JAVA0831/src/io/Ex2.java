package io;

import java.io.IOException;
import java.io.InputStream;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * < 키보드로 데이터를 입력받는 방법 >
		 * 2. InputStream 객체를 사용하여 1Byte 단위로 데이터를 처리하는 방법
		 *    => byte 타입 배열을 활용하여 복수개의 byte 를 하나의 배열로 묶어서 처리
		 *    - read() 메서드를 사용하여 배열 크기만큼 데이터를 한꺼번에 가져올 수 있음
		 *    - 아무리 많은 데이터가 입력되어도 배열 크기만큼만 다룰 수 있기 때문에
		 *      더 많은 데이터나 더 큰 단위 처리할 수 없음
		 *      => 영문 또는 숫자 등 1Byte 단위(= 아스키코드)만 입력 가능
		 *      => 한글, 한자 등 2Byte(또는 3Byte) 의 char 단위 문자들은 처리 불가능
		 *      => 별도로 char 타입으로 형변환 필요
		 *    - 가장 낮은 수준의 입력 처리 방법
		 *    - 단, String 객체를 활용하면 Byte 타입 배열을 한꺼번에 문자열로 변환 가능
		 */
		
		System.out.println("데이터를 입력하세요.");
		
		try(InputStream is = System.in) {
			// 5Byte 단위로 데이터를 처리하기 위해 5Byte 크기의 배열 생성
			byte[] b = new byte[5];
			
			// InputStream 객체의 read() 메서드 호출 시 파라미터로 byte[] 배열 전달
			int n = is.read(b);
			System.out.println("입력된 데이터 수(= byte 수) : " + n);
			
			// byte 타입 배열 크기만큼 반복을 통해 배열에 저장된 모든 데이터 출력
//			for(byte data : b) {
//				System.out.println(
//						"읽어들인 데이터 : " + data + ", 문자 변환 결과 : " + (char)data);
//			}
			
			// byte[] 타입에 저장된 데이터(문자)들을 하나의 문자열로 결합하는 방법
			// => String 객체 생성 시 파라미터로 byte[] 배열, offset값(0), 읽어들일 크기(n) 전달
			String str = new String(b, 0, n);
			System.out.println("문자열 변환 결과 : " + str);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}











