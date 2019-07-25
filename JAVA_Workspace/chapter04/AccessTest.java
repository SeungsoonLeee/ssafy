package chapter04;

public class AccessTest {
	public static void main(String[] args) {
		AccessModifier am = new AccessModifier("방", "집", "가족", "공원");
		am.print();

		// 같은 패키지 안에서 public과 protected는 접근이 가능
		// private로 선언한 myRoom는 접근이 불가
		// System.out.println(an.myRoom);
		System.out.println(am.usHouse);
		System.out.println(am.myFamily);
		System.out.println(am.park);
	}
}
