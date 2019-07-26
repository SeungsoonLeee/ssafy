package chapter05;

import java.util.Arrays;

public class EmployeeManager {
	private Employee[] emps;
	private Manager[] mngs;
	private Engineer[] engs;
	private int empsIdx;
	private int mngsIdx;
	private int engsIdx;

	public EmployeeManager() {
		emps = new Employee[15];
		mngs = new Manager[5];
		engs = new Engineer[5];
	}

	// 사원번호에 해당한 사원을 찾아서 정보를 리턴하는 함수
	public String searchEmp(String empNo) {
		if (empNo != null) {
			for (int i = 0; i < emps.length; i++) {
				if (emps[i].getEmpno().equals(empNo))
					return emps[i].toString();
			}
			for (int i = 0; i < mngs.length; i++) {
				if (mngs[i].getEmpno().equals(empNo))
					return mngs[i].toString();
			}
			for (int i = 0; i < engs.length; i++) {
				if (engs[i].getEmpno().equals(empNo))
					return engs[i].toString();
			}
		}
		return String.format("%s는 등록된 사원번호가 아닙니다.", empNo);
	}

	// 다형성을 이용하지 않으면
	// Employee 외에 다른 클래스에서 사원번호를 검색할 때
	// 동일안 코드를 가진 메서드를 또 생성해야 한다.
	public void addEmp(Employee emp) {
		if (emp != null) {
			String empNo = emp.getEmpno();
			boolean isFind = false;
			if (!isFind) {
				for (int i = 0; i < empsIdx; i++) {
					if (empNo.equals(emps[i].getEmpno())) {
						isFind = true;
						break;
					}
				}
			}
			if (!isFind) {
				for (int i = 0; i < mngsIdx; i++) {
					if (empNo.equals(mngs[i].getEmpno())) {
						isFind = true;
						break;
					}
				}
			}
			if (!isFind) {
				for (int i = 0; i < engsIdx; i++) {
					if (empNo.equals(engs[i].getEmpno())) {
						isFind = true;
						break;
					}
				}
			}
			if (isFind)
				System.out.println("이미 등록된 사원번호 입니다.");
			else {
				if (empsIdx >= emps.length) {
					emps = Arrays.copyOf(emps, empsIdx + 5);
				}
				emps[empsIdx++] = emp;
			}

		}
	}
}
