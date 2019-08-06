package com.ssafy.step1.queue;

public class CircularQueue {
	private Object[] queue;
	private final int MAX_QUEUE_SIZE;
	private int front, rear;

	public CircularQueue(int maxSize) {
		MAX_QUEUE_SIZE = maxSize;
		queue = new Object[MAX_QUEUE_SIZE];
		front = rear = 0; // 선형큐와 차이가 보이는 부분 체크
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public boolean isFull() {
		return ((rear + 1) % MAX_QUEUE_SIZE) == front; // 체크
	}

	public void enQueue(Object item) {
		if (isFull())
			throw new RuntimeException("Queue Overflow");
		rear = (rear + 1) % MAX_QUEUE_SIZE; // 체크
		queue[rear] = item;// 체크
	}

	public Object front() {
		if (isEmpty())
			throw new RuntimeException("Queue Underflow");
		return queue[(front + 1) % MAX_QUEUE_SIZE]; // 체크
	}

	public Object rear() {
		if (isEmpty())
			throw new RuntimeException("Queue Underflow");
		return queue[rear];
	}

	public Object deQueue() {
		Object result = front();
		front = (front + 1) % MAX_QUEUE_SIZE; // 체크
		queue[front] = null; // 체크
		return result;
	}
}
