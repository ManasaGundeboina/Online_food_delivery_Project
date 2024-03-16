package com.serviceimpl;

import java.util.List;

import com.entity.FoodProduct;
import com.fooddelivery.dao.FoodProductDAO;
import com.fooddelivery.daoimpl.FoodproductDaoimpl;
import com.service.FoodprodService;

public class FoodprodServiceimpl implements FoodprodService {

	FoodProductDAO foodProductDAO = new FoodproductDaoimpl();

	public boolean saveFoodproduct(FoodProduct prod) {
		return foodProductDAO.saveFoodproduct(prod);
	}

	public List<FoodProduct> findAll() {
		return foodProductDAO.findAll();

	}

	public FoodProduct findFoodProductById(int id) {
		return foodProductDAO.findFoodProductById(id);
	}

	public boolean updateFoodProductById(int id, FoodProduct FoodProduct) {
		return foodProductDAO.updateFoodProductById(id, FoodProduct);
	}

	public boolean removeFoodprodById(int id) {
		return foodProductDAO.removeFoodprodById(id);
	}

	
}
