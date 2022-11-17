
public class Test {

	public static void main(String[] args) {
		// Account2 클래스의 인스턴스(acc) 생성
		Account2 acc = new Account2();
		// Account2 클래스 인스턴스의 모든 멤버변수는 private 이므로
		// 외부에서 접근이 불가능하다!
		
		acc.setAccountNo("111-1111-111");
		acc.setOwnerName("홍길동");
		acc.setBalance(1000);
		
		System.out.println("계좌번호 : " + acc.getAccountNo());
		System.out.println("예금주명 : " + acc.getOwnerName());
		System.out.println("현재잔고 : " + acc.getBalance());

	}

}

class Account2 {
	// Account2 클래스의 멤버변수를 private 접근제한자로 선언
	private String accountNo;
	private String ownerName;
	private int balance;
	
	
	//Getter/Setter 메서드를 정의하여 멤버변수에 간접적으로 접근하도록 수행
	// 1. String accountNo 변수에 대한 Getter/Setter
//	public String getAccountNo() {
//		return accountNo;
//	}
//	
//	public void setAccountNo(String newAccountNo ) {
//		accountNo = newAccountNo;
//	}
//	
//	// 2. String ownerName 변수에 대한 Getter/Setter
//	public String getOwerName() {
//		return accountNo;
//	}
//	
//	public void setOwnerName(String newOwnerName ) {
//		ownerName = newOwnerName;
//	}
//	
//	// 3. int balance 변수에 대한 Getter/Setter
//	public int getBalance() {
//		return balance;
//	}
//	
//	public void setBalance(int newBalance) {
//		balance = newBalance;
//	}
	
	// ========================================================
	// 단축키를 사용하여 Getter/Setter 메서드 자동 정의
	// - 클래스 내에서 멤버변수 선언 후 Alt + Shift + S -> R
	
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
	
	
	
	
}












