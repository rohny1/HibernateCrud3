package com.HibernateCRUD.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HibernateCRUD.Util.HibernateUtil;
import com.HibernateCRUD.model.Employee;

public class EmployeeDAO {

	public void saveEmployee(Employee employee) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	public void updateEmployee(Employee employee) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	public List<Employee> getAllEmployees() {
		Transaction transaction = null;
		List<Employee> employees = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			employees = session.createQuery("from Employee").list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return employees;
	}

	public Employee getEmployeeById(int id) {
		Transaction transaction = null;
		Employee employee = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			employee = session.get(Employee.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return employee;
	}

	public Employee deEmployee(long id) {
		Transaction transaction = null;
		Employee employee = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			employee = session.get(Employee.class, id);
			session.delete(employee);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return employee;
	}
}
