package ssafy.com.prim;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimTest2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("prim_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] adMatrix = new int[N][N]; // 정점 정보들을 인접행렬로 표현
		boolean[] visited = new boolean[N]; // 정점 방문여부
		PriorityQueue<Vertex> list = new PriorityQueue<Vertex>(); // 방문한 정점들을 우선순위큐로 생성

		StringTokenizer st;
		for (int i = 0; i < N; i++) { // i정점부터 j정점까지 비용 저장
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0, result = 0;

		// 1. 임의의 정점(0)을 첫 정점으로 선택
		list.offer(new Vertex(0, 0));

		// 2. 선택한 정점과 인접하는 정점들 중 최소비용의 간선이 존재하는 정점을 선택
		while (!list.isEmpty()) {
			Vertex current = list.poll(); // 최소 비용의 정점이 나옴
			if (visited[current.vertex])// 하지만 이미 처리된 정점이 다시 등장하는 경우가 생길 수 있으므로 이를 처리하는 코드가 필요
				continue;
			visited[current.vertex] = true; // 방문처리하고
			result += current.weight; // 결과값에 더함
			if (++cnt == N) // 모든 정점을 방문했으면 break
				break;

			for (int i = 0; i < N; i++) {
				if (!visited[i] && adMatrix[current.vertex][i] != 0) {
					list.offer(new Vertex(i, adMatrix[current.vertex][i]));
				}
			}

		}

		System.out.println(result);

	}

	static class Vertex implements Comparable<Vertex> {
		int vertex; // 다음 정점까찌의
		int weight; // 가중치

		public Vertex() {
		}

		public Vertex(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) { // 오른차순 정렬
			return Integer.compare(this.weight, o.weight);
		}

	}
}
