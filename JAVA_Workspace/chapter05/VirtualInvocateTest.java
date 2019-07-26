package chapter05;

import chapter05_sub.RnD;

public class VirtualInvocateTest {
	public static void main(String[] args) {
		Employee emp = new RnD();

		// Employee에서 access modifier를 선언해 주지 않으면 Override된 함수를 호출하지 않는다. 
		emp.test();
		emp.service();
	}
}
