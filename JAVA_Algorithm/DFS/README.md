# DFS(Depth First Search : 깊이 우선 탐색)

트리에서 깊이를 우선으로 탐색하는 알고리즘.

**1. Stack을 활용한 DFS 구현**

① 처음 방문하는 정점 V를 방문처리 하고 stack에 push 한다.  
② V와 인접한 정점들을 탐색하며 방문하지 않은 정점 W가 있으면, 정점 W를 stack에 push하고 인접 정점 탐색 기준을 정점 W로 한다.  
③ ①, ②를 반복하는 중 방문하지 않은 정점 없이 모든 탐색을 마쳤다면  stack을 pop하고 pop한 정점을 기준으로 정점 탐색을 한다.  
④ stack이 공백이 될 때까지 반복한다.  

```java
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
```


**2. 재귀를 활용한 DFS 구현**

① 처음 방문하는 정점 V를 방문처리 한다.  
② V와 인접한 정점들을 탐색하며 방문하지 않은 정점 W가 있으면, 정점 W를 다시 재귀 함수로 호출한다.  

```java
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
```
