package com.ssafy.step1.permutation;

public class PermutationTest2 {
	public static void main(String[] args) {
		// 1, 2, 3 세 수 중 2자리 순열 구하기 by for문
		// 마찬가지로 뽑는 수의 갯수가 정해진 경우에만 적용 가능.
		// 이것을 해결하기 위해 재귀적인 방법을 활용한다.
		int[] num = { 1, 2, 3 };
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j)	continue;
				System.out.println(num[i] + " " + num[j]);
			}
		}
	}
}
