package static_member;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * 싱글톤 디자인 패턴(Singleton Design Pattern)
		 * - 단 하나의 유일한 인스턴스만을 생성하여 공유하도록 하는 기법
		 * - 외부에서 인스턴스를 생성 하지 못하도록 차단하고
		 *   클래스 내에서 직접 인스턴스를 생성 후 외부로 리턴하는 기법
		 * - 누구나 단 하나의 인스턴만을 공유하여 사용해야함
		 *   (=> 즉, 외부에서 new를 통한 새 인스턴스 생성 불가능!)
		 *   
		 * < 패턴 규칙 >
		 * 1. 외부에서 인스턴스 생성이 불가능하다록
		 *    생성자에 private 접근 제한자를 선언하여 정의
		 * 2. 자신의 클래스에서 직접 인스턴스를 생성하여 참조변수에 저장
		 *    => 외부에서 인스턴스 생성없이도 접근 가능하도록 static 키워드 사용
		 *    => 외부에서 함부로 접근하지 못하도록 private 접근 제한자를 선언
		 * 3. 생성된 인스턴스를 외부로 리턴하는 Getter 메서드 정의
		 *    => private 접근제한자로 선언된 멤버변수 instance에 접근하여
		 *       생성된 인스턴스를 리턴하는 용도로 정의
		 *    => 인스턴스 생성없이 호출해야하므로 static 키워드 사용
		 */

		SingletonClass sc = new SingletonClass();
		SingletonClass sc2 = new SingletonClass();
		
	}

}

class SingletonClass {
	String str; // 임시 확인용 변수
	
	// 기본 생성자 정의
	public SingletonClass() {}
}
















