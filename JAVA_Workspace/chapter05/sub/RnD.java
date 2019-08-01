package chapter05_sub;

import chapter05.Employee;

public class RnD extends Employee {
	public void test() {
		System.out.println("RnD의 test함수");
	}

	public void service() {
//		super.service();
		System.out.println("RnD의 서비스");
	}
}
