package com.jurib.todolist.dto;

public class Result {

	private boolean isSuccess;
	private String message;
	
	
	public Result() {
		super();
	}


	public Result(boolean isSuccess, String message) {
		super();
		this.isSuccess = isSuccess;
		this.message = message;
	}


	public boolean isSuccess() {
		return isSuccess;
	}


	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "Result [isSuccess=" + isSuccess + ", message=" + message + "]";
	}
	
	
}
