package com.ecommerce.model;

import java.util.Date;

public class EProduct {

	private int p_id;
	private String name;
	private double price;
	private Date creating_date;
	private Date expiry_date;
	public EProduct(String name, double price, Date creating_date, Date expiry_date) {
		this.name = name;
		this.price = price;
		this.creating_date = creating_date;
		this.expiry_date = expiry_date;
	}
	public EProduct() {
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getCreating_date() {
		return creating_date;
	}
	public void setCreating_date(Date creating_date) {
		this.creating_date = creating_date;
	}
	public Date getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	
}
