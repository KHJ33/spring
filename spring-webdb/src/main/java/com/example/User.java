package com.example;

public class User {

	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String address;
	
	User(String id, String pwd, String name, String phone, String address) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
