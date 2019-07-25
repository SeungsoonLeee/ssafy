package chapter04;

public class AccountTest {
	public static void main(String[] args) {
		Account act = new Account("1", "1111", 5000);
		
		System.out.println("입금 후 잔액 : " + act.deposit(5000));
		System.out.println("출금 후 잔액 : " + act.withdraw("2222", 10000));
		System.out.println("출금 후 잔액 : " + act.withdraw("1111", 20000));
		System.out.println("출금 후 잔액 : " + act.withdraw("1111", 10000));
	}
}
