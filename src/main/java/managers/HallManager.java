package managers;

import java.util.List;

import javax.faces.event.ValueChangeEvent;
import javax.persistence.Query;

import dao.HallDAO;
import model.Hall;
import model.Monitor;

public class HallManager {

	private HallDAO hallDAO = new HallDAO();

	public void saveHall(Hall hall) {
		hallDAO.saveHall(hall);
	}

	public void updateHall(Hall hall) {
		hallDAO.updateHall(hall);
	}

	public void deleteHall(Hall hall) {
		hallDAO.deleteHall(hall);
	}

	public Hall getHall(String hallNumber) {
		return hallDAO.getHall(hallNumber);
	}

	public List<Hall> getHalls() {
		return hallDAO.getHalls();
	}

	public List<Monitor> getMonitorsInHall(Hall hall) {
		return hallDAO.getMonitorsInHall(hall);
	}
	
	public List<Monitor> getMonitors(String hallid) {
		return hallDAO.getMonitors(hallid);
	}
}
