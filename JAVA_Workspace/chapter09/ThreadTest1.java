package chapter09;

public class ThreadTest1 {
	public static void main(String[] args) {
		MyThread t1 = new MyThread("T1");
		MyThread t2 = new MyThread("T2");
		MyThread t3 = new MyThread("T3");
		
		// start() : 쓰레드를 동작 시킨다.
		t1.start();
		t2.start();
		t3.start();
		
		// run() 메서드로 직접 호출 시 main에서 돌려주는 Thread가 되므로 동기식으로 동작하게 된다.
		// -> 즉, 차례를 지키며 순서대로 동작시킨다.
//		t1.run();
//		t2.run();
//		t3.run();
		
		System.out.println("main end");
	}
}
