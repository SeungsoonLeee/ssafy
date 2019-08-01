package chapter06;

import java.io.Serializable;

import chapter06_sub.Trans;

/**
 * 
 * Interface
 *  - 상수와 추상 메서드로만 구성되어 있다.
 *  - 속성에 자동으로 public static final이 컴파일 때 추가됨.
 *  - 메서드에 자동으로 public abastract가 컴파일 때 추가됨.
 *  - 객체를 생성할 수 없지만 다형성에 의해 sub는 참조 가능.
 *  - 다중 상속이 가능 -> 다형성 제공
 *  - 선언
 *   [public] interface 인터페이스명 [extends 슈퍼인터페이스명 . . .]{}
 *	- 구현
 *   [modifiers] class 클래스명 [exntends 슈퍼클래스명] [implements 슈퍼인터페이스명 . . .]{}
 *
 */

interface Flyer extends Trans, Cloneable { // 인터페이스끼리는 다중 상속이 가능하다.
	void fly();
}

class Human {
	public void start() {
		System.out.println("시작!");
	}
	
}

class Superman extends Human implements Flyer, Serializable {
	// 인터페이스에 선언된 추상메서드를 반드시 구현해주어야 한다.
	@Override
	public void stop() { // 오버라이드의 access modifier는 반드시 같거나 더 넓은 범위로 해야 한다.
		System.out.println("스탑.");
	}

	@Override
	public void fly() {
		System.out.println("난다~");
	}

}

public class InterfaceTest {
	public static void main(String[] args) {
		System.out.println(Trans.INIT); // package가 다른데 객체 생성 없이접근이 가능하고 속성에 직접 접근할 수 있기 때문에 public static임을 확인할 수 있다.
		// Trans.INIT = 20; // 값 변경이 불가능 하므로 final임을 확인할 수 있다.
		
		Superman man = new Superman();
		// 다형성을 제공하기 때문에 아래와 같은 코드가 모두 가능하다.
		Trans t = man;
		Flyer f = man;
		Human h = man;
		Cloneable c = man;
	}
}
