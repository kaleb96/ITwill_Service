
public class Test_2 {

	public static void main(String[] args) {
		// 기본생성자 호출
		Account acc = new Account();
		acc.showAccountInfo();
		
		System.out.println("----------------------");

		// 계좌번호를 전달받는 생성자 호출
		Account acc2 = new Account("999-9999-999");
		acc2.showAccountInfo();
		
		System.out.println("----------------------");
		
		// 계좌번호, 예금주명을 전달받는 생성자 호출
		Account acc3 = new Account("999-9999-999", "이순신");
		acc3.showAccountInfo();
		
		System.out.println("----------------------");
		
		// 계좌번호, 예금주명, 현재잔고를 전달받는 생성자 호출
		Account acc4 = new Account("999-9999-999", "이순신", 99999);
		acc4.showAccountInfo();
		
	}

}

/*
 * Account 클래스 정의
 * - 멤버변수 : 계좌번호(accountNo, 문자열), 예금주명(ownerName, 문자열)
 *              현재잔고(balance, 정수)
 * - 기본 생성자 : 계좌번호(111-1111-111), 예금주명(홍길동), 현재잔고(0)
 * - 1) 계좌번호를 입력받고 나머지는 예금주명(홍길동),현재잔고(0) 으로 초기화
 *   2) 계좌번호, 예금주명을 입력받고 현재잔고(0)으로 초기화  
 *   3) 계좌번호, 예금주명, 현재잔고 모두 입력받아 출력
 *   
 * - 메서드 : showAccountInfo() 정의 
 *   ex) 계좌번호 : 111-1111-111
 *       예금주명 : 홍길동
 *       현재잔고 : 0원
 */

class Account {
	
	// 멤버변수(= 필드)
	String accountNo;
	String ownerName;
	int balance;
	
	// 생성자
	public Account() {
		this.accountNo = "111-1111-111";
		this.ownerName = "홍길동";
		this.balance = 0;
	}

	public Account(String accountNo) {
		this.accountNo = accountNo;
		this.ownerName = "홍길동";
		this.balance = 0;
	}

	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = 0;
	}

	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
		
	// 메서드
	public void showAccountInfo() {
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.println("현재잔고 : " + balance + "원");
	}
}















