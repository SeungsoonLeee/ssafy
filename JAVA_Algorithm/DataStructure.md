# 1. 선형 자료구조
일렬로 나타낼 수 있는 1:1 구조의 자료 형태

ex) 배열 . . .

### 1.1. Stack

>먼저 입력된 자료가 나중에 출력되는 FILO(=LIFO) 방식의 자료 구조.
>- stack 기본 메서드 : push, pop, peek, [isEmpty, size 등...]

```java
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
```

### 1.2. Queue

>먼저 입력된 자료가 먼저 출력되는 FIFO(=LILO) 방식의 자료 구조.
>- 종류 : 선형큐, 원형큐, 연결큐
>- Queue 기본 메서드 : enqueue, dequeue, front, rear, [isEmpty, size 등...]

```java
// 자료구조 Queue를 직접 구현해보자.
// 1. 선형 큐
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
```

**※ 선형 큐의 문제점**  
- 잘못된 포화상태 인식 : rear값이 배열의 끝에 다다르면 앞에 deQueue로 인해 비어있는 공간을 체크하지 못한 채 큐가 꽉 차있다고 판단하게 됨.  
- 이러한 문제를 해결하기 위해 배열의 끝에 다다르면 배열의 첫번째로 다시 enQueue하는 형식의 **원형큐**를 사용한다.

```java
// 2. 원형 큐
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
```

### 1.3. List

>순서를 가진 데이터의 집합을 가리키는 추상자료형(abstract data type)
>- 종류
>>순차리스트 : 배열을 기반으로 구현
>>연결리스트 : 메모리의 동적 할당을 기반으로 구현



# 2. 비선형 자료구조
1:N, N:N 구조의 자료 형태

ex) 트리, 그래프 . . .

### 2.1. Tree

>.
>- Tree

```java
// 자료구조 Tree를 직접 구현해보자.

```

### 2.2. Graph

>.
>- Graph

```java
// 자료구조 Graph을 직접 구현해보자.

```