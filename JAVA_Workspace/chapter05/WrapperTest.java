package chapter05;

public class WrapperTest {
	public static void main(String[] args) {
		Integer iPrice = new Integer(3000);
		int price = iPrice.intValue();
		
		Double IPI = 3.14; //auto Boxing
		double pi = IPI; //auto Unboxing
		
		Object inum = 236;
		
		/**
		 *  문자열 데이터를 해당 format의 primitivie
		 *   parseXXX(String 값)
		 *    - 잘못된 format으로 변경하면  NumberForatException 발생
		 */
		price = Integer.parseInt("3000");
		double rate = Double.parseDouble("0.1");
		System.out.println(price + " " + rate);
	}
}
