package com.jurib.todolist.dto;

public class Todo {
	
	private int no;
	private String content;
	private String userId;
	private String writeDate; 
	private String endDate; 
	private char done;
	
	public Todo() {
	}

	public Todo(int no, String content, String userId, String writeDate, String endDate, char done) {
		super();
		this.no = no;
		this.content = content;
		this.userId = userId;
		this.writeDate = writeDate;
		this.endDate = endDate;
		this.done = done;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public char getDone() {
		return done;
	}

	public void setDone(char done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [no=" + no + ", content=" + content + ", userId=" + userId + ", writeDate=" + writeDate
				+ ", endDate=" + endDate + ", done=" + done + "]";
	}

}
