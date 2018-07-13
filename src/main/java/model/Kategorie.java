package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kategorie database table.
 * 
 */
@Entity
@Table(name = "Kategorie")
public class Kategorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kategorieID") 
	private int kategorieID;

	@Column(name = "kategorieName") 
	private String kategorieName;

	//bi-directional many-to-one association to Movie
	@OneToMany(mappedBy="kategorie")
	private List<Movie> movies;

	public Kategorie() {
	}

	public int getKategorieID() {
		return this.kategorieID;
	}

	public void setKategorieID(int kategorieID) {
		this.kategorieID = kategorieID;
	}

	public String getKategorieName() {
		return this.kategorieName;
	}

	public void setKategorieName(String kategorieName) {
		this.kategorieName = kategorieName;
	}

	public List<Movie> getMovies() {
		return this.movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public Movie addMovy(Movie movy) {
		getMovies().add(movy);
		movy.setKategorie(this);

		return movy;
	}

	public Movie removeMovy(Movie movy) {
		getMovies().remove(movy);
		movy.setKategorie(null);

		return movy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + kategorieID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kategorie other = (Kategorie) obj;
		if (kategorieID != other.kategorieID)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return kategorieName;
	}

}