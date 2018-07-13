package dao;

import java.util.List;

import javax.persistence.Query;

import hibernate.HibernateLayer;
import model.Hall;
import model.Monitor;
import model.Movie;

public class HallDAO extends HibernateLayer {

	public void saveHall(Hall hall) {
		try {
			begin();
			getEntityManager().persist(hall);
			commit();
		} catch (RuntimeException e) {
			rollBack();
		} 
	}

	public void updateHall(Hall hall) {
		try {
			begin();
			getEntityManager().merge(hall);
			commit();
		} catch (RuntimeException e) {
			rollBack();
		} 
	}

	public void deleteHall(Hall hall) {
		try {
			begin();
			getEntityManager().remove(hall);
			commit();
		} catch (RuntimeException e) {
			rollBack();
		} 
	}

	public Hall getHall(String hallNumber) {
		Query query = getEntityManager().createQuery("from Hall hall where hall.hallNumber =:hallNumber");
		query.setParameter("hallNumber", Integer.valueOf(hallNumber));

		Hall dbHall = (Hall) query.getSingleResult();
		
		return (Hall) dbHall;
	}

	public List<Hall> getHalls() {
		Query query = getEntityManager().createQuery("from Hall hall ");

		List<Hall> hallList = query.getResultList();

		return hallList;
	}

	public List<Monitor> getMonitorsInHall(Hall hall) {

		Query query = getEntityManager().createQuery("from Monitor monitor where hallid =:hallid");
		query.setParameter("hallid", hall.getHallID());

		List<Monitor> monitorList = query.getResultList();

		return monitorList;
	}

	public List<Monitor> getMonitors(String hallid) {
		Query query = getEntityManager().createQuery("from Monitor monitor where hallid =:hallid");
		query.setParameter("hallid", Integer.parseInt(hallid));

		List<Monitor> monitorList = query.getResultList();

		return monitorList;
	}

}
