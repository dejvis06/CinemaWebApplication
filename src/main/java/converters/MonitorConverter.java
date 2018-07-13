package converters;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import dao.CategorieDAO;
import dao.MonitorDAO;
import dao.MovieDAO;
import model.Kategorie;
import model.Monitor;

@FacesConverter(value = "monitorConverter")
public class MonitorConverter implements Converter {

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		Monitor monitor = new MonitorDAO().getMonitorByNumber(arg2);
		return monitor;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
