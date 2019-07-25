package chapter04;

public class MyDateTest {
	public static void main(String[] args) {
		MyDate md = new MyDate();
		System.out.println(md);

		md.setYear(2017);
		md.setMonth(13);
		md.setDate(32);
		System.out.println(md);
		
		md.setDate(2018, 12, 31);
		System.out.println(md);
	}
}
