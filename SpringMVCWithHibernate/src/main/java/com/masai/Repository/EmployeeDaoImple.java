package com.masai.Repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.masai.Entity.Employees;
import com.masai.Utils.SFUtils;


@Repository
public class EmployeeDaoImple implements EmployeeDao{

	@Override
	public Employees registerEmployee(Employees employee) {
		Session session = SFUtils.getSession();
		Transaction transaction = session.getTransaction();
		session.save(employee);
		transaction.commit();
		SFUtils.closeSession(session);
		return employee;
	}

	@Override
	public List<Employees> getAllEmployees() {
		
		Session session = SFUtils.getSession();
		
		TypedQuery<Employees> query = session.createQuery("SELECT e FROM Employees e", Employees.class);

		List<Employees> employees = query.getResultList();

		for (Employees employee : employees) {
		    System.out.println(employee);
		}
		
		SFUtils.closeSession(session);
		
		return employees;
	}

}
