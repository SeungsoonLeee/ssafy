package chapter05;

import java.util.Arrays;

public class EmployeePolyManager {
	/**
	 * 배열에 다형성을 적용 다형성에 의해 모든 sub 타입은 super 타입으로 자동 형변환이 되기 때문에 super 타입의 배열 하나만
	 * 선언하면 sub타입의 객체도 저장할 수 있다.
	 */

	// super 타입의 배열 선언
	private Employee[] emps;
	private int empsIdx;

	public EmployeePolyManager() {
		emps = new Employee[15];
	}

	public int findIdx(String empno) {
		if (empno != null) {
			for (int i = 0; i < empsIdx; i++) {
				if (emps[i].getEmpno().equals(empno))
					return i;
			}
		}
		return -1;
	}

	// 다형성을 리턴타입에 적용하여 반환하도록 한다.
	// 리턴 타입을 super로 선언하면 sub로 리턴이 가능하다.
	// 사원번호에 해당한 사원을 찾아서 정보를 리턴하는 함수
	public Employee searchEmp(String empno) {
		int idx = findIdx(empno);
		if (idx > -1) {
			return emps[idx];
		}
		return null;
	}

	// 다형성을 인자에 적용한다.
	//
	//
	// 메서드 Overriding을 줄일 수 있다.
	public void addEmp(Employee emp) {
		if (emp != null) {
			String empNo = emp.getEmpno();
			int idx = findIdx(empNo);
			if (idx > -1) {
				System.out.println("이미 등록된 사원번호 입니다.");
			} else {
				if (empsIdx >= emps.length) {
					emps = Arrays.copyOf(emps, empsIdx + 5);
				}
				emps[empsIdx++] = emp;
			}

		}
	}

	public void update(Employee emp) {
		if (emp != null) {
			String empno = emp.getEmpno();
			int idx = findIdx(empno);
			if (idx > -1) {
				emps[idx] = emp;
			} else {
				System.out.println("수정할 사원번호가 등록되어있지 않습니다.");
			}
		}
	}

	public void remove(String empno) {
		int idx = findIdx(empno);
		if (idx > -1) {
			emps[idx] = emps[--empsIdx];
		} else {
			System.out.println("삭제할 사원번호가 등록되어있지 않습니다.");
		}
	}
	
	public void print() {
		for (int i = 0; i < empsIdx; i++) {
			System.out.println(emps[i]);
		}
	}
}
