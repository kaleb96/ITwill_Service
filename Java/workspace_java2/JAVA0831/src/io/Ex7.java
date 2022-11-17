package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex7 {

	public static void main(String[] args) {
		/*
		 * 자바의 기본 데이터 타입 입출력
		 * - DataInputStream, DataOutputStream 객체 사용
		 *   => 반드시 두 객체 간에만 데이터 입출력(인식) 가능
		 * - 자바의 기본 데이터타입 8가지 + 문자열(String 타입) 입출력 가능
		 *   => readXXX(), writeXXX() 메서드를 통해 입출력을 수행하며
		 *      이 때, XXX 은 자바 데이터타입 이름을 사용
		 *      주의! String 타입은 XXX 부분에 String 대신 UTF 지정
		 *      ex) readUTF(), writeUTF()
		 * - 주의사항! 입출력 시 반드시 순서 지켜야한다!
		 *   ex) int, long, String 순으로 출력했을 경우 int, long, String 순으로 입력해야함
		 */
		
		// File 객체를 사용하여 D드라이브 temp 폴더의 data.dat 파일 지정
		File f = new File("D:\\temp", "data.dat");
		
		// FileOutputStream 객체를 생성하여 File 객체 연결
//		FileOutputStream fos = new FileOutputStream(f);
		
		// DataOutputStream 객체를 생성하여 FileOutputStream 객체 연결
//		DataOutputStream dos = new DataOutputStream(fos);
		
		// 위의 두 문장을 한 문장으로 결합
//		DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
		
		// try ~ resources 블록으로 출력 객체 사용
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(f))) {
			// DataOutputStream 객체의 writeXXX() 메서드를 호출하여 데이터 출력(= 내보내기)
			// => 출력되는 데이터는 D드라이브 temp 폴더 내의 data.dat 파일에 기록됨
			dos.writeInt(100); // 정수 출력
			dos.writeDouble(3.14); // 실수 출력
			dos.writeBoolean(true); // 논리값 출력
			dos.writeUTF("홍길동"); // 문자열 출력(writeString() 메서드 아님!)
			
			// 출력되는 데이터는 OutputStream 객체를 통해 byte 단위로 처리되므로
			// 텍스트 데이터가 아닌 이진 데이터로 관리 => 텍스트 편집기로 인식 불가능한 데이터
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// ===================================================================================
		// DataOutputStream 객체를 통해 출력된 자바 기본 데이터타입 데이터를
		// DataInputStream 객체를 통해 읽어들여 출력하기
		// => D드라이브의 temp 폴더 내의 data.dat 파일 지정하여 읽어오기
		//    File f = new File("D:\\temp", "data.dat");
		
		// 1. FileInputStream 객체를 통해 File 객체 연결
//		FileInputStream fis = new FileInputStream(f);
		
		// 2. DataInputStream 객체를 통해 FileInputStream 객체 연결
//		DataInputStream dis = new DataInputStream(fis);
		
		// 1번, 2번 문장을 한 문장으로 결합
//		DataInputStream dis = new DataInputStream(new FileInputStream(f));
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream(f))) {
			// DataInputStream 객체의 readXXX() 메서드를 호출하여 데이터 가져오기(= 입력)
			// => 가져오는 순서 : int -> double -> boolean -> String 순으로 가져오기
			int num = dis.readInt();
			double dNum = dis.readDouble();
			boolean bool = dis.readBoolean();
			String str = dis.readUTF();
			
			System.out.println("int형 정수 = " + num);
			System.out.println("double형 실수 = " + dNum);
			System.out.println("boolean형 논리값 = " + bool);
			System.out.println("String형 문자열 = " + str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}















