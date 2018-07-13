package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import managers.MovieManager;
import model.Movie;

@FacesConverter(value = "movieConverter")
public class MovieConverter implements Converter {

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		Movie movie = new MovieManager().getMovieByTitle(arg2);
		return movie;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Movie movie = (Movie) arg2;
		return movie.getTitle();
	}

	
}
