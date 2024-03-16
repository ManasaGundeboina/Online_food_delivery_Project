package com.fooddelivery.dao;

import java.time.LocalDate;
import java.util.List;

import com.entity.Employee;

public interface EmployeeDAO {
	boolean saveEmpolyee(Employee employee);

	List<Employee> findAll();

	Employee FindEmpByID(int id);
	
	List<Employee> findemployeeByorderID(int orderId);

	 boolean updateEmployee(int empId, String name, LocalDate dateOfJoined, long salary, String mobile);

	boolean removeEmployeeById(int id);
}
