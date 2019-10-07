# 벨만포드(Bellman-Ford) 알고리즘  
단일 시작된 최단 경로를 구하는 알고리즘으로 다익스트라보다 느리지만 음수 간선을 포함한 경로까지 최단 경로를 찾을 수 있다.  
시작점에서 각 정점까지 가는 최단 거리의 상한을 정당히 예측한 뒤, 예측 값과 계산된 실제 최단거리 사이의 오차를 반복적으로 줄여가는 방식으로 동작한다.  

## 시작노드 s에서 v까지 이르는 최단 경로  
**s에서 u까지의 최단 경로에 u에서 v사이의 가중치를 더한 값**  
> D(s, v) = D(s, u) + w(u, v)  

## 음수사이클 판단  
- 음수 사이클이 존재하는 그래프는 무한히 거리가 작아지기 때문에 최단거리를 구할 수 없다.  
- 간선의 수가 V개라면 V-1번 동안 모든 간선에 대해 완화 과정을 수행하지만 음수 사이클이 존재한다면 이후에도 완화가 진행된다.(이것으로 음수사이클 판단 가능)  
- 완화 과정 : 싸이클 1회 수행 이후 최소 거리를 갱신하는 과정  
- 시간 복잡도 : O(|V|*|E|) ≒ O(|V|³)  

## 구현 코드

```java
public class BellmanFordTest {
	static final int INF = Integer.MAX_VALUE;
	static int N; // 정점 수
	static int M; // 간선 수
	static int[] distance;
	static Edge[] edges;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점 수
		M = sc.nextInt(); // 간선 수
		distance = new int[N + 1];
		edges = new Edge[M];
		Arrays.fill(distance, INF);
		for (int i = 0; i < M; i++) {
			edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		distance[1] = 0;
		if (goNegativeCycle()) {
			System.out.println(-1);
		} else {
			for (int i = 2; i <= N; i++) {
				System.out.println(distance[i] == INF ? -1 : distance[i]);
			}
		}
	}

	private static boolean goNegativeCycle() {
		for (int i = 1; i <= N; i++) {
			for (Edge e : edges) {
				if (distance[e.from] == INF)
					continue;
				if (distance[e.from] + e.c < distance[e.to]) {
					distance[e.to] = distance[e.from] + e.c;
					if (i == N)
						return true; // 최소시간이 업데이트 된 경우 라운드수가 정점카운트와 동일하다면 음수싸이클이 존재
				}
			}
		}
		return false;
	}
}

class Edge {
	int from;
	int to;
	int c;

	public Edge() {
	}

	public Edge(int from, int to, int c) {
		this.from = from;
		this.to = to;
		this.c = c;
	}
}
```