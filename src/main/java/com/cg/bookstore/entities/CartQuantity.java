package com.cg.bookstore.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CartQuantity {
	
	@Id
	private int customerId;
	
	private int cartValue;

	public CartQuantity() {
		super();
	}

	public CartQuantity(int customerId, int cartValue) {
		super();
		this.customerId = customerId;
		this.cartValue = cartValue;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCartValue() {
		return cartValue;
	}

	public void setCartValue(int cartValue) {
		this.cartValue = cartValue;
	}

	
}
