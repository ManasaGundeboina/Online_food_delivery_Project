package com.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import com.entity.Customer;
import com.entity.Employee;
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

	public boolean updateOrderById(int orderId, LocalDate orderdate, int amount, String status, Employee employee,	Customer customer) {
		 return orderDAO.updateOrderById(orderId, orderdate, amount, status, employee, customer);
	}

	public boolean removeOrderById(int id) {
		return orderDAO.removeOrderById(id);
	}

	@Override
	public List<Orders> findorderByempId(int empId) {
		return orderDAO.findorderByempId(empId);
	}

	@Override
	public List<Orders> findorderBycustId(int custId) {
		return orderDAO.findorderBycustId(custId);
	}
}
