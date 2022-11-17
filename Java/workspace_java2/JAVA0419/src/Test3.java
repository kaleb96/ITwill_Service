
public class Test3 {

	public static void main(String[] args) {
		// 1 ~ 9까지 1씩 증가하면서 출력 for문 작성
//		System.out.println(1);
//		System.out.println(2);
//		System.out.println(3);
//		System.out.println(4);
//		System.out.println(5);
//		System.out.println(6);
//		System.out.println(7);
//		System.out.println(8);
//		System.out.println(9);
		
		for(int i = 1; i < 10; i++) {
			System.out.println(i);
		}
		
		System.out.println("=====================================");
		// ======================================
		/*
		 * for 문을 사용하여 특정 단에 해당하는 구구단 출력
		 * < 2단 >
		 * 2 * 1 = 2
		 * 2 * 2 = 4
		 * 2 * 3 = 6
		 * 2 * 4 = 8
		 * 2 * 5 = 10
		 * 2 * 6 = 12
		 * 2 * 7 = 14
		 * 2 * 8 = 16
		 * 2 * 9 = 18
		 */
		
//		System.out.println(" < 2단 >");
//		System.out.println("2 * 1 = 2");
//		System.out.println("2 * 2 = 4");
//		System.out.println("2 * 3 = 6");
//		System.out.println("2 * 4 = 8");
//		System.out.println("2 * 5 = 10");
//		System.out.println("2 * 6 = 12");
//		System.out.println("2 * 7 = 14");
//		System.out.println("2 * 8 = 16");
//		System.out.println("2 * 9 = 18");
		
		// 단(dan)과 곱해지는 수(i)를 저장할 변수를 선언하고 값을 저장하면
		// 단이 바뀌더라도 대응이 가능하다!
//		int dan = 2;
//		int i = 1;
//		System.out.println(" < " + dan + "단 >");
//		System.out.println(dan + " * " + i + " = " + (dan * i));
//		i++;
//		System.out.println(dan + " * " + i + " = " + (dan * i));
//		i++;
//		System.out.println(dan + " * " + i + " = " + (dan * i));
//		i++;
//		System.out.println(dan + " * " + i + " = " + (dan * i));
//		i++;
//		System.out.println(dan + " * " + i + " = " + (dan * i));
//		i++;
//		System.out.println(dan + " * " + i + " = " + (dan * i));
//		i++;
//		System.out.println(dan + " * " + i + " = " + (dan * i));
//		i++;
//		System.out.println(dan + " * " + i + " = " + (dan * i));
//		i++;
//		System.out.println(dan + " * " + i + " = " + (dan * i));
//		i++;
		
//		System.out.printf(" < %d단 >\n", dan);
//		System.out.printf("%d * %d = %d\n", dan, i, dan*i );
		
		System.out.println("=======================================");
		
		// for문을 사용하여 제어변수 i가 1 ~ 9 까지 1씩 반복하면서
		// 구구단의 단(dan)과 결합하여 구구단을 출력
		int dan = 9;
		System.out.println(" < " + dan + "단 >");
		
		// 반복문을 사용하여 구구단 출력
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", dan, i, dan * i);
		}
	}

}







