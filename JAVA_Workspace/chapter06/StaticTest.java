package chapter06;

/**
 * 
 * static : 정적인 특성 부여
 *  - class가 loading 되는 시점에 한번 할당
 *  - 객체 생성 없이 클래스로만 접근 가능
 *    Class명.속성명;,  Class명.메서드명();
 *    
 *   속성 : 클래스가 로딩될 때 메모리에 한번 할당됨 -> 공유 변수가 됨
 *   메서드 : 클래스가 로딩될 때 메서드 바인등을 함 -> 정적 binding
 *    - 유틸리티성 메서드 작성시 (속성이나, non-static 메서드를 사용하지 않고 전달된 인자로만 처리하는 기능)
 *  
 *  
 *  static block : 클래스가 로딩될 때 한번 수행됨.
 *   - static 속성을 초기화 하거나 단 한번 수행될 코드를 작성
 *   
 *  instance block : 객체가 생성될 떄마다 수행, 생성자보다 먼저 수행됨.
 *   - 어떤 생성자로 객체를 생성하던 공통적으로 수행될 코드가 있다면 instance block에 작성
 */


class Counter {
	static int sCount;
	int iCount;

	public Counter() {
		sCount++;
		iCount++;
	}

	public void print() {
		System.out.println("sCount = " + sCount);
		System.out.println("iCount = " + iCount);
	}
	
	public static void sPrint() {
		System.out.println("sCount = " + sCount);
		// iCount는 객체 생성시에 할당되기 때문에 객체 생성 전에는 변수가 생성되어 있지 않아 접근이 불가하다.
		// System.out.println("iCount = " + iCount);
	}
}

public class StaticTest {
	public static void main(String[] args) {
		System.out.println(Counter.sCount);

		Counter c1 = new Counter();
		c1.print();
		Counter c2 = new Counter();
		c2.print();
		Counter c3 = new Counter();

		System.out.println("-----------");
		c1.print();
		c2.print();
		c3.print();
	}
}
