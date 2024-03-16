package com.serviceimpl;

import java.util.List;

import com.entity.Customer;
import com.fooddelivery.dao.CustomerDAO;
import com.fooddelivery.daoimpl.CustomerDaoimpl;
import com.service.CustomerService;

public class CustomerServiceimpl implements CustomerService {
	CustomerDAO customerdao = new CustomerDaoimpl();

	public boolean saveCustomer(Customer customer) {
		return customerdao.saveCustomer(customer);
	}

	public List<Customer> findAll() {
		return customerdao.findAll();
	}
	
	public Customer findCustomerById(int id) {
		return customerdao.findCustomerById(id);
	}

	
	public boolean removeCustomerById(int id) {
		return customerdao.removeCustomerById(id);
	}

	@Override
	public List<Customer> findCustomerByorderId(int orderid) {
		return customerdao.findCustomerByorderId(orderid);
	}

	@Override
	public boolean updateCustomer(int custId, String custName, String address, String mobileNo) {
		return customerdao.updateCustomer(custId, custName, address, mobileNo);
	}

}
