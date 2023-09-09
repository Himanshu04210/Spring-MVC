package com.masai.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.masai.Entities.Employees;
import com.masai.Utils.SFUtils;


@Repository
public class EmployeeDaoImple implements EmployeeDao{

	
	@Override
	public Employees registerEmployee(Employees employee) {
	   
		EntityManager em = SFUtils.getConnection();
		
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
		SFUtils.closeConnection(em);
		
		return employee;
		
	}

	@Override
	public List<Employees> getAllEmployees() {
	    
		EntityManager em = SFUtils.getConnection();
		
		TypedQuery<Employees> query = em.createQuery("select e from Employees e", Employees.class);
		
		List<Employees> employees = query.getResultList();
		return employees;
	}

}
