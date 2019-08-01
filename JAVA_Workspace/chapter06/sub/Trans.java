package chapter06_sub;

public interface Trans {
	int INIT = 10; // 인터페이스 내 속성이기 때문에 default로 public static final이 붙는다.

	void start(); // 인터페이스 내 메서드이기 때문에 default로 public abstract가 붙는다.

	void stop();

	// void start2(){}; // abstract이기 때문에 구현부를 추가하면 에러가 난다.
}
