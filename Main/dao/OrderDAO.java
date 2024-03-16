package com.fooddelivery.dao;

import java.util.List;

import com.entity.Orders;

public interface OrderDAO {
	boolean saveOrder(Orders order);

	List<Orders> findAll();

	Orders findOrderByID(int id);

	public List<Orders> findorderByempID(int empId);

	public List<Orders> findorderBycustID(int custId);

	boolean updateOrderById(int id, Orders order);

	boolean removeOrderById(int id);
}