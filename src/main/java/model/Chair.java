package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the chair database table.
 * 
 */
@Entity
@Table(name = "Chair")
public class Chair implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chairID") 
	private int chairID;

	@Column(name = "chairColumn") 
	private int chairColumn;

	@Column(name = "chairRow")
	private int chairRow;

	//bi-directional many-to-one association to Monitor
	@ManyToOne
	@JoinColumn(name="MonitorID")
	private Monitor monitor;

	//bi-directional many-to-many association to Reservation
	@ManyToMany
	@JoinTable(
		name="reservedchair"
		, joinColumns={
			@JoinColumn(name="ChairID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ReservationID")
			}
		)
	private List<Reservation> reservations;

	public Chair() {
	}

	public int getChairID() {
		return this.chairID;
	}

	public void setChairID(int chairID) {
		this.chairID = chairID;
	}

	public int getChairColumn() {
		return this.chairColumn;
	}

	public void setChairColumn(int chairColumn) {
		this.chairColumn = chairColumn;
	}

	public int getChairRow() {
		return this.chairRow;
	}

	public void setChairRow(int chairRow) {
		this.chairRow = chairRow;
	}

	public Monitor getMonitor() {
		return this.monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

}