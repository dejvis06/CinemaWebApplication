package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hall database table.
 * 
 */
@Entity
@NamedQuery(name="Hall.findAll", query="SELECT h FROM Hall h")
public class Hall implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hallid") 
	private int hallID;

	@Column(name = "hallnumber") 
	private int hallNumber;

	//bi-directional many-to-one association to Monitor
	@OneToMany(mappedBy="hall")
	private List<Monitor> monitors;

	public Hall() {
		
	}

	public int getHallID() {
		return this.hallID;
	}

	public void setHallID(int hallID) {
		this.hallID = hallID;
	}

	public int getHallNumber() {
		return this.hallNumber;
	}

	public void setHallNumber(int hallNumber) {
		this.hallNumber = hallNumber;
	}

	public List<Monitor> getMonitors() {
		return this.monitors;
	}

	public void setMonitors(List<Monitor> monitors) {
		this.monitors = monitors;
	}

	public Monitor addMonitor(Monitor monitor) {
		getMonitors().add(monitor);
		monitor.setHall(this);

		return monitor;
	}

	public Monitor removeMonitor(Monitor monitor) {
		getMonitors().remove(monitor);
		monitor.setHall(null);

		return monitor;
	}
	
	@Override
	public String toString() {
		return Integer.toString(hallNumber);
	}

}