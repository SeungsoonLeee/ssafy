package chapter09_critical;

public class Test {
	public static void main(String[] args) {
		SyncStack stack = new SyncStack();

		Consumer c1 = new Consumer(stack, "C1");
		Consumer c2 = new Consumer(stack, "C2");
		Consumer c3 = new Consumer(stack, "C3");

		Producer p1 = new Producer(stack, "P1");
		Producer p2 = new Producer(stack, "P2");
		Producer p3 = new Producer(stack, "P3");

		c1.start();
		c2.start();
		c3.start();

		p1.start();
		p2.start();
		p3.start();
	}
}
