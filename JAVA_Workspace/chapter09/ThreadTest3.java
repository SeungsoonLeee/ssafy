package chapter09;

public class ThreadTest3 {
	public static void main(String[] args) {
		MyThread t1 = new MyThread("T1");
		MyThread t2 = new MyThread("T2");
		MyThread t3 = new MyThread("T3");

		t1.start();
		try {
			// Thread를 t1에 join 시킴 -> join된 쓰레드는 t1이 종료될 때까지 대기 상태
			t1.join(); // main Thread를 t1에 join 시킴
		} catch (Exception e) {
			e.printStackTrace();
		}

		t2.start();
		t3.start();

		System.out.println("main end");
	}
}
