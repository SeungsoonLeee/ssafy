﻿# BFS(Breadth First Search : 너비 우선 탐색)

트리에서 너비를 우선으로 탐색하는 알고리즘.

**- Queue를 활용한 BFS 구현**

① 처음 방문하는 정점을 방문처리 하고 Queue에 enQueue한다.  
② Queue에 가자 앞에 있는 정점을 deQuque하고 해당 정점과 인접한 방문하지 않은 정점들을 모두 방문처리 한 후 Queue에 enQueue한다.  
③ Queue가 모두 빌 때까지 ②를 반복한다.  
④ ③에서 deQuque하여 나오는 순서가 BFS 순서이다.  

```java
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

```