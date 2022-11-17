package collection_framework;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		/*
		 * Set 계열 객체를 활용하여 로또 번호 생성기 작성(정렬은 선택)
		 * 1. Set 타입 객체 myLotto 생성
		 * 2. 1 ~ 45 사이의 중복되지 않는 난수(로또번호) 6개를 set 객체에 저장
		 *    => ex) "나의 로또 번호 : 1 10 11 15 23 41 43" 출력
		 * -------------------------------------------------------------------
		 * 3. 이번주 로또 1등 당첨 번호를 Set 객체 thisWeekLotto에 저장
		 *    => ex) "이번주 1등 당첨번호 : 7 8 11 13 15 23" 출력
		 * 4. 기존의 myLotto 에 저장된 번호와 1등 당첨번호를 비교하여
		 *    일치하는 번호 개수와 등수 출력
		 *    => ex) 번호가 3개(11, 15, 23) 일치 시
		 *           "일치하는 번호 개수 : 3개(4등)"
		 *    => 6개 일치: 1등, 5개 : 2등, 4개 : 3등, 3개 : 4등, 나머지 : 꽝
		 *----------------------------------------------------------------------
		 * => 당첨번호와 일치하면 증가할 카운트 변수 선언
		 * => 1. 향상된 for문 사용 (p558)
		 *    2. Iterator 사용 (p566 ~ 567)    
		 * => contains() 메서드를 활용하여 카운트 변수를 증가 시킴
		 * => 카운트 변수를 Switch ~ case 문을 활용하여 등수 출력
		 *    ex) 6개가 일치할때(카운트가 6이면) "1등!" 출력     
		 */
		
		// Set 객체 생성
		// => 만약, 정렬까지 수행하려면 TreeSet 객체 생성
//		Set<Integer> thisWeekLotto = new TreeSet<Integer>();
//		thisWeekLotto.add(7);
//		thisWeekLotto.add(8);
//		thisWeekLotto.add(11);
//		thisWeekLotto.add(13);
//		thisWeekLotto.add(15);
//		thisWeekLotto.add(23);
//		System.out.println(thisWeekLotto);

		Set<Integer> thisWeekLotto = new TreeSet<Integer>(Arrays.asList(7, 8, 11, 13, 15, 23));
		System.out.println("이번주 로또 1등 번호 : " + thisWeekLotto);
		
		Set<Integer> myLotto = new TreeSet<Integer>();
		// => <Integer> 를 사용하여 TreeSet 객체에는 정수 타입만 입력할 수 있도록 설정
		// => 제네릭(Generic) 이라고 함.
		
//		myLotto.add(1);
//		myLotto.add("1");
		// => 제네릭 타입이 <Integer>이므로 문자열(String) 타입을 추가할 수 없다!!
		
		// 1 ~ 45 사이의 난수(로또번호) 6개를 *중복되지 않는 범위에서* 저장
		// => Set은 중복을 허용하지 않음!
		Random r = new Random();
		
		// while문을 활용한 myLotto 번호 생성
		while(myLotto.size() < 6) {
			myLotto.add(r.nextInt(45) + 1);
		}
		
		// for, if문을 활용한 myLotoo 번호 생성
//		for(int i = 1; i <= 6; i++) {
////			r.nextInt(45) + 1;  // 0 ~ 44까지 범위이므로 +1 을 하여 1 ~ 45까지의 범위를 지정
//			int rNum = r.nextInt(45) + 1;
//			// int rNum = (int)(Math.random() * 45 + 1)
//			
////			if(myLotto.contains(rNum)) { // 조건식이 true면 중복이 되었다!
////				System.out.println("중복되는 번호 발생! - " + rNum);
////				// 중복 번호가 발생했으므로 카운팅을 하지 않도록 i를 1 감소
////				i--;
////			} else {
////				myLotto.add(rNum);
////			}
//			
////			if(!myLotto.add(rNum)) { // 새로 발생한 난수가 이미 있다면 false를 리턴
////									 // false를 !(NOT) 연산자를 사용하여 true로 변경
////				System.out.println("중복되는 번호 발생! - " + rNum);
////				i--;
////			} else {
////				myLotto.add(rNum);
////			}
//		}
		System.out.println("나의 로또 번호 : " + myLotto);
		
		// =======================================================================
		// 당첨번호와 일치하는 개수 카운팅
		int count = 0; // 카운트 결과를 저장할 변수
		
		// 1. 향상된 for문 사용
//		for(int num : myLotto) { // 나의 로또 번호에서 번호 1개 꺼내기
//			// 꺼낸 번호와 1등 담청 번호를 비교
//			if(thisWeekLotto.contains(num)) {
//				count++;
//			}
//			
//		}
		
		// 2. Iterator 사용
		Iterator<Integer> ite = myLotto.iterator();
		while(ite.hasNext()) {
			int num = ite.next();
			
			// 꺼낸 번호와 1등 당첨 번호를 비교
			if(thisWeekLotto.contains(num)) {
				count++;
			}
		}
		
		System.out.println("일치하는 번호의 개수 : " + count + "개");
		
		switch(count) {
			case 6 : System.out.println("1등"); break;
			case 5 : System.out.println("2등"); break;
			case 4 : System.out.println("3등"); break;
			case 3 : System.out.println("4등"); break;
			default : System.out.println("꽝");
		}

	}

}









