
public class Ex {

	public static void main(String[] args) {
		/*
		 * 반복문을 사용한 연산의 누적(ex. 합계 계산 등)
		 * 1. 연산을 누적할 누적 변수 선언 및 초기화(반복문보다 먼저 수행)
		 * 2. 반복문을 사용하여 특정 횟수 반복
		 * 3. 반복문 내에서 특정 연산(데이터)을 누적 변수에 누적
		 * 4. 반복문 종료 후 누적 변수 값 사용(출력)
		 */
		
		// 1 ~ 5 까지의 합을 계산하여 변수에 저장 후 출력
//		int num = 1; // 합계에 누적될 변수(1 ~ 5까지의 숫자)
//		int sum = 0; // 합계를 누적할 변수(반드시 초기화 필수!)
//		sum = sum + num; // sum + num의 결과를 다시 변수 sum에 저장
//		num++;
//		sum = sum + num; // sum + num의 결과를 다시 변수 sum에 저장
//		num++;
//		sum = sum + num; // sum + num의 결과를 다시 변수 sum에 저장
//		num++;
//		sum = sum + num; // sum + num의 결과를 다시 변수 sum에 저장
//		num++;
//		sum = sum + num; // sum + num의 결과를 다시 변수 sum에 저장
//		num++;
//		System.out.println(sum);
		
		// 1 ~ 10까지의 1씩 증가하는 정수의 합(total)을 계산 후 출력
		int total = 0; // 누적변수 선언 및 초기화
		
		for(int i = 1; i <= 10; i++) {
			// 누적변수에 현재 값 i를 누적
//			total = total + i;
			total += i;
			System.out.println("i = " + i + " , total = " + total);
		}
		
		System.out.println("1 ~ 10까지 정수 합 = " + total);

	}

}








