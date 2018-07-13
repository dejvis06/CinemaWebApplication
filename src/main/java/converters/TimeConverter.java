package converters;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import managers.MovieManager;

@FacesConverter(value = "timeConverter")
public class TimeConverter implements Converter {

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Time time = null;

		MovieManager movieManager = new MovieManager();
		movieManager.checkDuration(arg2);
		if(movieManager.checkDuration(arg2)) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				time = new Time(sdf.parse(arg2).getTime());
				
			} catch (Throwable ex) {
				ResourceBundle bundle = ResourceBundle.getBundle("messages");
				FacesMessage msg = new FacesMessage(bundle.getString("not converted."));
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ConverterException(msg);
			}
			
			return time;
		}
		
		else {
			return null;
		}
	}

	
}
