package com.ssafy.step2.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTest {
	static int[][] matrix;
	static int totalV;
	static boolean[] visited;

	public static void main(String[] args) {
		totalV = 7;
		visited = new boolean[totalV];
		matrix = new int[][] { 
			{ 0, 1, 1, 0, 0, 0, 0 },
			{ 1, 0, 0, 1, 1, 0, 0 },
			{ 1, 0, 0, 0, 1, 0, 0 },
			{ 0, 1, 0, 0, 0, 1, 0 },
			{ 0, 1, 1, 0, 0, 1, 0 },
			{ 0, 0, 0, 1, 1, 0, 1 },
			{ 0, 0, 0, 0, 0, 1, 0 } };

		bfs(0);
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		queue.offer(start); // enQueue

		while (!queue.isEmpty()) {
			int current = queue.poll(); // deQueue
			System.out.printf("%c ", current + 65);
			for (int i = 0; i < matrix[current].length; ++i) {
				if (matrix[current][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}
}
