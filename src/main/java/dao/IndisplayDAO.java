package dao;

import java.util.List;

import javax.persistence.Query;

import hibernate.HibernateLayer;
import model.Indisplay;
import model.Monitor;
import model.Movie;

public class IndisplayDAO extends HibernateLayer {

	public void saveIndisplay(Indisplay indisplay) {
		try {
			begin();
			getEntityManager().persist(indisplay);
			commit();
		} catch (RuntimeException e) {
			rollBack();
		} 
	}

	public void updateIndisplay(Indisplay indisplay) {
		try {
			begin();
			getEntityManager().merge(indisplay);
			commit();
		} catch (RuntimeException e) {
			rollBack();
		}
	}

	public void deleteIndisplay(Indisplay indisplay) {
		try {
			begin();
			getEntityManager().remove(indisplay);
			commit();
		} catch (RuntimeException e) {
			rollBack();
		} 
	}

	public List<Indisplay> getDisplays() {
		Query query = getEntityManager().createQuery("from Indisplay indisplay"); 
	
		List<Indisplay> IndisplayList = query.getResultList();

		return IndisplayList;
	}

	public List<Indisplay> getDisplaysInMonitor(Monitor monitor) {
		Query query = getEntityManager().createQuery("from Indisplay indisplay where monitorid =:monitorid");
		query.setParameter("monitorid", monitor.getMonitorID());

		List<Indisplay> IndisplayList = query.getResultList();

		return IndisplayList;
	}

}
