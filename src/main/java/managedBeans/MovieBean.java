package managedBeans;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import managers.MovieManager;
import model.Kategorie;
import model.Movie;

@ManagedBean
@SessionScoped
public class MovieBean {

	private Movie movie;
	private MovieManager movieManager;

	public MovieBean() {
		movie = new Movie();
		movieManager = new MovieManager();
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public MovieManager getMovieManager() {
		return movieManager;
	}

	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}

	public void saveMovie() {
		movieManager.saveMovie(movie);
	}

	public void updateMovie() {
		movieManager.updateMovie(movie);
	}

	public List<Movie> getMovies() {
		System.out.println(movieManager.getMovies());
		System.out.println(movie);
		return movieManager.getMovies();
	}

	// Validations
	public void checkTitle(FacesContext facesContext, UIComponent component, Object title) throws ValidatorException {

		String data = title.toString();

		if (movieManager.checkTitle(data) == true) {
			FacesMessage message = new FacesMessage(" Movie already exists.");
			throw new ValidatorException(message);
		}

	}

	public void checkReviews(FacesContext facesContext, UIComponent component, Object reviews)
			throws ValidatorException {

		if (movieManager.checkReviews(reviews.toString()) == false) {
			FacesMessage message = new FacesMessage("Reviews Should be between 0 and 10.");
			throw new ValidatorException(message);
		}
	}

	public void checkEndDate(FacesContext facesContext, UIComponent component, Object endDateUI)
			throws ValidatorException {

		Date endDate = (Date) endDateUI;
		
		UIInput startDateUI = (UIInput) component.getAttributes().get("startDate");
		Date startDate = (Date) startDateUI.getSubmittedValue();
	}

}