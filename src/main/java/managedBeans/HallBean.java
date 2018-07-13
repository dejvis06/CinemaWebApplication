package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import managers.HallManager;
import model.Hall;
import model.Monitor;

@ManagedBean
@ViewScoped
public class HallBean {

	private Hall hall;
	private List<Monitor> monitors;

	private HallManager hallManager;

	public HallBean() {
		hall = new Hall();
		monitors = new ArrayList<Monitor>();
		hallManager = new HallManager();
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public List<Monitor> getMonitors() {
		return monitors;
	}

	public void setMonitors(List<Monitor> monitors) {
		this.monitors = monitors;
	}

	public HallManager getHallManager() {
		return hallManager;
	}

	public void setHallManager(HallManager hallManager) {
		this.hallManager = hallManager;
	}
	
	public void valueChanged(AjaxBehaviorEvent event) {
		String hallID = String.valueOf(hall.getHallID());
		monitors = hallManager.getMonitors(hallID);
		System.out.println(hallID);
	}
	
}
