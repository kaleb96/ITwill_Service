
public class Test {

	public static void main(String[] args) {
		ItwillBank ib = new ItwillBank();
		
		// Account 로부터 상속받은 슈퍼클래스의 멤버 접근
		ib.accountNo = "111-1111-111";
		ib.ownerName = "홍길동";
		ib.balance = 10000;
		ib.showAccountInfo();
		
		ib.deposit(50000);
		
		int money = ib.withdarw(40000);
		System.out.println("출금된 금액 : " + money + "원");
		
		System.out.println("-----------------");
		
		// ItwillBank 의 고유 기능(추가된 기능)
		ib.contract("자동차보험");
		
	}

}

/*
 * Account 클래스를 상속받는 ItwillBank 클래스 정의
 * - Account의 기본 기능(계좌의 기본 기능)은 그대로 유지
 * - 멤버변수 : 계좌번호(accountNo, 문자열), 예금주명(owernName, 문자열)
 *              현재잔고(balance, 정수형)
 * - 메서드 : 
 * 	 1) 입금기능 : deposit() (리턴타입x, 매개변수 amount(정수형))
 *   2) 출금기능 : withdraw() (리턴타입 정수형, 매개변수 amount(정수형))
 *   3) 확인기능 : showAccountInfo() (리턴타입x, 매개변수x)
 *   
 * ItwillBank 클래스
 * - Account 클래스를 상속 받음
 * - 멤버변수 추가 : 보험명(insureName, 문자열)
 * - 메서드 추가 : 보험계약(contract() , 파라미터 : 보험명, 리턴값x) 
 *   => 전달받은 보험명을 멤버변수에 저장 후 "XXX 보험 계약 완료!" 출력
 * 
 */

class Account {
	String accountNo;
	String ownerName;
	int balance;
	
	// 입금기능
	public void deposit(int amount) {
		balance += amount;
		System.out.println("입금하신 금액 : " + amount + "원");
		showAccountInfo();
	}
	
	// 출금 기능
	public int withdarw(int amount) {
		if(balance < amount) { // 현재잔고가 출금금보다 적은지 판별(출금불가)
			System.out.println("잔고가 부족하여 출금이 불가능합니다.");
			System.out.println("출금할 금액 : " + amount +"원, 현재잔고 : " + balance + "원");
			amount = 0;
		} else { // 출금이 가능할 경우(현재잔고 >= 출금금액)
			balance -= amount;
			System.out.println("출금할 금액 : " + amount + "원");
			System.out.println("출금 후 현재잔고 : " + balance + "원");
		}
		
		return amount;
	}
	
	// 확인기능
	public void showAccountInfo() {
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.println("현재잔고 : " + balance + "원");
	}
	
}

class ItwillBank extends Account {
	String insureName; // 보험명
	
	// 보험 계약 기능
	public void  contract(String insureName) {
		this.insureName = insureName;
		System.out.println(insureName + "보험 계약 완료!");
	}
}















