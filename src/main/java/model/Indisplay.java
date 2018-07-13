package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the indisplay database table.
 * 
 */
@Entity
@Table(name = "InDisplay")
public class Indisplay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inDisplayID") 
	private int inDisplayID;
	
	@Column(name = "startTime")
	private Time startTime;

	@Column(name = "endTime")
	private Time endTime;

	//bi-directional many-to-one association to Movie
	@ManyToOne
	@JoinColumn(name="MovieID")
	private Movie movie;

	//bi-directional many-to-one association to Monitor
	@ManyToOne
	@JoinColumn(name="MonitorID")
	private Monitor monitor;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="indisplay")
	private List<Reservation> reservations;

	public Indisplay() {
	}

	public int getInDisplayID() {
		return this.inDisplayID;
	}

	public void setInDisplayID(int inDisplayID) {
		this.inDisplayID = inDisplayID;
	}

	public Time getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Time getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
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

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setIndisplay(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setIndisplay(null);

		return reservation;
	}

}