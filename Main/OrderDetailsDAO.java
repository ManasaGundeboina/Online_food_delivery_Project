package com.fooddelivery.dao;

import java.util.List;

import com.entity.OrderDetails;

public interface OrderDetailsDAO {
	boolean saveOderdetails(OrderDetails Orerdetails);

	List<OrderDetails> findAll();

	OrderDetails findeorderDetailsById(int id);
	
	public List<OrderDetails> findeorderDetailsByOrderId(int orderId);
	
	public List<OrderDetails> findeorderDetailsByProductName(String productName);

	boolean updateOrderDetailsById(int id, OrderDetails orderdetails);

	boolean removeOrderDetailsById(int id);

}
