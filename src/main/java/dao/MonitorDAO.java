package dao;

import java.util.List;

import javax.persistence.Query;

import hibernate.HibernateLayer;
import model.Hall;
import model.Monitor;

public class MonitorDAO extends HibernateLayer {

	public void saveMonitor(Monitor monitor) {
		try {
			begin();
			getEntityManager().persist(monitor);
			commit();
		} catch (RuntimeException e) {
			rollBack();
		} 
	}

	public void updateMonitor(Monitor monitor) {
		try {
			begin();
			getEntityManager().merge(monitor);
			commit();
		} catch (RuntimeException e) {
			rollBack();
		} 
	}

	public void deleteMonitor(Monitor monitor) {
		try {
			begin();
			getEntityManager().remove(monitor);
			commit();
		} catch (RuntimeException e) {
			rollBack();
		} 
	}
	
	public Monitor getMonitor(Monitor monitor) {
		Query query = getEntityManager().createQuery("from Monitor monitor where monitor.monitorid =:monitorid");
		query.setParameter("monitorid", monitor.getMonitorID());

		Monitor dbMonitor = (Monitor) query.getSingleResult();
		if (dbMonitor == null) {
			return null;
		} else {
			return (Monitor) dbMonitor;
		}
	}
	
	public Monitor getMonitorByNumber(String monitorNumber) {
		Query query = getEntityManager().createQuery("from Monitor monitor where monitor.monitorNumber =:monitorNumber");
		query.setParameter("monitorNumber", Integer.valueOf(monitorNumber));

		Monitor dbMonitor = (Monitor) query.getSingleResult();
		if (dbMonitor == null) {
			return null;
		} else {
			return (Monitor) dbMonitor;
		}
	}
	
}
