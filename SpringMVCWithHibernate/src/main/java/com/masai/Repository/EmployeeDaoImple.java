package com.masai.Repository;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.masai.Entities.Employees;
import com.masai.Utils.SFUtils;


@Repository
public class EmployeeDaoImple implements EmployeeDao{

	@Override
	public Employees registerEmployee(Employees employee) {
	    /*
		Session session = null;
	    Transaction transaction = null;

	    try {
	        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	        session = sessionFactory.openSession();
	        transaction = session.beginTransaction(); // Start a new transaction

	        session.save(employee);

	        transaction.commit(); // Commit the transaction after successful operation
	        System.out.println(employee.toString());
	        return employee;
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback(); // Rollback the transaction in case of an exception
	        }
	        e.printStackTrace(); // Handle the exception appropriately (e.g., log it)
	        throw new RuntimeException("Failed to register employee: " + e.getMessage(), e);
	    } finally {
	        if (session != null) {
	            session.close(); // Close the session in the finally block
	        }
	    }
	    
	    */
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeesUnit");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return employee;
		
	}

	@Override
	public List<Employees> getAllEmployees() {
	    try (Session session = SFUtils.getSession()) {
	        TypedQuery<Employees> query = session.createQuery("SELECT e FROM Employees e", Employees.class);
	        List<Employees> employees = query.getResultList();
	        for (Employees employee : employees) {
	            System.out.println(employee);
	        }
	        return employees;
	    } catch (Exception e) {
	        // Handle exceptions appropriately (e.g., log or rethrow as custom exception)
	        e.printStackTrace();
	        return Collections.emptyList(); // Return an empty list or throw a custom exception
	    }
	}

}
