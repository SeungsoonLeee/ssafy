package com.ssafy.step1.subset;

public class SubsetTest {
	public static void main(String[] args) {
		// 1,2,3으로 만들수 있는 모든 부분집합을 구하라.
		// 3중 for문 활용.
		// 다중 for문은 for문의 수가 고정적일 때만 가능한 방법이다.
		// 재사용이 가능한 코딩을 위해서는 재귀를 적용해야 한다.
		boolean[] selected = new boolean[4];
		int n = 2; // 선택을 했냐 or 안했냐를 따질 것이기 때문에 2번만 비교하면 된다.

		for (int i = 0; i < n; i++) {
			selected[1] = i % 2 == 0 ? true : false; // 1을 선택하였으면 true, 아니면 false
			for (int j = 0; j < n; j++) {
				selected[2] = j % 2 == 0 ? true : false; // 1을 선택하였으면 true, 아니면 false
				for (int k = 0; k < n; k++) {
					selected[3] = k % 2 == 0 ? true : false; // 1을 선택하였으면 true, 아니면 false
					for (int num = 1; num <= 3; ++num) {
						System.out.print((selected[num] ? num : "x") + " ");
					}
					System.out.println();
				}
			}
		}
	}
}
