package com.ssafy.step3.dfs;

public class DFSTest2 {
	static int[][] matrix;
	static int totalV;
	static boolean[] visited;
	
	public static void main(String[] args) {
		totalV = 7;
		visited = new boolean[totalV];
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

	// 재귀를 사용하면 더 쉽고 논리적으로 구현이 가능하다.
	public static void dfs(int start) {
		System.out.printf("%c ", start + 65);
		visited[start] = true;
		for (int i = 0; i < totalV; i++) {
			if (matrix[start][i] == 1 && !visited[i])
				dfs(i);
		}
	}
}
