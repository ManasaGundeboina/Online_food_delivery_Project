package com.fooddelivery.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.entity.Orders;
import com.entity.FoodProduct;
import com.entity.OrderDetails;
import com.fooddelivery.dao.OrderDetailsDAO;
import com.hibernate.Hibernateutil;

public class OrderdetailsDaoimpl implements OrderDetailsDAO {

	public boolean saveOderdetails(OrderDetails Orerdetails) {
		try (Session session = Hibernateutil.getSession()) {
			session.beginTransaction();
			session.save(Orerdetails);
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

	public List<OrderDetails> findAll() {
		try (Session session = Hibernateutil.getSession()) {
			List<OrderDetails> orerdetails = session.createQuery("from orerdetails", OrderDetails.class)
					.getResultList();
			return orerdetails;

		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return null;
	}

	public List<OrderDetails> findeorderDetailsByOrderId(int orderId) {
		try (Session session = Hibernateutil.getSession()) {
			session.beginTransaction();
			String sqlQurey = "SELECT * FROM OrderDetails WHERE orderId = : orderId ";
			List<OrderDetails> orderdetails = session.createNativeQuery(sqlQurey, OrderDetails.class)
					.setParameter("OrderId", orderId).getResultList();
			session.getTransaction().commit();

			return orderdetails;
		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return null;
	}
	
	//productName
	public List<OrderDetails> findeorderDetailsByProductName(String productName) {
		try (Session session = Hibernateutil.getSession()) {
			session.beginTransaction();
			String sqlQurey = "SELECT * FROM OrderDetails WHERE productName = : productName ";
			List<OrderDetails> orderdetails = session.createNativeQuery(sqlQurey, OrderDetails.class)
					.setParameter("Productname", productName).getResultList();
			session.getTransaction().commit();

			return orderdetails;
		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return null;
	}
	

	public OrderDetails findeorderDetailsById(int id) {
		try (Session session = Hibernateutil.getSession()) {
			OrderDetails orerdetails = session.get(OrderDetails.class, id);
			return orerdetails;

		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return null;
	}

	public boolean updateOrderDetailsById(int id, OrderDetails orderdetails) {
		try (Session session = Hibernateutil.getSession()) {
			OrderDetails existOrderDetails = session.load(OrderDetails.class, id);
			// update existing details with the new one
			existOrderDetails.setorderDetailsId(orderdetails.getorderDetailsId());
			existOrderDetails.setquantity(orderdetails.getquantity());

			session.beginTransaction();
			session.saveOrUpdate(existOrderDetails);
			session.getTransaction().commit();
			return true;

		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return false;

	}

	public boolean removeOrderDetailsById(int id) {
		try (Session session = Hibernateutil.getSession()) {
			Orders order = session.get(Orders.class, id);
			session.beginTransaction();
			if (order != null) {
				session.delete(order);
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

}
