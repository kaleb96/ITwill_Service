package static_member;

public class Test4 {

	public static void main(String[] args) {
		// Account 인스턴스 생성 시 오류 발생 확인
//		Account acc = new Account();
		
		// 생성된 인스턴스를 리턴받기
		Account acc = Account.getInstance();
		
		// 리턴받은 참조변수를 통해서 Setter() 메서드를 호출하여
		// 계좌번호를 "111-1111-111"로 저장하고,
		// showAccountInfo() 메서드를 통해서 변경된 내용을 확인.
		acc.setAccountNO("111-1111-111");
		acc.showAccountInfo();

	}

}

/*
 * Account 클래스에 대한 싱글톤 패턴 구현
 * - 멤버변수 accountNo, ownerName, balance (접근제한자: private)
 * - 멤버변수 Getter(), Setter() 메서드 설정
 * - 모든 멤버변수에 대한 정보를 출력해주는 showAccountInfo() 메서드 정의
 * - 싱글톤 패턴
 *   1) 인스턴스 생성은 해당 클래스에서 생성 (private, static 설정)
 *   2) 외부(다른 클래스)에서 인스턴스를 생성하지 못하도록 설정
 *   3) 참조하는 주소값을 리턴해주는 Getter() 메서드 설정
 */

class Account {
	// =================== Account 클래스에 대한 싱글톤 패턴 구현 ==================
	private static Account instance = new Account();
	
	private Account() {}
	
	public static Account getInstance() {
		return instance;
	}
	//==============================================================================
	private String accountNo;
	private String ownerName;
	private int balance;

	public String getAccountNO() {
		return accountNo;
	}

	public void setAccountNO(String accountNo) {
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











