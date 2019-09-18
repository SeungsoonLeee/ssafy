package chapter08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 2. 메서드를 호출한 곳에서 오류를 던져 예외 처리
 *  - 메서드 선언부에서 예외 처리 [modifiers] 리턴타입
 *    메서드명([인자들])[throws 예외, ...){ }
 *    
 *  메서드에서 예외를 호출한 곳으로 던지는 이유
 *  1) 오류가 발생한 곳에서 직접 처리하면 처리방법이 고정되므로 상황에 맞는 예외처리가 불가능
 *   -> 호출한 곳의 상황에 맞게 예외처리를 해주기 위해 예외를 던진다.
 *  2) 다양한 오류에 대해 오류가 발생한 곳마다 처리하지 않고 호출한 곳으로 던져 한번에 처리가 가능
 *   -> ex) UI : 이벤트 처리하는 곳,   Server : 클라이언트 요청 처리하는 곳
 *  3) 프로그램 수행 중 정상 처리된 결과는 return을 통해 전달하고 비정산적인 상황은 예외를 통해 전달
 *  
 * 
 * 예외 강제 발생
 *  throw 오류 객체
 *  
 */
class MyUtil {
	public static int div(int num1, int num2) throws Exception {
		// CheckedException은 반드시 예외처리를 해야 한다.
		// 예외처리를 해주지 않으면 compiler 오류
		if (num2 != 0)
			return num1 / num2;
		else
			throw new Exception("0으로는 나눌 수 없습니다.");
	}

	public static int mod(int num1, int num2) {
		// UnCheckedException은 실행 도중 발생한 예외를 처리하므로 컴파일오류에 걸리지 않음.
		// 따라서 예외가 발생하는 필요한 경우에만 예외 처리를 해주면 된다.
		if (num2 != 0)
			return num1 / num2;
		else
			throw new RuntimeException("0으로는 나눌 수 없습니다.");
	}

	public static void load(String fileName) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
	}
}

public class ExceptionTest3 {
	public static void main(String[] args) {
//		try {
//			MyUtill.load("test.txt");
//		} catch (FileNotFoundException e) {
//			System.out.println(e);
//			// e.printStackTrace();
//		}

		try {
//			MyUtill.div(1, 0);
			MyUtil.mod(1, 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println(MyUtil.mod(2, 2));
		System.out.println("main end");
	}
}
