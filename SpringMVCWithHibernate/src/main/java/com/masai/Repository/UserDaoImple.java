package com.masai.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.masai.Entities.Users;
import com.masai.Entities.VaccinatedUsers;
import com.masai.Utils.SFUtils;


@Repository
public class UserDaoImple implements UserDao{

	
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
			return null; 
		} else {
		    return userList.get(0);
		}

	}

	@Override
	public Users deleteUserById(int userId) {
		
		EntityManager em = Persistence.createEntityManagerFactory("EmployeesUnit").createEntityManager();
		Users user = null;
		try {
			em = SFUtils.getConnection();
			user = em.find(Users.class, userId);
			
			if(user != null) {
				em.getTransaction().begin();
				System.out.println(user);
				em.remove(user);
				em.flush();
				em.getTransaction().commit();

			}
		}
		finally {
			if (em != null && em.isOpen()) {
		        em.close();
		    }
	
		}
		return user;
		
		
		
	}

	@Override
	public VaccinatedUsers addVaccinatedUser(VaccinatedUsers vaccinatedUsers) {
		EntityManager em = SFUtils.getConnection();
		
		em.getTransaction().begin();
		em.persist(vaccinatedUsers);
		em.getTransaction().commit();
		SFUtils.closeConnection(em);
		return vaccinatedUsers;
		
	}

	@Override
	public List<VaccinatedUsers> getAllVaccinatedUsers() {
		EntityManager em = SFUtils.getConnection();
		
		System.out.println("vaccinated Users");
		
		TypedQuery<VaccinatedUsers> query = em.createQuery("SELECT v FROM VaccinatedUsers v", VaccinatedUsers.class);
		List<VaccinatedUsers> vaccinatedUsers = query.getResultList();
		SFUtils.closeConnection(em);
		if(vaccinatedUsers.isEmpty()) return null;
		
		return vaccinatedUsers;
		
	}
	
	
	

}
