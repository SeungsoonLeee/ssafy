package chapter09_critical;

import java.util.ArrayList;

// 데이터가 없으면 wait을 통해 Thread를 멈추고
// 데이터가 추가되면 notify 하도록 수정
public class SyncStack {
	private ArrayList<Character> stack;

	public SyncStack() {
		stack = new ArrayList<>(100);
	}

	public void push(char data) {
//		notify(); // notify는 실행해도 바로 실행하는 것이 아니라 lock pool에서 대기하므로 먼저 선언해주어도 상관 없다.
		stack.add(data);
		notify(); // notify는 실행해도 바로 실행하는 것이 아니라 lock pool에서 대기하므로 먼저 선언해주어도 상관 없다.
	}

	public char pop() {
		char data = ' ';
		while (stack.size() <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		data = stack.remove(stack.size() - 1);
		return data;
	}

	public synchronized String toString() {
		return stack.toString();
	}
}

//// 데이터가 없으면 suspend를 통해 Thread를 멈추고
//// 데이터가 추가되면 resum 하도록 수정
//// 동기화 된 상태에서 suspend 했기 때문에 deadlock이 발새함.
//public class SyncStack {
//	private ArrayList<Character> stack;
//	private Thread t;
//
//	public SyncStack() {
//		stack = new ArrayList<>(100);
//	}
//
//	public void push(char data) {
//		stack.add(data);
//		t.resume();
//	}
//
//	public char pop() {
//		char data = ' ';
//		try {
//			if (stack.size() <= 0) {
//				t = Thread.currentThread();
//				t.suspend();
//			}
//			data = stack.remove(stack.size() - 1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return data;
//	}
//
//	public synchronized String toString() {
//		return stack.toString();
//	}
//}

//
//public class SyncStack {
//	private ArrayList<Character> stack;
//
//	public SyncStack() {
//		stack = new ArrayList<>(100);
//	}
//
//	public void push(char data) {
//		stack.add(data);
//	}
//
//	public char pop() {
//		char data = ' ';
//		try {
//			data = stack.remove(stack.size() - 1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return data;
//	}
//
//	public synchronized String toString() {
//		return stack.toString();
//	}
//}
