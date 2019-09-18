package chapter08;

import chapter05.Employee;

public class ExceptionTest {
	public static void main(String[] args) {
		/**
		 * Exception Handling
		 *  프로그램 수행 중 오류가 발생하면 정상적으로 프로그램이 수행되도록 오류를 처리
		 *  1. 오류 직접 처리
		 *   - try catch 예외처리
		 *     try{
		 *      // 오류가 발생될 코드
		 *      // 예외 발생 지점 이후의 코드는 실행되지 않는다.
		 *     }
		 *     catch(예외타입 인자 . . .){
		 *      // 오류 처리
		 *     }
		 *     catch(예외타입 인자 . . .){
		 *      // 오류 처리
		 *     }
		 *     finally{
		 *      // try문 수행 후 항상 수행되는 구간으로 반드시 처리해야하는 코드 작성
		 *      // ex) file, network, db의 close 처리 등..
		 *      // System.exit()를 통해 JVM을 종료시킨 경우를 제외한 모든 경우에서 수행함.
		 *     }  
		 * 
		 *  2. 메서드를 호출한 곳에서 오류를 던져 예외 처리
		 *   - 메서드 선언부에서 예외 처리
		 *     [modifiers] 리턴타입 메서드명([인자들])[throws 예외, ...){ }
		 */
		
		try {
			Employee[] arr = new Employee[2111111111]; // OutOfMemoryError
		} catch (Throwable e) { // Throwable 예외의 최상위 객체로 모든 예외를 받을 수 있다.
			System.out.println("heap 메모리 부족");
		}

		System.out.println("main end");
	}
}
