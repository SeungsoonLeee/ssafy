package com.ssafy.step3.dfs;

import java.util.Stack;

public class DFSTest {
	static int[][] matrix;
	static int totalV;
	static boolean[] visited;
	
	public static void main(String[] args) {
		totalV = 7;
		matrix = new int[][]{ 
			{ 0, 1, 1, 0, 0, 0, 0 },
			{ 1, 0, 0, 1, 1, 0, 0 },
			{ 1, 0, 0, 0, 1, 0, 0 },
			{ 0, 1, 0, 0, 0, 1, 0 },
			{ 0, 1, 1, 0, 0, 1, 0 },
			{ 0, 0, 0, 1, 1, 0, 1 },
			{ 0, 0, 0, 0, 0, 1, 0 } };
			
		dfs(0);
	}

	// 재귀를 사용하지 않고 반복문과 stack으로 DFS 구현.
	public static void dfs(int start) {
		Stack<Integer> stack = new Stack<Integer>();
		visited = new boolean[totalV];

		visited[start] = true;
		System.out.printf("%c ", start + 65);

		do {
			for (int i = 0; i < totalV; i++) {
				if (matrix[start][i] == 1 && !visited[i]) {
					stack.push(start);
					visited[i] = true;
					start = i;
					System.out.printf("%c ", start + 65);
					// i를 -1로 보내야지 다시 처음부터 돌며 확인 한다.
					i = -1;
				}
			}
		} while (!stack.isEmpty() && (start = stack.pop()) != -1);

	}
}
