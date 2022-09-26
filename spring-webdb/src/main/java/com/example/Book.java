package com.example;

public class Book {

	private Long number;
	private String name;
	private String borrow;
	private String reservation;
	
	public Book(Long number, String name, String borrow, String reservation) {
		this.number = number;
		this.name = name;
		this.borrow = borrow;
		this.reservation = reservation;
	}
	
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBorrow() {
		return borrow;
	}
	public void setBorrow(String borrow) {
		this.borrow = borrow;
	}
	public String getReservation() {
		return reservation;
	}
	public void setReservation(String reservation) {
		this.reservation = reservation;
	}
	
}
