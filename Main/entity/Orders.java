package com.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orders {

	@Id
	private int orderId;

	private LocalDate orderDate;

	private int amount;

	private String status;

	@ManyToOne
	private Employee employee;

	@ManyToOne
	private Customer customer;

	public Orders() {
	}

	public Orders(int orderId, LocalDate orderdate, String status, Employee employee, Customer customer) {
		super();
		this.orderId = orderId;
		this.orderDate = orderdate;
		this.status = "Pending";
		this.employee = employee;
		this.customer = customer;
	}

	public int getorderId() {
		return orderId;
	}

	public void setorderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getorderDate() {
		return orderDate;
	}

	public void setorderDate(LocalDate date) {
		this.orderDate = date;
	}

	public int getamount() {
		return amount;
	}

	public void setamount(int amount) {
		this.amount = amount;
	}

	public String getstatus() {
		return status;
	}

	public void setstatus(String status) {
		this.status = status;
	}

}
