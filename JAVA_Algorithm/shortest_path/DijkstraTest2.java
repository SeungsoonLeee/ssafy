package ssafy.com.dijkstra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DijkstraTest2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("dijkstra_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] adMatrix = new int[N][N]; // 정점 정보들을 인접행렬로 표현
		boolean[] visited = new boolean[N]; // 정점 방문여부
		int[] distance = new int[N]; // 시작 정점에서 각 정점까지의 최소 비용이 담길 배열
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();

		Arrays.fill(distance, Integer.MAX_VALUE);

		StringTokenizer st;
		for (int i = 0; i < N; i++) { // i정점부터 j정점까지 비용 저장
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int end = N - 1;
		Vertex current;
		distance[0] = 0; // 출발점 (0에서 0까지)의 비용
		pq.offer(new Vertex(0, distance[0]));

		while (!pq.isEmpty()) {
			current = pq.poll();
			if (visited[current.vertex])
				continue;
			visited[current.vertex] = true;

			if (current.vertex == end)
				break;

			for (int j = 0; j < N; j++) {
				if (!visited[j] && adMatrix[current.vertex][j] != 0
						&& current.weight + adMatrix[current.vertex][j] < distance[j]) {
					distance[j] = current.weight + adMatrix[current.vertex][j];
					pq.offer(new Vertex(j, distance[j]));
				}
			}
		}

		System.out.println(distance[end]);

	}

	static class Vertex implements Comparable<Vertex> {
		int vertex;
		int weight;

		public Vertex() {
		}

		public Vertex(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}

	}
}
