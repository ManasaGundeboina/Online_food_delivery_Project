package com.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee { // delivery person {
	@Id
	private int empId;

	private String name;

	private LocalDate dateOfJoined;

	private long salary;

	private String mobile;

	public Employee() {
	}

	public Employee(int empId, String name, LocalDate dateOfJoined, long salary, String mobile) {
		super();
		this.empId = empId;
		this.name = name;
		this.dateOfJoined = dateOfJoined;
		this.salary = salary;
		this.mobile = mobile;
	}

	public int getempId() {
		return empId;
	}

	public void setempId(int empId) {
		this.empId = empId;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public LocalDate getdateOfJoined() {
		return dateOfJoined;
	}

	public void setdateOfJoined(LocalDate dateOfJoined) {
		this.dateOfJoined = dateOfJoined;
	}

	public long getsalary() {
		return salary;
	}

	public void setsalary(long salary) {
		this.salary = salary;
	}

	public String getmobile() {
		return mobile;
	}

	public void setmobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", dateOfJoined=" + dateOfJoined + ", salary=" + salary
				+ ", mobile=" + mobile + "]";
	}

}
