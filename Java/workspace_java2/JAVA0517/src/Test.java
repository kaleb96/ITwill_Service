
public class Test {

	public static void main(String[] args) {
		
		VariableArgumentsTest vat = new VariableArgumentsTest();
		vat.print(10,20);
		vat.print(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		vat.print();

	}

}

/*
 * VariableArgumentsTest 라는 Class 정의
 * - 정수를 0개 ~ 무한대로 전달받아 출력하는 print() 메서드 오버로딩
 *   => 단, 정수를 0개 전달할 경우 "전달받은 정수 없음!" 출력하고
 *      1개 이상을 전달할 경우 전달받은 정수를 출력
 */

class VariableArgumentsTest {
	public void print(int... nums) {
		// 정수를 0개 ~ 무한대로 전달받아 출력하는 print() 메서드 오버로딩
		// => 단, 정수를 0개 전달할 경우 "전달받은 정수 없음!" 출력하고
		//    1개 이상을 전달할 경우 전달받은 정수를 출력
		if(nums.length == 0) { // 전달받은 배열의 크기가 0개일 경우
			System.out.println("전달받은 정수 없음!");
		} else { // 전달받은 배열의 크기가 1개 이상일 경우
			for(int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			
		}
	}
}





