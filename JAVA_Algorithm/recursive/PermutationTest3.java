package com.ssafy.step1.permutation;

import java.util.Stack;

public class PermutationTest3 {
	static Stack<Integer> s = new Stack<Integer>();

	public static void main(String[] args) {
		// 1, 2, 3, 4 네 수 중 2자리 순열 구하기 by 재귀 with Stack
		int[] num = { 1, 2, 3, 4 };
		boolean[] selected = new boolean[num.length];
		permutation(num, selected, 2);

	}

	public static void permutation(int[] num, boolean[] selected, int r) {
		if (r < 1) {
			System.out.println(s.toString());
			return;
		}
		for (int i = 0; i < num.length; ++i) {
			if (!selected[i]) {
				selected[i] = true;
				s.add(num[i]);
				permutation(num, selected, r - 1);
				selected[i] = false;
				s.pop();
			}
		}
	}
}
