package com.ssafy.step2.queue;

public class Queue {
	private Object[] queue;
	private final int MAX_QUEUE_SIZE;
	private int front, rear;

	public Queue(int maxSize) {
		MAX_QUEUE_SIZE = maxSize;
		queue = new Object[MAX_QUEUE_SIZE];
		front = rear = -1;
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public boolean isFull() {
		return rear == MAX_QUEUE_SIZE - 1;
	}

	public void enQueue(Object item) {
		if (isFull())
			throw new RuntimeException("Queue Overflow");
		queue[++rear] = item;
	}

	public Object front() {
		if (isEmpty())
			throw new RuntimeException("Queue Underflow");
		return queue[front + 1];
	}

	public Object rear() {
		if (isEmpty())
			throw new RuntimeException("Queue Underflow");
		return queue[rear];
	}

	public Object deQueue() {
		Object result = front();
		queue[++front] = null;
		return result;
	}

	public int size() {
		return rear - front;
	}
}
