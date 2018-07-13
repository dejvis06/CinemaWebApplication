package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import managers.HallManager;
import managers.MovieManager;
import model.Hall;
import model.Movie;

@FacesConverter(value = "hallConverter")
public class HallConverter implements Converter {

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Hall hall = new HallManager().getHall(arg2);
		return hall;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
