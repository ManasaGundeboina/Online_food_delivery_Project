package com.serviceimpl;

import java.util.List;

import com.entity.FoodCategory;
import com.entity.FoodProduct;
import com.fooddelivery.dao.FoodCategoryDAO;
import com.fooddelivery.daoimpl.FoodCategoryDaoimpl;
import com.service.FoodcategoryService;

public class FoodcategoryServiceimpl implements FoodcategoryService {
	// FoodCategoryDAO foodcategoryDAO = new FoodCategoryDaoImpl();
	FoodCategoryDAO foodcategoryDAO = new FoodCategoryDaoimpl();

	public boolean saveFoodCategory(FoodCategory category) {
		return foodcategoryDAO.saveFoodCategory(category);
	}

	public List<FoodCategory> findAll() {
		return foodcategoryDAO.findAll();
	}

	public FoodCategory findFoodCategoryById(int id) {
		return foodcategoryDAO.findFoodCategoryById(id);
	}

	
	public boolean removeFoodCategoryById(int id) {
		return foodcategoryDAO.removeFoodCategoryById(id);
	}


	@Override
	public boolean updateFoodCategory(int id, String FoodCategory) {
		return foodcategoryDAO.updateFoodCategory(id, FoodCategory);
	}
}
