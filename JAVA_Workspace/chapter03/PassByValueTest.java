package chapter03;

import java.util.Arrays;

/**
 * 자바는 변수에 값을 전달할 떄, 인자에 값을 전달할 떄, 리턴 값을 전달할 때 Pass By Value 형식으로 전달한다. Pass By
 * Value : 변수를 위해 할당된 메모리에 있는 값을 전달. Primitive Type : 변수를 위해 할당된 메모리에 실제 값이 저장.
 * => 변수, 인자, 리턴 값을 전달할 떄 값이 전달 됨 Reference Type : 변수를 위해 할당된 메모리에 참조 값(hash
 * code) 저장. => 변수, 인자, 리턴 값을 전달할 떄 참조값(hash code)이 전달 됨.
 */
public class PassByValueTest {
	public static int passValue(int a) {
		System.out.println("pass value");
		a += 10;
		return a;
	}

	public static void passReference(int[] a) {
		if (a != null && a.length > 0) {
			a[0] = 10;
		}
	}

	public static int[] passReference2(int[] a, int offset, int len) {
		if (a != null && a.length > 0) {
			int[] newData = new int[len];
			for (int i = 0; i < len; i++) {
				newData[i] = a[offset];
			}
			return newData;
		}
		return null;
	}

	public static void main(String[] args) {
		int primitive = 10;
		primitive = passValue(primitive);
		System.out.println(primitive);

		int[] data = { 1, 2, 3 };
		passReference(data);
		// hash code를 전달했기 때문에 값을 리턴받지 않아도 값이 바뀐다.
		System.out.println(Arrays.toString(data));
		
		System.out.println(Arrays.toString(passReference2(data, 0, 3)));
	}
}
