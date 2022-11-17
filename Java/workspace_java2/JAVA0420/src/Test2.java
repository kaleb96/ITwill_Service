
public class Test2 {

	public static void main(String[] args) {
		// 바깥쪽 for문 i값이 1 ~ 10까지 반복할 동안 (i는 1씩 증가)
		// 안쪽 for문 j값이 1 ~ 5까지 반복하면서 i와 j값 출력
		for(int i = 1; i <= 10; i++) {
			System.out.println("i = " + i);
			
			for(int j = 1 ; j <= 5; j++) {
				System.out.println("-------> j = " + j);
			}
		}
		
		System.out.println("===================================");
		
		/*
		 * 타이머(XX분 XX초)
		 * - 시(hour) : 0 ~ 23시
		 * - 분(min) : 0 ~ 59분
		 * - 초(sec) : 0 ~ 59초
		 * 
		 * < 출력 예시 >
		 * 0분 0초
		 * 0분 1초
		 * 0분 2초
		 * ... 생략 ...
		 * 0분 59초
		 * 1분 0초
		 * 1분 1초
		 * ... 생략 ...
		 * 59분 58초
		 * 59분 59초
		 *  
		 */
		
		// 바깥쪽 for문으로 분(min, 0 ~ 59) 반복
		for(int min = 0; min <= 59; min++) {
			
			//안쪽 for문으로 초(sec, 0 ~ 59) 반복
			for(int sec = 0; sec <= 59; sec++) {
				
				System.out.println(min + "분" + sec + "초");
				
			}
		}
		
		/*
		 * 중첩 for문을 활용한 구구단 전체 출력(2단 ~ 9단)
		 * 
		 * < 2단 >
		 * 2 * 1 = 2
		 * 2 * 2 = 4
		 * 2 * 3 = 6
		 * 2 * 4 = 8
		 * ... 생략 ...
		 * 
		 * < 3단 >
		 * 3 * 1 = 3
		 * ... 생략 ...
		 * 
		 * < 9단 >
		 * 9 * 1 = 9
		 * 9 * 2 = 18
		 * ... 생략 ...
		 * 9 * 9 = 81
		 * 
		 * => 단(dan)이 2 ~ 9 까지 1씩 증가(바깥쪽 for문)
		 *    이 때, 각 단마다 i 값이 1 ~ 9까지 1씩 증가(안쪽 for문) 
		 *  
		 */
		
		System.out.println("==========================");
		
		// 특정 단의 구구단 출력
//		int dan = 9;
//		System.out.println(" < " + dan + "단 >");
//		
//		for(int i = 1; i <= 9; i++) {
//			System.out.printf("%d * %d = %d\n", dan, i, dan*i);
//		}
		
		// 중첩 for문을 사용하여 2단 ~ 9단까지 출력
		// => 바깥쪽 for문을 단으로 사용
		for(int dan = 2; dan <= 9; dan++) { // 2단 ~ 9단 반복
			System.out.println(" < " + dan + "단 >");
			
			for(int i = 1; i <= 9; i++) { // 1 ~ 9 반복
				System.out.printf("%d * %d = %d\n", dan, i, dan*i);
			}
			System.out.println(); // 빈 라인 넣기
		}
		
		/*
		 * 주사위 2개를 굴려서 주사위 눈의 합이 6일 때 두 주사위 값을 출력
		 * ex) 주사위1 	주사위2		합계
		 * 			1	+	5	=	6
		 * 			2	+	4	=	6
		 * 			3	+	3	=	6
		 * 			4	+	2	=	6
		 * 			5	+	1	=	6
		 * 
		 * 주사위 눈 : 1 ~ 6
		 * 주사위(dice1, dice2) 변수 값을 1 ~ 6까지 1씩 증가하면서 반복하면서
		 * 주사위 눈의 합계가 6인지 판별하여 6일 때 주사위 눈의 값 출력
		 * 
		 */
		
		for(int dice1 = 1; dice1 <= 6; dice1++) {
			
			for(int dice2 = 1; dice2 <= 6; dice2++) {
				
				if(dice1 + dice2 == 6) { // 주사위 눈의 합이 6인지 판별
					// 두 주사위 눈의 합이 6일 때만 출력문 실행
					System.out.println(dice1 + " + " +  dice2 + " = " + (dice1+dice2));
				}
			}
		}
		
		System.out.println("===============================");
		
		// 방정식 4x + 5y = 60 의 해를 구해서 출력하기
		// 단, x와 y는 0 <= x <= 10, 0 <= y <= 10
		for(int x = 0; x <= 10; x++) {
			
			for(int y = 0; y <= 10; y++) {
				
				// 4x + 5y가 60일 때 x, y값을 출력
				int sum = 4 * x + 5 * y;
				
				if(sum == 60) { // if(4 * x + 5 * y == 60) 동일
//					System.out.println("x = " + x + ", y = " + y);
					System.out.printf("x = %d, y = %d 일 때 4x + 5y = %d\n", x, y, sum);
				}
				
			}
		}
		
	}

}







