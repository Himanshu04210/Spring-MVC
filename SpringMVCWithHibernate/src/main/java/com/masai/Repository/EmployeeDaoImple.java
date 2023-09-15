package com.masai.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.masai.Entities.Users;
import com.masai.Utils.SFUtils;


@Repository
public class EmployeeDaoImple implements UserDao{

	
	@Override
	public Users registerUser(Users user) {
	   
		EntityManager em = SFUtils.getConnection();
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		SFUtils.closeConnection(em);
		
		return user;
		
	}

	@Override
	public List<Users> getAllUsers() {
	    
		EntityManager em = SFUtils.getConnection();
		
		TypedQuery<Users> query = em.createQuery("select e from Users e", Users.class);
		
		List<Users> users = query.getResultList();
		return users;
	}

}
