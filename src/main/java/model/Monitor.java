package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the monitor database table.
 * 
 */
@Entity
@Table(name = "Monitor")
public class Monitor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "monitorid")
	private int monitorID;

	@Column(name = "monitornumber")
	private int monitorNumber;

	// bi-directional many-to-one association to Hall
	@ManyToOne
	@JoinColumn(name = "hallid")
	private Hall hall;

	public Monitor() {
	}

	public int getMonitorID() {
		return this.monitorID;
	}

	public void setMonitorID(int monitorID) {
		this.monitorID = monitorID;
	}

	public int getMonitorNumber() {
		return this.monitorNumber;
	}

	public void setMonitorNumber(int monitorNumber) {
		this.monitorNumber = monitorNumber;
	}

	public Hall getHall() {
		return this.hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	@Override
	public String toString() {
		return Integer.toString(monitorNumber);
	}

}