package chapter05;

public class Manager extends Employee {
	private String position;

	public Manager() {
	}

	public Manager(String empno, String name, int salary, String position) {
		super(empno, name, salary);
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String toString() {
		return super.toString() + "\t직위 : " + position;
	}

}
