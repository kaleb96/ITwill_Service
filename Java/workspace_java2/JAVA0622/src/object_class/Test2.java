package object_class;

import java.util.Objects;

public class Test2 {

	public static void main(String[] args) {
		// 계좌번호, 예금주명, 현재잔고가 같은 두 객체를 비교하여
		// 동일한 계좌인지 다른 계좌인지 판단
		// 참조변수를 통해 계좌정보를 출력
		Account acc = new Account("111-1111-111", "홍길동", 10000);
		Account acc2 = new Account("111-1111-111", "홍길동", 10000);
		
		if(acc.equals(acc2)) {
			System.out.println("두 계좌는 동일한 계좌입니다!");
		} else {
			System.out.println("두 계좌는 다른 계좌입니다!");
		}
		
		System.out.println("acc의 계좌정보 : " + acc);
		System.out.println("acc2의 계좌정보 : " + acc2);
		

	}

}

/*
 * Account 클래스 정의
 * - 멤버변수 : 계좌번호(accountNo, 문자열), 예금주명(ownerName, 문자열),
 *              현재잔고(balance, 정수형) 
 *              => 접근권한을 클래스 내로 한정
 * - Getter/Setter 생성
 * - 파라미터 생성자(String, String, int) 생성
 * - equlas() 메서드를 오버라이딩하여 계좌정보를 비교하도록 정의
 * - toString() 메서드를 오버라이딩하여 계좌정보를 문자열로 리턴하도록 정의 
 */

class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	
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
	
	public Account(String accountNo, String ownerName, int balance) {
		super();
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accountNo, other.accountNo) && balance == other.balance
				&& Objects.equals(ownerName, other.ownerName);
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", ownerName=" + ownerName + ", balance=" + balance + "]";
	}
	
	
	
	
}










