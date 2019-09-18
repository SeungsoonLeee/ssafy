package chapter08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 
 * 사용자 정의 Exception
 *  1. UnCheckedException
 *   예외처리를 하지 않아도 컴파일 오류가 발생하지 않는 오류
 *   - RuntimeException과 RuntimeException을 상속받은 sub들
 * 
 *  2. CheckedException
 *   예외처리를 반드시 해주어야 하는 오류. 예외처리를 하지 않으면 컴파일 요류
 *   - RuntimeException과 RuntimeException을 상속받은 sub 외의 예외들
 *    ex) Exception, IOException 등 . . .
 *
 */

// 상속만 받으면 사용자 정의 Exception을 구현할 수 있다.
class MyChecked extends Exception {
	public MyChecked() {
		// 전달 하고자 하는 message는 super에 작성
		super("사용자 정의 체크드 예외 발생!");
		// -> printStackTrace(), getMessage()를 통해 전달 받을 수 있음
	}

	public MyChecked(String msg) {
		super(msg);
	}
}

class MyUnChecked extends RuntimeException {
	public MyUnChecked() {
		// 전달 하고자 하는 message는 super에 작성
		super("사용자 정의 언체크드 예외 발생!");
		// -> printStackTrace(), getMessage()를 통해 전달 받을 수 있음
	}

	public MyUnChecked(String msg) {
		super(msg);
	}
}

class MyUtil2 {
	public static int div(int num1, int num2) throws Exception {
		if (num2 != 0)
			return num1 / num2;
		else
			throw new MyChecked("0으로는 나눌 수 없습니다.");
			// checked는 예외처리를 해주어야 컴파일 에러가 안남.
	}

	public static int mod(int num1, int num2) {
		if (num2 != 0)
			return num1 / num2;
		else
			throw new MyUnChecked("0으로는 나눌 수 없습니다.");
			// uncheked는 예외처리 해주지 않아도 컴파일 에러가 나지 않음.
	}

	public static void load(String fileName) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
	}
}

public class ExceptionTest4 {
	public static void main(String[] args) {
		
		try {
			MyUtil.div(1, 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
