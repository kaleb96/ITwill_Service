package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ex6 {

	public static void main(String[] args) {
		// 입력받은 텍스트를 지정된 텍스트 파일로 출력
		System.out.println("출력할 데이터를 입력하세요.");
		
		// 1. File 객체를 생성하여 D 드라이브 temp 폴더에 output.txt 파일 지정
		File f = new File("D:\\temp", "output.txt");
		
		// 2. 키보드로부터 입력을 String 단위로 처리하기 위한 BufferedReader 객체 생성
//		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		// -------------------------------------------------------------------------------------
		// 3. 출력 대상 파일에 데이터 출력을 위해 FileWriter 객체 생성하여 출력할 파일 객체 연결
//		FileWriter writer = new FileWriter(f);
		
		// 4. PrintWriter 객체를 사용하여 FileWriter 객체 연결
//		PrintWriter out = new PrintWriter(writer);
		
		// 3번, 4번 문장을 한 문장으로 결합
//		PrintWriter out = new PrintWriter(new FileWriter(f));
		// -------------------------------------------------------------------------------------
		// try ~ resource 구문을 통해 자동 반환 기능을 활용할 객체 2개 모두 하나의 try 문에 지정
		// => 복수개의 객체 생성 코드를 세미콜론(;)을 통해 구분 가능
		try(BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter out = new PrintWriter(new FileWriter(f))) {
			// 입력받은 텍스트 한 줄(buffer.readLine())을 
			// PrintWriter 객체의 print() 또는 println() 메서드 등을 통해 파일에 출력 
//			out.print(buffer.readLine());
			
			// 반복문을 통해 입력받는 데이터가 Ctrl + Z 가 아닐 동안 파일에 출력
			String str = buffer.readLine();
			
			while(str != null) {
				// PrintWriter 객체의 println() 메서드를 호출하여 한 문장씩 출력(자동 줄바꿈)
				out.println(str);
				str = buffer.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}













