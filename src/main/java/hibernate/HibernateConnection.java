package hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateConnection {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CinemaWebApp");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	public void begin() {
		entityManager.getTransaction().begin();
	}

	public void commit() {
		entityManager.getTransaction().commit();
	}

	public void rollBack() {
		entityManager.getTransaction().rollback();
	}

	public void close() {
		entityManager.close();
	}
	
	public void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
