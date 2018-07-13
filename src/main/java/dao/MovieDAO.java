package dao;

import java.util.List;

import javax.persistence.Query;

import hibernate.HibernateLayer;
import model.Kategorie;
import model.Movie;
import model.User;

public class MovieDAO extends HibernateLayer {

	public void saveMovie(Movie movie) {
		try {
			begin();
			getEntityManager().persist(movie);
			commit();
		} catch (RuntimeException e) {
			rollBack();
		} 
	}

	public void updateMovie(Movie movie) {
		try {
			begin();
			getEntityManager().merge(movie);
			commit();
		} catch (RuntimeException e) {
			rollBack();
		} 
	}

	public void deleteMovie(Movie movie) {
		try {
			begin();
			getEntityManager().remove(movie);
			commit();
		} catch (RuntimeException e) {
			rollBack();
		} 
	}

	public List<Movie> getMovies() {
		Query query = getEntityManager().createQuery("from Movie movie");

		List<Movie> movieList = query.getResultList();

		return movieList;
	}

	public Movie getMovie(Movie movie) {
		Query query = getEntityManager().createQuery("from Movie movie where movie.movieid =:movieid");
		query.setParameter("movieid", movie.getMovieID());

		Movie dbMovie = (Movie) query.getSingleResult();
		if (dbMovie == null) {
			return null;
		} else {
			return (Movie) dbMovie;
		}
	}

	public Movie getMovieByTitle(String title) {
		Query query = getEntityManager().createQuery("from Movie movie where movie.title =:title");
		query.setParameter("title", title);

		Movie dbMovie = (Movie) query.getSingleResult();
		return dbMovie;
	}

	public boolean checkTitle(String title) {

		Query query = getEntityManager().createQuery("from Movie movie where movie.title =:title");
		query.setParameter("title", title);

		if (query.getResultList().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

}
