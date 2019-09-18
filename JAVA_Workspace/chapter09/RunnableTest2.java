package chapter09;

public class RunnableTest2 {
	public static void main(String[] args) {
		MyRunnable2 mr = new MyRunnable2();
		// runnable의 경우 한 runnable에 다른 Thread가 계속 접근하여 속성값을 변화 시키게 되므로
		// Thread 클래스는 상속받는 경우(각각을 모두 따로 동작)와 다르게 동작한다.
		Thread t1 = new Thread(mr, "T1");
		Thread t2 = new Thread(mr, "T2");
		Thread t3 = new Thread(mr, "T3");

		t1.start();
		t2.start();
		t3.start();
		System.out.println("main end!");
	}
}
