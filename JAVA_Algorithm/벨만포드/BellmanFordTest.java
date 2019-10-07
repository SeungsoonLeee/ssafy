package com.ssafy.bellmanford;

import java.util.Arrays;
import java.util.Scanner;

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