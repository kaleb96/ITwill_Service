package thread;

public class Test2 {

	public static void main(String[] args) {
		// 메세지 전송과 파일 전송을 동시에 수행할 경우
		// 1. 싱글쓰레드로 구현한 경우
		SendMessage sm = new SendMessage("안녕하세요", 100);
		FileTrasfer ft = new FileTrasfer("a.java", 100000);
		
		// 파일 전송을 먼저 시작한 후 메세지를 전송한다고 가정
//		ft.run(); // 파일 전송이 끝난 후에야
//		sm.run(); // 메세지 전송이 시작됨
		
		// --------------------------------------------
		// 2. 멀티쓰레드로 구현한 경우
		SendMessageMultiThread smmt = new SendMessageMultiThread("안녕하세요", 100);
		FileTransferMultiThread ftmt = new FileTransferMultiThread("a.java", 100000);
		ReceiveMessageMultiThread rmmt = new ReceiveMessageMultiThread("반갑습니다", 100);
		
		// 파일 전송을 먼저 시작한 후 메시지를 전송한다고 자정
		// => 주의! 반드시 start() 메서드 호출 필수!
		ftmt.start();
		smmt.start();
		
//		rmmt.start(); // Runnable 구현체는 start() 메서드 호출 불가!!
		// => Thread 인스턴스에 Runnable 구현체 전달하여 대신 start() 호출
		Thread t = new Thread(rmmt);
		t.start();
		
		
		

	}

}

// --------------------------------
// 메세지 전송 클래스
// 1. 싱글쓰레드 구현
class SendMessage {
	String msg; // 메시지 저장 변수
	int count; // 카운드 저장 변수
	
	public SendMessage(String msg, int count) {
		super();
		this.msg = msg;
		this.count = count;
	}
	
	public void run() {
		// count 횟수만큼 msg 문자열을 화면에 출력하는 반복문 작성
		// ex) 메세지 전송 - 1 : 안녕하세요
		//     메세지 전송 - 2 : 안녕하세요
		for(int i = 1; i <= count; i++) {
			System.out.println("메세지 전송 - " + i + " : " + msg);
			
		}
		
	}
	
}

// 2. 멀티쓰레드로 구현
// SendMessageMultiThread 클래스 정의
class SendMessageMultiThread extends Thread {
	String msg; // 메세지 저장 변수
	int count; // 카운트 저장 변수
	
	public SendMessageMultiThread(String msg, int count) {
		super();
		this.msg = msg;
		this.count = count;
	}

	@Override
	public void run() {
		// 멀티쓰레딩으로 처리할 작업을 기술
		// count 횟수만큼 msg 문자열을 화면에 출력하는 반복문 작성
		// ex) 메세지 전송 - 1 : 안녕하세요
		//     메세지 전송 - 2 : 안녕하세요
		for(int i = 1; i <= count; i++) {
			System.out.println("메세지 전송 - " + i + " : " + msg);
			
			
			try {
				// 현재 쓰레드를 잠시 딜레이시키는 기능(재우는 기능)
				// => Thread 클래스의 static 메서드 sleep() 메서드 호출
				Thread.sleep(500); // 500ms = 0.5초
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
						
		}
	}
	
	
	
	
	
}


// -------------------------------------------
// 파일 전송 클래스
// 1. 싱글쓰레드로 구현
class FileTrasfer {
	String fileName; // 파일명 저장할 변수
	int count; // 카운트 저장 변수
	
	public FileTrasfer(String fileName, int count) {
		super();
		this.fileName = fileName;
		this.count = count;
	}
	
	public void run() {
		// count 횟수만큼 fileName 문자열을 화면에 출력하는 반복문 작성
		// ex) 파일 전송 - 1 : a.java
		//     파일 전송 - 2 : a.java
		for(int i = 1; i <= count; i++) {
			System.out.println("파일 전송 - " + i + " : " + fileName);
			
		}
	}
	
}

// 2. 멀티쓰레드로 구현
//    FileTransferMultiThread 클래스 정의
class FileTransferMultiThread extends Thread {
	String fileName; // 파일명 저장할 변수
	int count; // 카운트 저장 변수
	
	public FileTransferMultiThread(String fileName, int count) {
		super();
		this.fileName = fileName;
		this.count = count;
	}

	@Override
	public void run() {
		// count 횟수만큼 fileName 문자열을 화면에 출력하는 반복문 작성
		// ex) 파일 전송 - 1 : a.java
		//     파일 전송 - 2 : a.java
		for(int i = 1; i <= count; i++) {
			System.out.println("파일 전송 - " + i + " : " + fileName);
			try {
				// 현재 쓰레드를 잠시 딜레이시키는 기능(재우는 기능)
				// => Thread 클래스의 static 메서드 sleep() 메서드 호출
				Thread.sleep(500); // 500ms = 0.5초
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	
	}
	
}

// ----------------------------------------------------------
// 메세지 수신 클래스
// - 멀티쓰레드로 구현
// ReceiveMessageMultiThread 클래스 정의
// => 단, Thread 클래스를 상속받지 않고 다른 방법으로 구현
//   (Runnable 인터페이스를 구현해야 한다!)
class ReceiveMessageMultiThread extends Object implements Runnable {
	String msg; // 메세지 저장 변수
	int count; // 카운트 저장 변수
	
	public ReceiveMessageMultiThread(String msg, int count) {
		super();
		this.msg = msg;
		this.count = count;
	}

	@Override
	public void run() {
		// 멀티쓰레딩으로 처리할 작업을 기술
		// count 횟수만큼 msg 문자열을 화면에 출력하는 반복문 작성
		// ex) 메세지 수신 - 1 : 반갑습니다
		//     메세지 수신 - 2 : 반갑습니다
		for(int i = 1; i <= count; i++) {
			System.out.println("메세지 수신 - " + i + " : " + msg);
			
			
			try {
				// 현재 쓰레드를 잠시 딜레이시키는 기능(재우는 기능)
				// => Thread 클래스의 static 메서드 sleep() 메서드 호출
				Thread.sleep(500); // 500ms = 0.5초
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
						
		}
	}
	
}











