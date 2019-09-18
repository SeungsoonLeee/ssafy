package chapter09;

public class ThreadTest4 {
	public static void main(String[] args) {
		MyThread t1 = new MyThread("T1");
		MyThread t2 = new MyThread("T2");
		
		t1.setDaemon(true);
		t1.start();
		t2.start();
		
		/**
		 * Daemon Threard : Master Thread가 종료되면 같이 종료되는 Thread
		 * Master Thread : setDaemon(~)을 수행시켜주는 Thread
		 */
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("main end");
	}
}
