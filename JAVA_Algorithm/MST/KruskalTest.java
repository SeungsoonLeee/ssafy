package ssafy.com.prim;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class KruskalTest {
	static int V, E, cnt;
	static long totalWeight;
	static int[] parents;
	static Vertex[] vertexs;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; ++test_case) {
			totalWeight = 0;
			cnt = 0;
			V = sc.nextInt();
			E = sc.nextInt();
			parents = new int[V + 1];
			vertexs = new Vertex[E];

			for (int i = 0; i < E; i++)
				vertexs[i] = new Vertex(sc.nextInt(), sc.nextInt(), sc.nextLong());

			// kruskal 알고리즘 활용
			// 1. 간선의 가중치 오름차순으로 정렬
			Arrays.sort(vertexs, new wComparator());

			// 2. 가중치가 낮은 간선부터 트리 연결 & 확장
			// 3. 사이클 여부 판단을 위한 disjoint_set 구현
			// 4. 정점수-1 개의 간선이 선택될 때까지 반복
			Arrays.fill(parents, -1);
			for (Vertex v : vertexs) {
				if (disjointSet(v.from, v.to)) {
					totalWeight += v.weight;
					cnt++;
				}
				if (cnt == V - 1)
					break;
			}

			System.out.printf("#%d %d\n", test_case, totalWeight);
		}
	}

	public static boolean disjointSet(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot) {
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}

	public static int find(int f) {
		if (parents[f] < 0)
			return f;
		return parents[f] = find(parents[f]);
	}

}

class wComparator implements Comparator<Vertex> {
	public int compare(Vertex o1, Vertex o2) {
		return Integer.compare((int) o1.weight, (int) o2.weight);
//		return (int) (o1.weight - o2.weight);
	}
}

class Vertex {
	int from;
	int to;
	long weight;

	public Vertex() {
	}

	public Vertex(int from, int to, long weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

}
