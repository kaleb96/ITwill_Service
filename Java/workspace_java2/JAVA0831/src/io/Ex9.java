package io;

import java.io.File;
import java.io.IOException;

public class Ex9 {

	public static void main(String[] args) {
		/*
		 * java.io.File 클래스
		 * - 파일과 디렉토리(폴더)를 다루는 클래스
		 * - 파일 크기, 속성, 이름, 경로 정보를 얻거나, 생성 또는 삭제 등을 수행 가능
		 * - File 생성자를 통해 객체를 생성하더라도 실제 물리적인 파일이 생성되는 것은 아님
		 *   => 메서드를 통해 직접 생성하거나, 출력스트림을 통해 출력해야함
		 * - File 클래스의 separator 상수를 활용하여 각 운영체제에 맞는 경로 구분자(\ or /) 지정 가능
		 */
		
		// 경로 위치를 저장할 변수 선언
		// D:\temp
		String dirName = "D:" + File.separator + "temp2" + File.separator + "mydir";
		
		// File 클래스 인스턴스 생성 시 파라미터로 경로 전달(실제 경로 or 파일 등과 관계없음)
		File file1 = new File(dirName); // 해당 디렉토리를 직접 접근하거나 생성하는 등의 작업 X
		
		// File 객체의 mkdir() 메서드를 호출하여 D드라이브 temp 폴더 내에 mydir 폴더 생성
//		boolean result = file1.mkdir();
//		System.out.println("mkdir() 메서드 호출 결과 : " + result);
		// => 기존에 존재하는 디렉토리이거나 생성에 실패했을 경우 false 리턴
		// => 만약, 중간 폴더가 존재하지 않을 경우 mydir 생성 불가(false 리턴)
		
		// File 객체의 mkdirs() 메서드는 중간 폴더가 존재하지 않으면 해당 폴더까지 모두 생성
//		result = file1.mkdirs();
//		System.out.println("mkdirs() 메서드 호출 결과 : " + result);
		
		// ----------------------------------------------------------------
		
		try {
			// File 객체 생성 시 문자열로 경로 및 파일명 전달 가능
			File file2 = new File(dirName, "test.txt");
			
			// createNewFile() 메서드를 호출하여 파일 생성 가능
			// => 지정된 경로가 존재하지 않을 경우 IOException 발생
			System.out.println("test.txt 파일 생성 결과 : " + file2.createNewFile());
			
			// 파일 경로를 문자열 대신 다른 File 객체로 지정도 가능
			File file3 = new File(file1, "test2.txt");
			System.out.println("test2.txt 파일 생성 결과 : " + file3.createNewFile());
			
			// 파일 경로를 생략 시 현재 클래스가 위치하는 프로젝트 폴더에 파일이 생성됨
			File file4 = new File("test3.txt");
			System.out.println("test3.txt 파일 생성 결과 : " + file4.createNewFile());
			
			// URI 형식으로 파일 경로 및 파일명 지정 시
//			File file5 = new File("file:///D:/temp2/mydir/test4.txt");
//			System.out.println("test4.txt 파일 생성 결과 : " + file5.createNewFile());
			
			// 지정된 파일 삭제 시 : delete(), deleteOnExit()
			// delete() : 메서드 실행 시점에서 파일 즉시 삭제
//			System.out.println("test3.txt 파일 삭제 결과 : " + file4.delete());
			
			// deleteOnExit() : 메서드 실행 시점이 아닌 해당 프로그램 종료 시점에 파일 삭제
			// => 주로, 임시 파일 생성 후 프로그램이 끝날 때 임시 파일 제거용으로 사용
			file4.deleteOnExit();
			
			for(int i = 1; i <= 10; i++) {
				try {
					Thread.sleep(1000);
					// exists() : 해당 파일 존재 여부 리턴
					// => 주로, 파일 삭제 등에 결합하여 파일이 존재할 경우 또는 존재하지 않을 경우
					//    특정 작업을 수행하는 용도로 사용
					System.out.println(i + "초 경과 - " + file4.exists());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}












