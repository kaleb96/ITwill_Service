
public class Test {

	public static void main(String[] args) {
		// 은행계좌(Account) 클래스의 인스턴스(acc) 생성
		Account acc = new Account();
		
		// accountNo, ownerName, balance를 출력 시 
		// 각각 "111-1111-111" , "홍길동", "10000원"이 출력되도록
//		acc.accountNo = "111-1111-111";
//		acc.ownerName = "홍길동";
//		acc.balance = 10000;
//		
//		System.out.println("계좌번호 : " + accountNo);
//		System.out.println("예금주명 : " + ownerName);
//		System.out.println("현재잔고 : " + balance + "원");
		// => 생성자에 의해서 변수 초기화

	}

}

class Account {
	String accountNo;
	String ownerName;
	int balance;
	
	public Account() {
		System.out.println("Account() 기본 생성자 호출됨!");
		
		// 인스턴스 생성 시 기본값으로 가져야할 데이터를 멤버변수에 저장
		accountNo = "111-1111-111";
		ownerName = "홍길동";
		balance = 10000;
		
		// 인스턴스 생성 시 초기화 후 계좌 정보를 출력하기 위해
		// showAccountInfo() 메서드 호출
		showAccountInfo();
	}
	
	public void showAccountInfo() {
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.println("현재잔고 : " + balance + "원");
	}
	
}





