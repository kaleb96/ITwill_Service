package exception;

public class Ex {

	public static void main(String[] args) {
		/*
		 * 예외(Exception)
		 * - 개발자가 의도하지 않은 상황에서 발생하는 문제로
		 *   프로그램이 비정상적으로 종료됨
		 *   => 예외가 발생한 위치부터 아래쪽의 코드를은 실행되지 못함
		 * - 오류(Error)와 달리 심각도가 낮으며, 예외 처리(Exception Handling)을
		 *   통해 예외 발생 시 해결책을 기술하여 비정상적인 종료를 막을 수 있음
		 * - 예외 처리를 위해 try ~ catch 문을 사용하여 처리
		 *   => 예외가 발생할 것으로 예상되는 코드들을 try 블록 내에 기술하고,
		 *      예외가 발생하면 JVM 에 의해 해당 예외 객체를 전달받아
		 *      catch 블록 중 일치하는 타입에 대한 블록을 실행하여 예외 처리
		 *   => 만약에 일치하는 catch 블록이 없을 경우 프로그램은 비정상 종료됨
		 * - Exception 클래스 및 하위 클래스를 사용하여 예외 처리
		 * - 컴파일 시점에서 예외 발생 여부를 체크하는 Compile Checked Exception 과
		 *   실행 시점에서 예외 발생 여부를 알 수 있는 Compile Unchecked Exception 계열로 나뉨
		 *   (Compile Checked Exception 계열 : IOException, SQLException 등)
		 *   (Compile Unchecked Exception 계열 : RuntimeException 계열
		 *    => AarryIndexOutOfBoundsException, NullPointerException 등)
		 *    
		 * < 예외 처리 기본 문법 >
		 * try {
		 * 		// 예외가 발생할 것으로 예상되는 범위의 코드들...
		 * 		// => 예외 발생 코드 아래쪽 나머지 코드는 실행되지 못함
		 * } catch(예외클래스명1 변수명) {
		 * 		// 예외클래스1에 해당하는 예외 발생 시 처리할 코드들...
		 * } catch(예외클래스명n 변수명) {
		 * 		// 예외클래스n에 해당하는 예외 발생 시 처리할 코드들...
		 * } finally {
		 * 		// 예외 발생 여부와 관계없이 무조건 실행할 문장들...
		 * 		// ex) DB 자원 반환, I/O 자원 반환 등
		 * }
		 * 
		 */
		
		System.out.println("프로그램 시작!");
		
		// RuntimeException 클래스 계열들(Compile Unchecked Exception 계열)
//		int num = 0;
//		System.out.println(3 / num);
		// 나눗셈 연산의 피연산자가 0인 경우 ArithmeticException 예외 발생
		// =>  java.lang.ArithmeticException: / by zero
		//     at exception.Ex.main(Ex.java:44)
		//	   => / by zero : 0 에 의한 나눗셈으로 인해 예외 발생했다는 메시지
		//        (Ex.java:44) : Ex.java 파일의 44번 라인에서 예외 발생
		
//		int[] arr = { 1, 2, 3 };
//		System.out.println(arr[5]);
		// 배열에 존재하지 않는 인덱스 접근 시 ArrayIndexOutOfBoundsException 발생
		// java.lang.ArrayIndexOutOfBoundsException: 5 => 5번 인덱스 문제
		// at exception.Ex.main(Ex.java:52) 		   => 52번 라인에서 예외 발생
		
//		String str = null;
//		System.out.println(str.length());
		// 객체의 주소를 참조하지 않는 참조변수(null) 접근 시 NullPointerException 발생
		//  java.lang.NullPointerException
		//  at exception.Ex.main(Ex.java:58) => 58번 라인에서 예외 발생
		

		// 프로그램 종료 문장은 예외가 발생 하면 출력되지 못하고 강제 종료됨
		System.out.println("프로그램 종료!");
		
		System.out.println("==================================");
		
		// 예외 처리
		System.out.println("프로그램 시작!");
		
		try {
			// 예외가 발생할 것으로 예상되는 코드들을 try 블록 내에 위치시킴
			int num = 1;
//			int num = 0;
			System.out.println(3 / num); // ArithmeticException 발생 위치
			// 만약에 이 지점에서 예외 발생 시 나머지 try 블록의 코드들은
			// 실행되지 못하고 바로 catch 문으로 이동함
			
			int[] arr = { 1, 2, 3 };
			System.out.println(arr[2]); //  ArrayIndexOutOfBoundsException 발생 위치
			// ArithmetricException 외에 다른 예외도 처리해야할 경우
			// 또 다른 catch 블록을 추가할 수 있다!
			// => 이 때, catch 블록은 if문처럼 순차적으로 수행됨
			
			String str = null;
			System.out.println(str.length()); // NullPointerException 발생 위치
			// 예외가 복수개 일 때 각각의 예외를 별도로 처리해도 되지만
			// 예외도 클래스이므로 업캐스팅이 가능하므로
			// 상위 예외 타입으로 묶어서 처리 가능
			// ex) NullPointerException + ArithmetricException
			//     = RuntimeException 또는 Exception 클래스 처리 가능
			
			
			System.out.println("try 블록 끝!");			
		} catch(ArithmeticException e) {
			// ArithmetricException 예외가 발생했을 경우 처리할 코드를 기술
			// 예외가 발생하지 않을 경우에는 이 블록은 실행되지 않음
			e.printStackTrace(); // 예외 클래스, 발생 위치, 원인 등을 자세히 출력
			
			// e.getMessage() : 예외 발생 원인 메시지를 문자열로 리턴
			System.out.println("0 으로 나눌 수 없습니다! - " + e.getMessage());
		} catch(ArrayIndexOutOfBoundsException e) {
			// ArrayIndexOutOfBoundsException 예외가 발생했을 경우 처리할 코드를 기술
			System.out.println("배열 인덱스가 잘못 지정됐습니다. - " + e.getMessage());
//		} catch(Exception e) {
//			// 윗쪽의 catch 블록에서 지정되지 않은 나머지 예외들은
//			// Exception 이 기술된 catch 블록에서 모두 처리 가능함
//			// => 단, 각 예외에 따른 처리 방법을 구분할 수 없음
//			System.out.println("나머지 모든 예외 처리 - " + e.getMessage());
		} catch(NullPointerException e) {
		    // => Unreachable catch block for NullPointerException. 
		    //	It is already handled by the catch block for Exception
		    // 주의! Exception 예외 처리 catch 블록이 존재할 경우
			// 해당 예외 아래쪽의 catch 블록은 실행되지 못함
			// => if 문과 마찬가지로 순차적으로 처리되므로
			//    하위 클래스 타입부터 상위클래스 타입순으로 예외 처리 필수!
			System.out.println("null 값을 참조할 수 없음! - " + e.getMessage());
		} catch(Exception e) {
			// 윗쪽의 catch 블록에서 지정되지 않은 나머지 예외들은
			// Exception 이 기술된 catch 블록에서 모두 처리 가능함
			// => 단, 각 예외에 따른 처리 방법을 구분할 수 없음
			// => 주의! 반드시 다른 예외클래스보다 아래쪽에서 catch 필수!
			System.out.println("나머지 모든 예외 처리 - " + e.getMessage());
		}
		
		// try ~ catch 블록 밖의 코드는 예외 발생 여부와 관계없이 실행됨.
		System.out.println("프로그램 종료!");
		
		
		
	}

}












