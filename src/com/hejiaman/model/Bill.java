package com.hejiaman.model;

public class Bill {
	private int bill_id;
	private String customer_id;
	private String room_id;
	private String bill_price;
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getBill_price() {
		return bill_price;
	}
	public void setBill_price(String bill_price) {
		this.bill_price = bill_price;
	}
	

}
