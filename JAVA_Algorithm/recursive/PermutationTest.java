package com.ssafy.step1.permutation;

public class PermutationTest {
	public static void main(String[] args) {
		// 1, 2, 3 세 수 중 3자리 순열 구하기 by for문
		// 이 방법은 반복문의 횟수가 정해진 경우에만 사용할 수 있다.
		// 즉, 고정된 갯수의 순열만 구할 수 있음.
		int[] num = { 1, 2, 3 };
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j)	continue;
				for (int k = 0; k < 3; k++) {
					if (i == k || j == k)	continue;
					System.out.println(num[i] + " " + num[j] + " " + num[k]);
				}
			}
		}
	}
}
