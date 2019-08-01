package chapter06;

/**
 * 
 * final : 값 변경 불가
 *	- final 클래스 : 상속 금지
 *	- final 메서드 : override 금지, overload는 무관.
 *	- final 변수 or 로컬변수 : 값 변경 불가
 *
 * Blank Final Variable
 *  - final 속성을 선언시 값으 할당하지 않고 객체 생성시에 값을 할당하여 사용
 *  - 객체마다 다른 고정값 사용
 *  - 모든 생성자에서 Blank Final Variable을 한번 초기화해야 함
 */


class Blank {
	private final int NO;
	static int count;

	public Blank() {
		NO = ++count;
	}

	public Blank(int no) {
		NO = no;
	}

	public int getNO() {
		return NO;
	}
//	public void setNO(int no) { // final 속성이기 떄문에 setter로 값 변경이 불가.
//		NO = no;
//	}
}


//class SubStinrg extends String {} // String은 final 클래스이기 때문에 상속이 불가.

class Super {
	public final void test() {};
}

class Sub extends Super {
//	public final void test() {}; // final 메서드는 오버라이딩 불가.
}

public class FinalTest {
	// private final int NO; // 클래스 내 속성으로 선언할 경우 선언과 동시에 초기화하지 않으면 에러
	
	public static void main(String[] args) {
		final double PI = 3.14;
		// PI = 3.141592; // final로 선언하였기 때문에 값 변경이 불가.
		
		final double PI2;
		PI2 = 3.14; // 최초 1회만 초기화가 가능하고 이후에는 값 변경이 불가.
		// PT2 = 3.141592 // 에러
		
		
	}
}
