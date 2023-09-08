package com.masai.Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

@Component
public class SFUtils {
    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("EmployeesUnit");
    }
    
    public static EntityManager getConnection() {
    	return emf.createEntityManager();
    }
    
    public static void closeConnection(EntityManager em) {
    	em.close();
    }

}
