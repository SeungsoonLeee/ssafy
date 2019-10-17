package ssafy.com.dijkstra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("dijkstra_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] adMatrix = new int[N][N]; // 정점 정보들을 인접행렬로 표현
		boolean[] visited = new boolean[N]; // 정점 방문여부
		int[] distance = new int[N]; // 시작 정점에서 각 정점까지의 최소 비용이 담길 배열

		Arrays.fill(distance, Integer.MAX_VALUE);

		StringTokenizer st;
		for (int i = 0; i < N; i++) { // i정점부터 j정점까지 비용 저장
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int end = N - 1;
		int min = 0, current = 0;
		distance[0] = 0; // 출발점 (0에서 0까지)의 비용

		for (int i = 0; i < N; i++) {
			min = Integer.MAX_VALUE;
			// 방문하지 않은 정점 중 최소비용의 정점을 찾음
			for (int j = 0; j < N; j++) {
				if (!visited[j] && distance[j] < min) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true;
			if (current == end)
				break;

			// 찾아낸 정점을 경유로 하여 갈 수 있는 방문하지 않은 다른 정점들을 탐색
			for (int j = 0; j < N; j++) {
				if (!visited[j] && adMatrix[current][j] != 0 && min + adMatrix[i][j] < distance[j]) {
					distance[j] = min + adMatrix[i][j];
				}
			}
		}

		System.out.println(distance[end]);

	}
}
