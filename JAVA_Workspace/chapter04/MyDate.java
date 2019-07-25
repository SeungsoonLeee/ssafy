package chapter04;

import java.util.Calendar;

public class MyDate {
	private int year, month, date;
	private Calendar today;

	{ // instance block : 객체를 생성할 때마다 수행되는 block으로 생성자보다 먼저 수행
		today = Calendar.getInstance();
	}

	public MyDate() {
		this.year = today.get(Calendar.YEAR);
		this.month = today.get(Calendar.MONTH) + 1;
		this.date = today.get(Calendar.DATE);
	}

	public void setDate(int year, int month, int date) {
		setYear(year);
		setMonth(month);
		setDate(date);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year < 2018)
			System.out.println("2018년 이상으로 설정해야 합니다.");
		else
			this.year = year;
		setDate(this.date);
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (month < 1 || month > 12)
			System.out.println("1월 ~ 12월 사이로 설정해야 합니다.");
		else
			this.month = month;
		setDate(this.date);
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (this.year % 4 == 0 || this.year % 400 == 0) {
			days[2] = 29;
			if (this.year % 100 == 0)
				days[2] = 28;
		}
		if (date < 1 || date > days[this.month])
			System.out.printf("%d년 %d월은 1일 ~ %d일 사이로 설정해야 합니다.\n", this.year, this.month, days[this.month]);
		else
			this.date = date;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	public String toString() {
		return this.year + "년 " + this.month + "월 " + this.date + "일";
	}

}
