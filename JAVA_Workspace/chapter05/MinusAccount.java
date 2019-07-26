package chapter05;

public class MinusAccount extends Account {
	private int limit;

	public MinusAccount() {
	}

	public MinusAccount(String no, String password, int balance, int limit) {
		super(no, password, balance);
		this.limit = limit;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public void setBalance(int balance) {
		if (balance > limit)
			System.out.println("한도를 넘겼습니다.");
		else
			super.setBalance(balance);
	}

	public int deposit(int amount) {
		return super.deposit(amount);
	}

	public int withdraw(String password, int amount) {
		return super.withdraw(password, amount);
	}

}
