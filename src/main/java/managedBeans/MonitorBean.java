package managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import managers.MonitorManager;
import model.Monitor;

@ManagedBean
@ViewScoped
public class MonitorBean {

	private Monitor monitor;
	private MonitorManager monitorManager;

	public MonitorBean() {
		monitor = new Monitor();
		monitorManager = new MonitorManager();
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public MonitorManager getMonitorManager() {
		return monitorManager;
	}

	public void setMonitorManager(MonitorManager monitorManager) {
		this.monitorManager = monitorManager;
	}

	
}
