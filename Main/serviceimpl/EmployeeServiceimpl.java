package com.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import com.entity.Employee;
import com.fooddelivery.dao.CustomerDAO;
import com.fooddelivery.dao.EmployeeDAO;
import com.fooddelivery.daoimpl.EmployeeDaoImpl;
import com.service.EmployeeService;

public class EmployeeServiceimpl implements EmployeeService {
	EmployeeDAO employeedao = new EmployeeDaoImpl();

	public boolean saveEmpolyee(Employee employee) {
		return employeedao.saveEmpolyee(employee);
	}

	public List<Employee> findAll() {
		return employeedao.findAll();
	}

	public Employee FindEmpByID(int id) {
		return employeedao.FindEmpByID(id);
	}

	public boolean removeEmployeeById(int id) {
		return employeedao.removeEmployeeById(id);
	}

	@Override
	public List<Employee> findemployeeByorderID(int orderId) {
		return employeedao.findemployeeByorderID(orderId);
	}

	@Override
	public boolean updateEmployee(int empId, String name, LocalDate dateOfJoined, long salary, String mobile) {
		return employeedao.updateEmployee(empId, name, dateOfJoined, salary, mobile);
	}

}
