package com.fooddelivery.dao;

import java.util.List;

import com.entity.FoodProduct;
import com.entity.OrderDetails;
import com.entity.Orders;

public interface OrderDetailsDAO {
	boolean saveOderdetails(OrderDetails Orerdetails);

	List<OrderDetails> findAll();

	OrderDetails findeorderDetailsById(int id);
	
	List<OrderDetails> findorderDetailsByordersId(int orderId);
	
	List<OrderDetails> findorderDetailsByfoodProductsId(int foodProductId);
	
	boolean updateOrderDetailsById(int orderDetailsId, int quantity, Orders order, FoodProduct foodProduct);

	boolean removeOrderDetailsById(int id);

}
