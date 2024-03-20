package com.serviceimpl;

import java.util.List;

import com.entity.FoodProduct;
import com.entity.OrderDetails;
import com.entity.Orders;
import com.fooddelivery.dao.OrderDetailsDAO;
import com.fooddelivery.daoimpl.OrderdetailsDaoimpl;
import com.service.OrderdetailsService;

public class OrderDetailsServiceimpl implements OrderdetailsService {

	OrderDetailsDAO orderdetailsDAO = new OrderdetailsDaoimpl();

	public boolean saveOderdetails(OrderDetails Orerdetails) {
		return orderdetailsDAO.saveOderdetails(Orerdetails);
	}

	public List<OrderDetails> findAll() {
		return orderdetailsDAO.findAll();
	}

	public OrderDetails findeorderDetailsById(int id) {
		return orderdetailsDAO.findeorderDetailsById(id);
	}

	public boolean updateOrderDetailsById(int orderDetailsId, int quantity, Orders order, FoodProduct foodProduct) {
		return orderdetailsDAO.updateOrderDetailsById(orderDetailsId, quantity, order, foodProduct);
		
	}

	public boolean removeOrderDetailsById(int id) {
		return orderdetailsDAO.removeOrderDetailsById(id);
	}

	@Override
	public List<OrderDetails> findorderDetailsByordersId(int orderId) {
		return orderdetailsDAO.findorderDetailsByordersId(orderId);
	}

	@Override
	public List<OrderDetails> findorderDetailsByfoodProductsId(int foodProductId) {
		return orderdetailsDAO.findorderDetailsByfoodProductsId(foodProductId);
		
	}

}
