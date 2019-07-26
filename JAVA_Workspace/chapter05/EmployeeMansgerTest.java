package chapter05;

public class EmployeeMansgerTest {
	public static void main(String[] args) {
		EmployeePolyManager em = new EmployeePolyManager();
		
		em.addEmp(new Employee("1", "ssafy", 50000000));
		em.addEmp(new Employee("2", "ssafy", 50000000));
		em.addEmp(new Employee("3", "ssafy", 50000000));
		em.addEmp(new Engineer("4", "ssafy", 50000000, "코딩"));
		em.addEmp(new Manager("5", "ssafy", 50000000, "매니저"));
		em.print();
		System.out.println("----------------------------------------");
		em.update(new Employee("1", "ssafy", 100000000));
		em.print();
		System.out.println("----------------------------------------");
		em.remove("1");
		em.print();
	}
}
