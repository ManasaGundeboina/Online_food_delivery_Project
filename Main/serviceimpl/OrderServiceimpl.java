package com.serviceimpl;

import java.util.List;

import com.entity.Orders;
import com.fooddelivery.dao.OrderDAO;
import com.fooddelivery.daoimpl.OrderDaoimpl;
import com.service.OrderService;

public class OrderServiceimpl implements OrderService {

	OrderDAO orderDAO = new OrderDaoimpl();

	public boolean saveOrder(Orders order) {
		return orderDAO.saveOrder(order);
	}

	public List<Orders> findAll() {
		return orderDAO.findAll();
	}

	public Orders findOrderByID(int id) {
		return orderDAO.findOrderByID(id);
	}

	public boolean updateOrderById(int id, Orders order) {
		return orderDAO.updateOrderById(id, order);
	}

	public boolean removeOrderById(int id) {
		return orderDAO.removeOrderById(id);
	}

	@Override
	public List<Orders> findorderByempID(int empId) {
		return orderDAO.findorderByempID(empId);
	}

	@Override
	public List<Orders> findorderBycustID(int custId) {
		return orderDAO.findorderBycustID(custId);
	}
}
