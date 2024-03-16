package com.fooddelivery.dao;

import java.util.List;

import com.entity.FoodCategory;
import com.entity.FoodProduct;

public interface FoodCategoryDAO {
	boolean saveFoodCategory(FoodCategory category);

	List<FoodCategory> findAll();

	FoodCategory findFoodCategoryById(int id);
	
	List<FoodProduct> getfoodProductBycategoryname(String categoryname);

	boolean removeFoodCategoryById(int id);

	boolean updateFoodCategory(int id, String FoodCategory);
}
