
public class Test3 {

	public static void main(String[] args) {
		Account acc = new Account("111-1111-111", "홍길동", 10000);
		acc.showAccountInfo();

	}

}

// Account 클래스 생성
// - 멤버변수 : accountNo, ownerName, balance 선언(private 접근제한자 적용)
// - 생성자 : 파라미터 3개를 전달받아 초기화하는 생성자를 정의
// - Getter/Setter 정의
// - showAccountInfo() 메서드 정의 -> 계좌번호, 예금주명, 현재잔고 출력

class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	
//	public Account() {}
	
	public Account(String accountNo, String ownerName, int balance) {
		// 인스턴스 변수와 로컬변수 이름이 동일하므로
		// 인스턴스 변수(좌변)의 앞에 레퍼런스 this 를(this.xxx) 붙여서 구별
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void showAccountInfo() {
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.println("현재잔고 : " + balance + "원");
	}
	
	
	
}








