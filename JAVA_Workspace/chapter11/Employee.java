package chapter11;

import java.io.Serializable;

public class Employee implements Serializable{
	private String empno;
	private String name;
	private int salary;
	public Employee() {}
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
	/**
	 * 객체의 내용이나 객체를 대표하는 문자열을 리턴 
	 * - System.out으로 출력할 때  호출된다. 
	 * - 문자열 + 객체   => toString() 를 호출해서 리턴되는 문자열을 연결시킨다. 
	 * - 필요시에 Override
	 * - Override하지 않으면 클래스명@해쉬코드가 리턴된다. 
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(50);
		builder.append("empno=").append(empno).append(", name=").append(name).append(", salary=")
				.append(salary);
		return builder.toString();
	}
//	public String toString() {
////		return "사원번호:" + empno + " 이름:" + name + " 급여:" + salary ;
//	}
	
	/**
	 * 객체의 내용을 비교하는 기능 
	 * - 객체의 내용을 비교해야 한다면 반드시 Override 해야 한다.  
	 */
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Employee) {
			Employee emp = (Employee) obj;
			if( empno != null && empno.equals(emp.empno)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 객체의 hashcode를 리턴하는 기능 
	 * - override할 필요가 없음 
	 * - override 해야 하는 경우 
	 *   1. Set에 동일한 내용의 객체를 저장하고 싶지 않을 때 
	 */
	public int hashCode() {
		int empnoHash = empno != null ? empno.hashCode() : 1; 
		int nameHash  = name != null? name.hashCode() : 1;
		return empnoHash ^ nameHash ^ salary;
	}
	void test() {
		System.out.println("Employee test함수 입니다.");
	}
	protected void service() {
		System.out.println("Employee service함수 입니다.");
	}
}












