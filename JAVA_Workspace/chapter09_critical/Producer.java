package chapter09_critical;

public class Producer extends Thread {
	private SyncStack stack; // MultiThread에 의해 공유될 객체

	public Producer(SyncStack stack, String name) {
		super(name);
		this.stack = stack;
	}

	public void run() {
		for (int i = 0; i < 100; ++i) {
			synchronized (stack) {
				char data = (char) ('A' + Math.random() * 26);
				System.out.println(getName() + " : " + data);
				stack.push(data);
			}
		}
	}
}
