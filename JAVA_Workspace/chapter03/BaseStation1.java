package chapter03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * NxN 배열을 위한 기지국(A)와 집(H)가에 대한 정보가 주어진다. 
 * 기지국은 상하좌우 1셀씩만 커버한다. 커버하지 못하는 집의 개수를 출력
 *
 * [제약조건]
 * N은 3~15이하
 * 
 * [입력]
 * 첫줄은 테스트 케이스 수(T)가 주어진다.
 * 두번째 줄은 배열 크기(N)이 주어지고
 * 세번째 줄부터 N개의 기지국 정보가 제공된다. 
 * 
 * [출력 결과]
 * #1 4
 * #2 5
 * #3 9
 */
public class BaseStation1 {
	static int AnswerN = 0;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/basestation1.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] d = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		
		for (int test_case = 1; test_case <= T; test_case++) {
			AnswerN = 0;
			int N = sc.nextInt();
			char[][] map = new char[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.next().charAt(0);
					if (map[i][j] == 'H')	AnswerN++;
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'H') {
						int r = i;
						int c = j;
						for (int k = 0; k < d.length; k++) {
							if (r + d[k][0] >= 0 && r + d[k][0] < N && c + d[k][1] >= 0 && c + d[k][1] < N) {
								if (map[r + d[k][0]][c + d[k][1]] == 'A') {
									AnswerN--;
									break;
								}
							}
						}
					}
				}
			}
			
			System.out.println("#" + test_case + " " + AnswerN);
		}
	}// end main
}// end class
