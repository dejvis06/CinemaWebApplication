package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the reservation database table.
 * 
 */
@Entity
@Table(name = "Reservation")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservationID")
	private int reservationID;

	@Column(name = "reservationDate")
	private Date reservationDate;

	@Column(name = "reservationTime")
	private Time reservationTime;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;

	//bi-directional many-to-one association to Indisplay
	@ManyToOne
	@JoinColumn(name="InDisplayID")
	private Indisplay indisplay;

	//bi-directional many-to-many association to Chair
	@ManyToMany(mappedBy="reservations")
	private List<Chair> chairs;

	public Reservation() {
	}

	public int getReservationID() {
		return this.reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public Date getReservationDate() {
		return this.reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Time getReservationTime() {
		return this.reservationTime;
	}

	public void setReservationTime(Time reservationTime) {
		this.reservationTime = reservationTime;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Indisplay getIndisplay() {
		return this.indisplay;
	}

	public void setIndisplay(Indisplay indisplay) {
		this.indisplay = indisplay;
	}

	public List<Chair> getChairs() {
		return this.chairs;
	}

	public void setChairs(List<Chair> chairs) {
		this.chairs = chairs;
	}

}