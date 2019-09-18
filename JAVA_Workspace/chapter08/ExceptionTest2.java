package chapter08;

public class ExceptionTest2 {
	public static void main(String[] args) {
		int result = 0;
		try {
			result = 255 / Integer.parseInt(args[0]);
			return;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException 발생!");
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException 발생!\n0보다 큰 수 입력 요청");
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException 발생!");
		} finally {
			System.out.println("finally 수행");
		}

		System.out.println("result = " + result);
		System.out.println("main end");
	}
}
