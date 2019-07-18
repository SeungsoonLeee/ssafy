package chapter03;

import java.util.Arrays;
import java.util.Random;

public class LottoTest {
	public static void getLottoNumber(int idx, int[] data) {
		if (data != null && idx < data.length) {
			int temp;
			boolean isDuplication;
			Random r = new Random();
			do {
				temp = r.nextInt(45) + 1;
				isDuplication = false;
				for (int i = 0; i < idx; ++i) {
					if (temp == data[i]) {
						isDuplication = true;
						break;
					}
				}
			} while (isDuplication);
			data[idx] = temp;
		}
	}

	public static void main(String[] args) {
		int num = 6;
		int[] lotto = new int[num];
		for (int i = 0; i < num; i++) {
			getLottoNumber(i, lotto);
		}
		System.out.println(Arrays.toString(lotto));
	}
}
