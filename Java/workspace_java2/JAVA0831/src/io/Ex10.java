package io;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Ex10 {

	public static void main(String[] args) {
		/*
		 * NIO(New IO)
		 * - I/O 관련 기능을 강화시킨 새로운 io 패키지
		 * - Path, Paths, Files 객체를 사용하여 경로와 파일을 관리
		 * - Paths.get() 메서드를 사용하여 Path 객체 리턴받아 사용
		 */
		
		// D드라이브 temp 폴더내의 mydir 폴더내의 readme.txt 파일에 접근하기
		// => Paths.get() 메서드를 호출하여 파일 경로 전달하면 Path 객체 리턴됨
		// 절대 경로 활용 시
		Path path1 = Paths.get("D:/temp/mydir/readme.txt");
		System.out.println("파일명 : " + path1.getFileName()); // readme.txt
		System.out.println("파일 경로명 : " + path1.getParent()); // D:\temp\mydir
		System.out.println("루트명 : " + path1.getRoot()); // D:\
		System.out.println("루트를 제외한 경로 및 파일명 갯수 : " + path1.getNameCount()); // 2
		System.out.println("루트 제외 지정된 경로 및 파일명을 리턴 : " + path1.getName(0));
		// => 0 : 최상위 디렉토리(temp), 1 : 서브 디렉토리(mydir), 2 : 파일명(readme.txt)
		
		// --------------------------------------------------------------------
		// 상대 경로 활용 시
		Path relativePath = Paths.get("./src/io/Ex10.java");
		// => 상대 경로(./XXX 또는 ../XXX 등) 지정 시 현재 위치에서의 상대적인 위치의 XXX 지정
		// => 이클립스 상에서의 현재 위치 = 워크스페이스 프로젝트 폴더 내부
		System.out.println("절대 경로로 변환 : " + relativePath.toAbsolutePath());
		// => E:\Shared\Java\workspace_java2\JAVA0831\.\src\io\Ex10.java
		// => 상대경로 사용 시 현재 위치를 ./ 로 지정할 경우 해당 기호가 경로상에 함께 나타나므로
		//    실제 경로로 사용하기 어려움
		System.out.println("상대 경로 표시 삭제 : " + relativePath.normalize().toAbsolutePath());
		// => E:\Shared\Java\workspace_java2\JAVA0831\src\io\Ex10.java
		
		// toUri() : 경로를 URI 형식으로 변환
		System.out.println("URI 정보 : " + relativePath.normalize().toUri());
		// file:///E:/Shared/Java/workspace_java2/JAVA0831/src/io/Ex10.java
		// => 웹브라우저에서 접근 가능한 주소 형식
		
		// =======================================================================
		String separator = File.separator;
		// 텍스트 파일 지정
//		Path source = Paths.get("D:" + separator + "temp" + separator + "readme.txt");
//		Path destination = Paths.get("D:" + separator + "temp" + separator + "readme_copy.txt");
		
		// 이미지 파일 지정
		Path source = Paths.get("D:" + separator + "temp" + separator + "1.jpg");
//		Path destination = Paths.get("D:" + separator + "temp" + separator + "1_copy.jpg");
		
		// 이미지 이동 위치 지정
		Path destination = 
				Paths.get("D:" + separator + "temp" + separator + "mydir" + separator + "1.jpg");
		
		try {
			// 파일 복사(파일 형식 상관없이 방법 동일)
//			Path result = Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
//			System.out.println("파일 복사 결과 : " + result);
			
			// 파일 이동(파일 형식 상관없이 방법 동일)
			// D:\temp\mydir 로 이동
			Path result = Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("파일 이동 결과 : " + result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}











