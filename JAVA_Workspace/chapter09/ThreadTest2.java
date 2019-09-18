package chapter09;

public class ThreadTest2 {
	public static void main(String[] args) {
		MyThread t1 = new MyThread("T1");
		MyThread t2 = new MyThread("T2");
		MyThread t3 = new MyThread("T3");
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		
		// start() : 쓰레드를 동작 시킨다.
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("main end");
	}
}
