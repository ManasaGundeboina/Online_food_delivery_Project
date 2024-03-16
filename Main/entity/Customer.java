package com.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	private int custId;

	private String custName;

	private String address;

	private String mobileNo;

	public Customer() {
	}

	public Customer(int custId, String custName, String address, String mobileNo) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.address = address;
		this.mobileNo = mobileNo;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getcustName() {
		return custName;
	}

	public void setcustName(String custName) {
		this.custName = custName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", address=" + address + ", mobileNo="
				+ mobileNo + "]";
	}

}
