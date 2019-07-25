package chapter04;

public class Account {
	private String no;
	private String password;
	private int balance;

	public Account() {
	}

	public Account(String no, String password, int balance) {
		this.no = no;
		this.password = password;
		setBalance(balance);
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if (balance < 0)
			System.out.println("잔액은 0보다 작게 설정할 수 없습니다.");
		else
			this.balance = balance;
	}

	public int deposit(int amount) {
		this.balance += amount;
		return balance;
	}

	public int withdraw(String password, int amount) {
		if (this.password.equals(password) && this.balance >= amount)
			this.balance -= amount;
		else {
			if (!this.password.equals(password))
				System.out.println("비밀번호가 다릅니다.");
			if (this.balance < amount)
				System.out.println("잔액이 부족합니다.");
		}
		return balance;
	}

	public String toString() {
		return "계좌번호 : " + no + "  잔액 : " + balance;
	}
}
