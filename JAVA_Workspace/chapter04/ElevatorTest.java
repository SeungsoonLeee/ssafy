package chapter04;

public class ElevatorTest {
	public static void main(String[] args) {
		Elevator e = new Elevator(1, 6, -3, true);
		e.choose(3);
		System.out.println("======================");
		e.choose(1);
		System.out.println("======================");
		e.choose(1);
		System.out.println("======================");
		e.choose(-6);
	}
}
