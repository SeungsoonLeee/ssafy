package chapter05;

public class Employee {
	private String empno;
	private String name;
	private int salary;

	public Employee() {
	}

	public Employee(String empno, String name, int salary) {
		this.empno = empno;
		this.name = name;
		this.salary = salary;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String toString() {
		return "사원번호 : " + empno + "\t이름 : " + name + "\t연봉 : " + salary;
	}

	void test() {
		System.out.println("Employ의 test");
	}
	
	protected void service() {
		System.out.println("Employ의 서비스");
	}
}
