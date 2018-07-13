package managers;

import java.util.List;

import javax.persistence.Query;

import dao.MonitorDAO;
import model.Hall;
import model.Monitor;

public class MonitorManager {

	private MonitorDAO monitorDAO = new MonitorDAO();
	
	public void saveMonitor(Monitor monitor) {
		monitorDAO.saveMonitor(monitor);
	}

	public void updateMonitor(Monitor monitor) {
		monitorDAO.updateMonitor(monitor);
	}

	public void deleteMonitor(Monitor monitor) {
		monitorDAO.deleteMonitor(monitor);
	}
	
	public Monitor getMonitor(Monitor monitor) {
		return monitorDAO.getMonitor(monitor);
	}
	
	public Monitor getMonitorByNumber(String monitorNumber) {
		return monitorDAO.getMonitorByNumber(monitorNumber);
	}
}
