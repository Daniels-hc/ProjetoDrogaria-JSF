package br.com.drogaria.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	private static final EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("postgre-projetoDrogaria");
	
	public static EntityManager getEntityManager() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;	
		}
}
