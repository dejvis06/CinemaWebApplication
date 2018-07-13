package managers;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.Query;
import javax.swing.tree.ExpandVetoException;

import dao.UserDAO;
import model.User;

public class UserManager {

	private UserDAO userDAO = new UserDAO();
	
	public void saveUser(User user) {
		userDAO.saveUser(user);
	}

	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}

	public User getUser(User user) {
		return userDAO.getUser(user);
	}
	
	public void destroySession() {
		userDAO.destroySession();
	}

	public boolean checkName(String name) {

		Pattern numberPattern = Pattern.compile("[0-9 ]");

		if (Character.isUpperCase(name.charAt(0)) && !numberPattern.matcher(name).find()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkSurname(String surname) {

		//Shto karakteret.
		Pattern numberPattern = Pattern.compile("[0-9 ]");

		if (Character.isUpperCase(surname.charAt(0)) && !numberPattern.matcher(surname).find()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkUsername(String username) {
		return userDAO.checkUsername(username);
	}

}
