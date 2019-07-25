package chapter04;

class Myutil {
	/**
	 * Method Overloading
	 *  - 인자(인자의 개수, 인자의 타입, 인자의 순서)를 다르게 하여 동일한 이름의 함수를 여러개 선언
	 *  - 인자를 통해 함수를 구별하여 불러들임
	 *  - 인자에 따라 새로운 메서드를 선언하지 않고 같은 메서드 명으로 동일한 기능을 수행하도록 할 수 있음
	 */
	public int plus(int a, int b) {
		return a + b;
	}

	public double plus(double a, double b) {
		return a + b;
	}
}

public class MethodOverloadingTest {
	public static void main(String[] args) {
		Myutil mu = new Myutil();
		
		// type에 맞는 함수를 overloading하여 호출
		System.out.println(mu.plus(10, 20));
		System.out.println(mu.plus(10.5, 20.5));
	}
}
