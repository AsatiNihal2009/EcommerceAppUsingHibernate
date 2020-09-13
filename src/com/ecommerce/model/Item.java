package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Item")
public class Item {

	public Item() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private long ID;
	
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "itemName")
	private String itemName;
	@Column(name = "itemTotal")
	private double itemTotal;
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	/**
	 * @param quantity
	 * @param itemName
	 * @param itemTotal
	 */
	public Item(int quantity, String itemName, double itemTotal) {
		this.quantity = quantity;
		this.itemName = itemName;
		this.itemTotal = itemTotal;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemTotal() {
		return itemTotal;
	}
	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
}
