package com.ssafy.model.dto;

import java.io.Serializable;

public class Member implements Serializable {
	private String id  			;
	private String password		;
	private String name			;
	private String email		;
	private String address		;
	private String phone		;
	public Member() {};
	public Member(String id, String password, String name, String email, String address) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	public Member(String id, String password, String name, String email, String address, String phone) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [id=").append(id).append(", password=").append(password).append(", name=").append(name)
				.append(", email=").append(email).append(", address=").append(address).append(", withdraw=")
				.append(phone).append("]");
		return builder.toString();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}







