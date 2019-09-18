package chapter09_critical;

public class Consumer extends Thread {
	private SyncStack stack; // MultiThread에 의해 공유될 객체

	public Consumer(SyncStack stack, String name) {
		super(name);
		this.stack = stack;
	}

	public void run() {
		for (int i = 0; i < 100; ++i) {
			synchronized (stack) {
				System.out.println(getName() + " : " + stack.pop());
			}
		}
		System.out.println(stack);
	}
}
