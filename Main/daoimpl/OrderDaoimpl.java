package com.fooddelivery.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.sql.ordering.antlr.OrderByAliasResolver;

import com.entity.OrderDetails;
import com.entity.Orders;
import com.fooddelivery.dao.OrderDAO;
import com.hibernate.Hibernateutil;

public class OrderDaoimpl implements OrderDAO {

	public boolean saveOrder(Orders order) {
		try (Session session = Hibernateutil.getSession()) {
			session.beginTransaction();
			session.save(order);
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

	public List<Orders> findAll() {
		try (Session session = Hibernateutil.getSession()) {
			List<Orders> order = session.createQuery("from Order", Orders.class).getResultList();
			return order;
		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return null;
	}

	public Orders findOrderByID(int id) {
		try (Session session = Hibernateutil.getSession()) {
			Orders order = session.get(Orders.class, id);
			return order;
		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return null;
	}

	// findorderByempID(empid)
	public List<Orders> findorderByempID(int empId) {
		try (Session session = Hibernateutil.getSession()) {
			session.beginTransaction(); String sqlQurey ="SELECT * FROM Orders WHERE empId = : empId ";
			List<Orders> order = session.createNativeQuery(sqlQurey, Orders.class).setParameter("EmployeeId", empId).getResultList();
			return order;
		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return null;
	}
	
	//findorderBycustID
	public List<Orders> findorderBycustID(int custId) {
		try (Session session = Hibernateutil.getSession()) {
			session.beginTransaction(); String sqlQurey ="SELECT * FROM Orders WHERE custId = : custId ";
			List<Orders> order = session.createNativeQuery(sqlQurey, Orders.class).setParameter("CustomerId", custId).getResultList();
			return order;
		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return null;
	}
	

	public boolean updateOrderById(int id, Orders order) {
		try (Session session = Hibernateutil.getSession()) {
			Orders existorder = session.load(Orders.class, id);
			// update existing details with the new one
			existorder.setorderId(order.getorderId());
			existorder.setamount(order.getamount());
			existorder.setorderDate(order.getorderDate());
			existorder.setstatus(order.getstatus());

			session.beginTransaction();
			session.saveOrUpdate(existorder);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return false;
	}

	public boolean removeOrderById(int id) {
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
