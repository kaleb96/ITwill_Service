
public class Test2 {

	public static void main(String[] args) {
		// 은행계좌(Account2) 클래스의 인스턴스(acc) 생성
		// 초기화 값으로 "111-1111-111", "홍길동", 10000 (acc)
		Account2 acc = new Account2("111-1111-111", "홍길동", 10000);
		acc.showAccountInfo();
		// 초기화 값으로 "555-5555-555", "이순신", 99999 (acc2)
		Account2 acc2 = new Account2("555-5555-555", "이순신", 99999);
		acc2.showAccountInfo();

	}

}

// 계좌번호, 예금주명, 현재잔고를 전달받아 초기화하는 생성자 Account2() 정의
// accountNo, ownerName, balance 멤버변수
// showAccountInfo() 메서드

class Account2 {
	String accountNo;
	String ownerName;
	int balance;
	
	public Account2(String newAccountNo, String newOwnerName, int newBalance) {
		System.out.println("Account(String, String, int) 생성자 호출됨!");
		
		accountNo = newAccountNo;
		ownerName = newOwnerName;
		balance = newBalance;
		
		// 인스턴스 생성 시 초기화 후 계좌 정보를 출력하기 위해
		// showAccountInfo() 메서드 호출
//		showAccountInfo();
	}
	
	public void showAccountInfo() {
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.println("현재잔고 : " + balance + "원");
	}
	
}