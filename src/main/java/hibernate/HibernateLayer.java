package hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class HibernateLayer {

	private static HibernateConnection hibernateConnection = new HibernateConnection();

	public void begin() {
		hibernateConnection.begin();
	}
	
	public void commit() {
		hibernateConnection.commit();
	}

	public void rollBack() {
		hibernateConnection.rollBack();
	}

	public void close() {
		hibernateConnection.close();
	}
	
	public void closeEntityManagerFactory() {
		hibernateConnection.closeEntityManagerFactory();
	}

	public EntityManager getEntityManager() {
		return hibernateConnection.getEntityManager();
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return hibernateConnection.getEntityManagerFactory();
	}

}
