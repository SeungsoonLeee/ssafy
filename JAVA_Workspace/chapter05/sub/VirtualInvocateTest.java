package chapter05_sub;

import chapter05.Employee;

public class VirtualInvocateTest {
	public static void main(String[] args) {
		Employee emp = new RnD();
		
		// Employ를 RnD에서 상속받은 것이지 VirtualInvocateTest에서 상속받은 것이 아니기 때문에 2개 다 호출되지 않는다.
		// default로 선언한 메서드는 다른 패키지에서 참조하지 못하는 것이 안되는 이유.
		// emp.test();
		// emp.service();
	}
}
