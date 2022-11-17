
public class Test {

	public static void main(String[] args) {
		// 1 ~ 10까지 1씩 증가하면서, 정수 중 짝수의 합만 계산 후 출력
		//1. 누적변수 선언 및 초기화
		int total = 0;
		// 2. for(초기식; 조건식; 증감식) {
		for(int i = 1; i <= 10; i++) {
			// 정수가 짝수라면?
			if(i % 2 == 0) {
				// 참이면 누적변수에 누적;
				total += i;
				System.out.println("i = " + i + ", total = " + total);
			} else { //짝수가 아닐 때(= 홀수일 때)
				System.out.println(i + " : 홀수이므로 누적 X");
			}
			
		} 
		System.out.println("1 ~ 10까지 정수 중 짝수의 합 = " + total);
		
		System.out.println("=========================================");
		
		// 1 ~ 10까지 1씩 증가하면서, 정수 중 홀수의 합만 계산 후 출력
		total = 0;
		// 2. for(초기식; 조건식; 증감식) {
		for(int i = 1; i <= 10; i++) {
			// 정수가 홀수라면?
			if(i % 2 == 1) {
				// 참이면 누적변수에 누적;
				total += i;
				System.out.println("i = " + i + ", total = " + total);
			} else { //홀수가 아닐 때(= 짝수일 때)
				System.out.println(i + " : 짝수이므로 누적 X");
			}
			
		} 
		System.out.println("1 ~ 10까지 정수 중 홀수의 합 = " + total);
		
		// 1 ~ 10까지 1씩 증가하면서 홀수, 짝수의 합을 각각 누적 후 출력
//		1. 홀수의 합을 더할 누적 변수 선언 및 초기화(oddTotal)
//		   짝수의 합을 더할 누적 변수 선언 및 초기화(evenTotal)
		int oddTotal = 0; 
		int evenTotal = 0;
		   
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 1) { // 홀수일 때
				// 홀수의 합을 저장하는 변수 oddTotal에 i값을 누적
				oddTotal += i;
			} else { // 짝수
				// 짝수의 합을 저장하는 변수 evenTotal에 i값을 누적
				evenTotal += i;
			}
		}
		System.out.println("홀수의 합은 " + oddTotal + "이고, 짝수의 합은 " + evenTotal + "이다.");
		System.out.printf("홀수의 합은 %d이고, 짝수의 합은 %d이다.\n", oddTotal, evenTotal);
		
	}

}
