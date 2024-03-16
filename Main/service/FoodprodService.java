package com.service;

import java.util.List;

import com.entity.FoodProduct;
import com.entity.OrderDetails;

public interface FoodprodService {
	boolean saveFoodproduct(FoodProduct prod);

	List<FoodProduct> findAll();

	FoodProduct findFoodProductById(int id);

	boolean updateFoodProductById(int id, FoodProduct FoodProduct);

	boolean removeFoodprodById(int id);
}
