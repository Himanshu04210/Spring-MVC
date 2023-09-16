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

	@Override
	public Users findUserByEmail(String email) {
		EntityManager em = SFUtils.getConnection();
		
		TypedQuery<Users> query = em.createQuery("SELECT u FROM Users u WHERE u.email = :email", Users.class);
	    query.setParameter("email", email);
		
		
		List<Users> userList = query.getResultList();
		SFUtils.closeConnection(em);
		
		if (userList.isEmpty()) {
		    // Handle the case when no user with the specified email is found
		    return null; // Or throw an exception, return a default user, etc.
		} else {
		    // Handle the case when a user with the specified email is found
		    return userList.get(0); // Return the first user found (assuming there should be only one)
		}






	}
	
	
	

}
