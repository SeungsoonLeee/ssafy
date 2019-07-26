package chapter05;

public class AccountTest {
	public static void main(String[] args) {
		MinusAccount account = new MinusAccount("1", "1111", 5000, 1000000);
		System.out.println("입금 후 잔액 : " + account.deposit(10000));
		System.out.println("출금 후 잔액 : " + account.withdraw("2222", 5000));
		System.out.println("출금 후 잔액 : " + account.withdraw("1111", 5000));
		System.out.println("출금 후 잔액 : " + account.withdraw("1111", 5000));
	}
}
