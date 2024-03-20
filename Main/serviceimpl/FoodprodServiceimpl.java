package com.serviceimpl;

import java.util.List;

import com.entity.FoodCategory;
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

	
	public boolean removeFoodprodById(int id) {
		return foodProductDAO.removeFoodprodById(id);
	}

	@Override
	public boolean updateFoodProductById(int foodProductId, String productName, int price, FoodCategory foodCategory) {
		return foodProductDAO.updateFoodProductById(foodProductId, productName, price, foodCategory);
	}

	@Override
	public List<FoodProduct> getFoodProductsBycategoryId(int categoryId) {
		return foodProductDAO.getFoodProductsBycategoryId(categoryId);
	}

	
}
