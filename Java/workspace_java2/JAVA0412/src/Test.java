
public class Test {

	public static void main(String[] args) {
		// 문자 ch에 대해 대문자, 소문자, 숫자 판별!
		// => 위의 모든 조건이 false 일 때 "기타 문자!" 출력
		
		// ch 변수 선언 및 초기화
		char ch = '가';
		
		// if ~ else if ~ else문
		if(ch >= 'A' && ch <= 'Z') { // 대문자
			System.out.println(ch + " : 대문자!");
		} else if(ch >= 'a' && ch <= 'z') { // 소문자
			System.out.println(ch + " : 소문자!");
		} else if(ch >= '0' && ch <= '9') { // 숫자
			System.out.println(ch + " : 숫자!");
		} else {
			System.out.println(ch + " : 기타문자!");
		}
		
		System.out.println("------------------------------");

		// 문자 ch가 대문자일 때 소문자로 변환하고, 소문자일 때는 대문자로 변환
		// => 대문자, 소문자가 아닐 경우 "변환 불가!" 출력
		
		ch = '가';
		
		if(ch >= 'A' && ch <= 'Z') {
			System.out.println(ch + " : 대문자!");
			// 대문자 -> 소문자 변환 (32만큼의 차이, 32만큼 더하기)
			ch += 32;
			System.out.println("소문자 변환 후 : " + ch);
		} else if(ch >= 'a' && ch <= 'z') {
			System.out.println(ch + " : 소문자!");			
			// 소문자 -> 대문자 변환 (32만큼의 차이, 32만큼 빼기)
			ch -= 32;
			System.out.println("대문자 변환 후 : " + ch);
		} else {
			System.out.println(ch + " : 변환불가!");
		}
		
		System.out.println("=====================================");
		
		/*
		 * 학생의 점수를 입력받아 학점 계산 후 출력
		 * - 점수(정수형)를 저장할 변수 score를 선언하고 임의의 점수 저장
		 * - 학점(문자열)을 저장할 변수 grade를 선언하고 널스트링("") 저장
		 * 
		 * if문을 사용하여 임의의 점수를 다음 조건과 비교하고
		 * 비교 결과에 따른 학점을 문자열로 grade 변수에 저장
		 * 학점 "A" : 점수가 90 ~ 100
		 * 학점 "B" : 점수가 80 ~ 89
		 * 학점 "C" : 점수가 70 ~ 79
		 * 학점 "D" : 점수가 60 ~ 69
		 * 학점 "F" : 점수가 0 ~ 59
		 * 
		 * < 출력 예시 >
		 * 85점의 학점 : B
		 */
		
		
		// score 변수 선언 및 초기화
		int score = 150;
		// grade 변수 선언 및 초기화
		String grade = ""; // 큰따옴표(") 안에 아무런 문자가 없는 경우 = null(널)스트링
		
		if(score >= 90 && score <= 100) {
			grade = "A";
//			System.out.println(score + "점의 학점 : " + grade);
		} else if(score >= 80 && score <= 89) {
			grade = "B";
//			System.out.println(score + "점의 학점 : " + grade);
		} else if(score >= 70 && score <= 79) {
			grade = "C";
//			System.out.println(score + "점의 학점 : " + grade);
		} else if(score >= 60 && score <= 69) {
			grade = "D";
//			System.out.println(score + "점의 학점 : " + grade);
		} else if(score >= 0 && score <= 59) {
			grade = "F";
//			System.out.println(score + "점의 학점 : " + grade);
		}
		
		// 모든 조건에서 출력문이 동일하므로 코드 중복 발생함!
		// => 동일한 문장을 실행하는 경우에는 if문 바깥에서 실행할 경우
		//    코드 중복을 제거할 수 있다!
		System.out.println(score + "점의 학점 : " + grade);
	}

}











