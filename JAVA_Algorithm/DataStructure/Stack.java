package com.ssafy.step1.stack;

// 자료구조 stack을 직접 구현해보자.
public class Stack {
	// final 상수는 한번 값을 정하면 변경할 수 없으며, 객체 생성 시에 초기화 해주어야 한다.
	private final int MAX_STACK_SIZE;
	private String[] stack;
	private int top = -1;

	public Stack() {
		this(5);
	}

	public Stack(int maxSize) {
		MAX_STACK_SIZE = maxSize;
		stack = new String[MAX_STACK_SIZE];
	}

	// stack 기본 구조 : push, pop, peek, [isEmpty, size 등...]
	// push
	public void push(String element) {
		if (top >= MAX_STACK_SIZE - 1) {
			System.out.println("Stack Overflow");
			return;
		}
		stack[++top] = element;
	}

	// pop
	public String pop() {
		String e = peek();
		if (e != null)
			stack[top--] = null;
		return e;
	}

	// 예외처리 pop
	public String pop2() {
		String e = peek2();
		if (e != null)
			stack[top--] = null;
		return e;
	}

	// peek
	public String peek() {
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			return null;
		}
		return stack[top];
	}

	// 예외처리 peek
	public String peek2() {
		if (isEmpty()) {
			throw new RuntimeException("Stack Underflow");
		}
		return stack[top];
	}

	// empty
	public boolean isEmpty() {
		return top < 0 ? true : false;
	}

	// size
	public int size() {
		return top + 1;
	}
}
