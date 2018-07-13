package managers;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.MovieDAO;
import model.Kategorie;
import model.Movie;

public class MovieManager {

	private MovieDAO movieDAO = new MovieDAO();

	public void saveMovie(Movie movie) {
		movieDAO.saveMovie(movie);
	}

	public Movie getMovie(Movie movie) {
		return movieDAO.getMovie(movie);
	}

	public void updateMovie(Movie movie) {
		movieDAO.updateMovie(movie);
	}

	public void deleteMovie(Movie movie) {
		movieDAO.deleteMovie(movie);
	}

	public Movie getMovieByTitle(String title) {
		Movie movie = movieDAO.getMovieByTitle(title);
		return movie;
	}

	public List<Movie> getMovies() {
		return movieDAO.getMovies();
	}

	// Validations

	public boolean checkTitle(String title) {
		return movieDAO.checkTitle(title);
	}

	public boolean checkDuration(String duration) {

		boolean bool = true;

		if (duration.equals("")) {

			bool = false;
		}

		else {
			String hours = String.valueOf(duration.charAt(1));
			int hourInteger = Integer.valueOf(hours);

			String minutes = String.valueOf(duration.charAt(3));
			minutes = minutes + String.valueOf(duration.charAt(4));
			int minutesInteger = Integer.valueOf(minutes);

			String seconds = String.valueOf(duration.charAt(6));
			seconds = seconds + String.valueOf(duration.charAt(7));
			int secondsInteger = Integer.valueOf(seconds);

			if (hourInteger > 5) {
				bool = false;
			} else if (minutesInteger > 59) {
				bool = false;
			} else if (secondsInteger > 59) {
				bool = false;
			}

		}

		return bool;
	}

	public boolean checkReviews(String reviewsString) {

		double reviews = Double.valueOf(reviewsString);
		boolean bool = true;

		if (reviews < 0 || reviews > 10) {
			bool = false;
		}
		return bool;
	}

	public boolean checkStartDate(Date startDate) {

		Date date = null;
		boolean bool = true;

		if (startDate.getMonth() < Calendar.getInstance().get(Calendar.MONTH)) {
			bool = false;
		}

		return bool;
	}

	public boolean checkEndDate(Date endDate) {

		Date date = null;
		boolean bool = true;

		if (endDate.getMonth() < Calendar.getInstance().get(Calendar.MONTH)) {
			bool = false;
		}

		return bool;
	}

}
