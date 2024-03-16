package com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class FoodProduct {
	@Id
	private int foodProductId;

	private String productName;

	private int price;

	@ManyToOne
	FoodCategory foodCategory;

	public FoodProduct() {
	}

	public FoodProduct(int foodProductId, String productName, int price, FoodCategory foodCategory) {
		super();
		this.foodProductId = foodProductId;
		this.productName = productName;
		this.price = price;
		this.foodCategory = foodCategory;
	}

	public int getfoodProductId() {
		return foodProductId;
	}

	public void setfoodProductId(int foodProductId) {
	this.foodProductId = foodProductId;
	}

	public String getproductName() {
		return productName;
	}

	public void setproductName(String productName) {
		this.productName = productName;
	}

	public int getprice() {
		return price;
	}

	public void setprice(int price) {
		this.price = price;
	}

	public FoodProduct(int foodProductId, String productName, int price, List<Orders> order) {
		super();
		this.foodProductId = foodProductId;
		this.productName = productName;
		this.price = price;

	}

}
