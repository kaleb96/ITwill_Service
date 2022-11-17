package enum_type;

public class Ex3 {

	public static void main(String[] args) {
		Month2 now = Month2.FEBRUARY;
		System.out.println(now + ", " + now.getMonthKor());

	}

}

enum Month2 {
	// 생성자를 사용하면 상수에 다른 값을 결합할 수 있음.
	JANUARY("1월"), FEBRUARY("2월"); // 영어 달 이름과 한국어 달 이름 결합
	
	private String monthKor;

	private Month2(String monthKor) { // 달 이름을 문자열로 전달받아 초기화
		this.monthKor = monthKor;
	}

	public String getMonthKor() {
		return monthKor;
	}

	public void setMonthKor(String monthKor) {
		this.monthKor = monthKor;
	}
	
	
	
	
	
}
