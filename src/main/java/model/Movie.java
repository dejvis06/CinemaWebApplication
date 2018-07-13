package model;

import java.io.Serializable;
import javax.persistence.*;

import managers.CategorieManager;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the movie database table.
 * 
 */
@Entity
@Table(name = "Movie")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movieID")
	private int movieID;

	@Column(name = "title")
	private String title;

	// bi-directional many-to-one association to Kategorie
	@ManyToOne
	@JoinColumn(name = "KategorieID")
	private Kategorie kategorie;

	@Column(name = "duration")
	private Time duration;

	@Column(name = "reviews")
	private double reviews;

	@Column(name = "startDate")
	private Date startDate;

	@Column(name = "endDate")
	private Date endDate;

	// bi-directional many-to-one association to Indisplay
	@OneToMany(mappedBy = "movie")
	private List<Indisplay> indisplays;

	public Movie() {
	}

	public int getMovieID() {
		return this.movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public Time getDuration() {
		return this.duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getReviews() {
		return this.reviews;
	}

	public void setReviews(double reviews) {
		this.reviews = reviews;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Indisplay> getIndisplays() {
		return this.indisplays;
	}

	public void setIndisplays(List<Indisplay> indisplays) {
		this.indisplays = indisplays;
	}

	public Indisplay addIndisplay(Indisplay indisplay) {
		getIndisplays().add(indisplay);
		indisplay.setMovie(this);

		return indisplay;
	}

	public Indisplay removeIndisplay(Indisplay indisplay) {
		getIndisplays().remove(indisplay);
		indisplay.setMovie(null);

		return indisplay;
	}

	public Kategorie getKategorie() {
		return this.kategorie;
	}

	public void setKategorie(Kategorie kategorie) {
		this.kategorie = kategorie;
	}
	
	@Override
	public String toString() {
		return title;
	}

}