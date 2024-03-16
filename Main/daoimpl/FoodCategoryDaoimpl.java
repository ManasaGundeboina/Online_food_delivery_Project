package com.fooddelivery.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.entity.FoodCategory;
import com.entity.FoodProduct;
import com.fooddelivery.dao.FoodCategoryDAO;
import com.hibernate.Hibernateutil;

public class FoodCategoryDaoimpl implements FoodCategoryDAO {

	public boolean saveFoodCategory(FoodCategory category) {
		try (Session session = Hibernateutil.getSession()) {
			session.beginTransaction();
			session.save(category);
			session.getTransaction().commit();
			session.clear();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public List<FoodCategory> findAll() {
		try (Session session = Hibernateutil.getSession()) {
			List<FoodCategory> foodCategory = session.createQuery("from FoodCategory", FoodCategory.class)
					.getResultList();
			return foodCategory;
		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return null;
	}

	public FoodCategory findFoodCategoryById(int id) {
		try (Session session = Hibernateutil.getSession()) {
			FoodCategory foodCategory = session.get(FoodCategory.class, id);
			return foodCategory;
		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return null;
	}

	public boolean updateFoodCategory(int id, String foodCategory) {
		try (Session session = Hibernateutil.getSession()) {
			FoodCategory existFoodCategory = session.load(FoodCategory.class, id);
			if (existFoodCategory != null) {
			// update existing details with the new one
			existFoodCategory.setfoodCategoryId(existFoodCategory.getfoodCategoryId());
			existFoodCategory.setcategoryName(existFoodCategory.getcategoryName());

			session.beginTransaction();
			session.saveOrUpdate(existFoodCategory);
			session.getTransaction().commit();
			System.out.println("foodCategory with ID " + id + " updated successfully.");
			return true;
			}else {
			System.out.println("foodCategory with ID " + id + " does not exist.");
		}
		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return false;
	}

	public boolean removeFoodCategoryById(int id) {
		try (Session session = Hibernateutil.getSession()) {
			FoodCategory cust = session.get(FoodCategory.class, id);
			session.beginTransaction();
			if (cust != null) {
				session.delete(cust);
			} else {
				System.out.println("FoodCategory details not found!");
			}
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}

		return false;
	}

	@Override
	public List<FoodProduct> getfoodProductBycategoryname(String categoryname) {
		try (Session session = Hibernateutil.getSession()) {
			String sqlQuery = "SELECT * FROM onlinefooddelivery.foodcategory c, onlinefooddelivery.foodproduct p where c.categoryName= : categoryname";

			List<FoodProduct> foodproducts = session.createNativeQuery(sqlQuery, FoodProduct.class)
					.setParameter("categoryName", categoryname).getResultList();

			return foodproducts;
		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return null;
	}
}