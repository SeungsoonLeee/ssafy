package com.ssafy.step1.divide;

public class PowerTest {
	private static int power(int base, int exp) {
		if (exp <= 0)
			return 1;
		int halfExp = exp / 2;
		int result = power(base, halfExp);
		result *= result;
		if (exp % 2 == 1)
			result *= base;
		return result;
	}

	public static void main(String[] args) {
		System.out.println(power(2, 7));
	}
}
