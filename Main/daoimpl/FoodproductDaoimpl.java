package com.fooddelivery.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.entity.FoodProduct;
import com.entity.Orders;
import com.fooddelivery.dao.FoodProductDAO;
import com.hibernate.Hibernateutil;

public class FoodproductDaoimpl implements FoodProductDAO {

	public boolean saveFoodproduct(FoodProduct prod) {
		try (Session session = Hibernateutil.getSession()) {
			session.beginTransaction();
			session.save(prod);
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

	public List<FoodProduct> findAll() {
		try (Session session = Hibernateutil.getSession()) {
			List<FoodProduct> Foodproduct = session.createQuery("from Foodproduct", FoodProduct.class).getResultList();
			return Foodproduct;
		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return null;
	}

	public FoodProduct findFoodProductById(int id) {
		try (Session session = Hibernateutil.getSession()) {
			FoodProduct foodproduct = session.get(FoodProduct.class, id);
			return foodproduct;
		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return null;
	}

	

	public boolean updateFoodProductById(int id, FoodProduct foodProduct) {
		try (Session session = Hibernateutil.getSession()) {
			FoodProduct existFoodproduct = session.load(FoodProduct.class, id);
			// update existing details with the new one
			existFoodproduct.setfoodProductId(foodProduct.getfoodProductId());
			existFoodproduct.setproductName(foodProduct.getproductName());
			existFoodproduct.setprice(foodProduct.getprice());

			session.beginTransaction();
			session.saveOrUpdate(existFoodproduct);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return false;
	}

	public boolean removeFoodprodById(int id) {
		try (Session session = Hibernateutil.getSession()) {
			FoodProduct cust = session.get(FoodProduct.class, id);
			session.beginTransaction();
			if (cust != null) {
				session.delete(cust);
			} else {
				System.out.println("existFoodproduct details not found!");
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

	public List<FoodProduct> findfoodProductBycategoryname(String categoryname) {
		try (Session session = Hibernateutil.getSession()) {
			session.beginTransaction();
			String sqlQurey = "FoodProduct * FROM Orders WHERE categoryname = : categoryname ";
			List<FoodProduct> Foodproduct = session.createNativeQuery("from Foodproduct", FoodProduct.class)
					.setParameter("Categoryname", categoryname).getResultList();
			return Foodproduct;
		}catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return null;
	}
}
