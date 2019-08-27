package ssafy.com.disjointset;

import java.util.Arrays;
import java.util.Scanner;

public class DisjointSetTest {
	static int[] parents;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = sc.nextInt();
		parents = new int[N];

		// 1. set 만들기
		Arrays.fill(parents, -1);

		for (int i = 0; i < count; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			System.out.println(union(a, b));
		}

		System.out.println(find(0) + "  " + find(1));
		System.out.println(find(3) + "  " + find(4));
		System.out.println(find(2) + "  " + find(3));
		// 0 3
		// 1 4
		// 3 4

	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot != bRoot) {
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}

	private static int find(int f) {
		if (parents[f] < 0) // 음수인 경우 root라는 의미이므로 자기 자신을 리턴
			return f;
		return parents[f] = find(parents[f]); // path compression
	}
}
