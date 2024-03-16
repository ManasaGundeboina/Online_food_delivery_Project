package com.fooddelivery.dao;

import java.util.List;

import com.entity.FoodProduct;

public interface FoodProductDAO {
	boolean saveFoodproduct(FoodProduct prod);

	List<FoodProduct> findAll();

	FoodProduct findFoodProductById(int id);
	

	boolean updateFoodProductById(int id, FoodProduct FoodProduct);

	boolean removeFoodprodById(int id);
}
