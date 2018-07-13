package managedBeans;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;

import converters.MovieConverter;
import managers.IndisplayManager;
import model.Indisplay;
import model.Monitor;
import model.Movie;

@ManagedBean
@SessionScoped
public class InDisplayBean {

	private Indisplay inDisplay;
	private IndisplayManager indisplayManager;

	private List<Indisplay> indisplayListOfMonitor;
	private List<Indisplay> indisplayList;

	public InDisplayBean() {
		inDisplay = new Indisplay();
		indisplayManager = new IndisplayManager();
		indisplayList = new ArrayList<Indisplay>();
	}

	public List<Indisplay> getIndisplayList() {
		return indisplayList;
	}

	public void setIndisplayList(List<Indisplay> indisplayList) {
		this.indisplayList = indisplayList;
	}

	public List<Indisplay> getIndisplayListOfMonitor() {
		return indisplayListOfMonitor;
	}

	public void setIndisplayListOfMonitor(List<Indisplay> indisplayListOfMonitor) {
		this.indisplayListOfMonitor = indisplayListOfMonitor;
	}

	public Indisplay getInDisplay() {
		return inDisplay;
	}

	public void setInDisplay(Indisplay inDisplay) {
		this.inDisplay = inDisplay;
	}

	public IndisplayManager getIndisplayManager() {
		return indisplayManager;
	}

	public void setIndisplayManager(IndisplayManager indisplayManager) {
		this.indisplayManager = indisplayManager;
	}

	public void save() {
		indisplayManager.saveIndisplay(inDisplay);
	}

	public void update() {
		indisplayManager.updateIndisplay(inDisplay);
	}

	public void delete() {
		indisplayManager.deleteIndisplay(inDisplay);
	}

	public void setSelectedItem(Indisplay indisplay) {
		this.inDisplay = indisplay;
		System.out.println(inDisplay.getMovie().getTitle());
	}

	public void monitorUpdated(AjaxBehaviorEvent event) {
		indisplayListOfMonitor = indisplayManager.getDisplaysInMonitor(inDisplay.getMonitor());
	}

	public void startTimeUpdated(AjaxBehaviorEvent event) {
		inDisplay.setEndTime(indisplayManager.setEndTime(inDisplay.getMovie().getDuration(), inDisplay.getStartTime()));
	}

}
