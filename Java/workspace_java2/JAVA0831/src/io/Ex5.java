package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex5 {

	public static void main(String[] args) {
		/*
		 * 파일 입출력(File IO)
		 * - File 클래스 및 File 관련 입출력 클래스를 조합하여 구현
		 * - 바이너리 파일(Binary File) : 이미지 파일 등(이진 데이터로 구성된 파일)
		 *   => byte 단위로 데이터 처리를 위해 FileInputStream, FileOutputStream 클래스 사용
		 * - 텍스트 파일(Text File) : 일반 텍스트로 구성된 문서 파일
		 *   => char 단위로 데이터 처리를 위해 FileReader, FileWriter 클래스 사용
		 *      => 다시, BufferedReader, PrintWriter 등의 객체로 변환하여 활용 가능
		 */
		
		// ---------------- 지정된 텍스트 파일 내용 읽어와서 출력 -----------------
		// 1. File 객체 생성(지정된 경로와 파일명을 사용하여 File 객체 생성)
		//    => 단, 실제 파일이 생성되는 것은 아니고 메모리 상에 객체만 생성됨
//		File f = new File("D:\\temp\\readme.txt"); // 파라미터로 폴더경로 + 파일명 결합
		File f = new File("D:\\temp", "readme.txt"); // 폴더경로, 파일명 각각 전달도 가능
		
		// 2. FileReader 객체를 사용하여 지정된 File 객체의 파일 읽어오기(char 단위로 처리)
//		FileReader reader = new FileReader(f);
		
		// 3. BufferedReader 객체를 생성하여 FileReader 객체 연결하기(String 단위로 처리)
//		BufferedReader buffer = new BufferedReader(reader);
		
		// 2번, 3번 문장을 하나로 결합
//		BufferedReader buffer = new BufferedReader(new FileReader(f));
		
		// try ~ resources 블록을 활용하여 BufferedReader 객체 사용
		try(BufferedReader buffer = new BufferedReader(new FileReader(f))) {
			// BufferedReader 객체의 readLine() 메서드를 호출하여
			// 읽어들인 파일 내의 한 문장을 String 타입으로 읽어오기(리턴받기)
			String str = buffer.readLine();
			
			// 읽어들인 한 문장이 null 이 아닐 동안 반복하면서 읽어들인 데이터를 출력
			while(str != null) {
				System.out.println(str);
				str = buffer.readLine(); // 다음 문장 읽어오기
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}















