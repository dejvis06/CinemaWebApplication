package managers;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Query;

import dao.IndisplayDAO;
import model.Indisplay;
import model.Monitor;
//..import test.Kinema;

public class IndisplayManager {

	private IndisplayDAO indisplayDAO = new IndisplayDAO();
	
	public void saveIndisplay(Indisplay indisplay) {
		indisplayDAO.saveIndisplay(indisplay);
	}
	
	public void updateIndisplay(Indisplay indisplay) {
		indisplayDAO.updateIndisplay(indisplay);
	}
	
	public void deleteIndisplay(Indisplay indisplay) {
		indisplayDAO.deleteIndisplay(indisplay);
	}

	public Time setEndTime(Time duration,Time startTime) {
		
		Time endTime = new Time(startTime.getHours()+duration.getHours(),startTime.getMinutes()+duration.getMinutes(),startTime.getSeconds()+duration.getSeconds());
		return endTime;
	}
	
	public List<Indisplay> getDisplays(){
		return indisplayDAO.getDisplays();
	}
	
	public List<Indisplay> getDisplaysInMonitor(Monitor monitor){
		return indisplayDAO.getDisplaysInMonitor(monitor);
	}
	
}
