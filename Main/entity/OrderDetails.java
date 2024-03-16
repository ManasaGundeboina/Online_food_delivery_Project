package com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrderDetails {
	@Id
	private int orderDetailsId;

	private int quantity;

	@ManyToOne
	Orders orders;

	@OneToOne
	FoodProduct foodProduct;

	public OrderDetails() {
	}

	public OrderDetails(int orderDetailsId, int quantity, Orders order, FoodProduct foodProduct) {
		super();
		this.orderDetailsId = orderDetailsId;
		this.quantity = quantity;
		this.orders = order;
		this.foodProduct = foodProduct;
	}

	public int getorderDetailsId() {
		return orderDetailsId;
	}

	public void setorderDetailsId(int orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public int getquantity() {
		return quantity;
	}

	public void setquantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderDetailsId=" + orderDetailsId + ", quantity=" + quantity + "]";
	}

}
