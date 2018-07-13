package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import managers.UserManager;
import model.User;

@ManagedBean
@SessionScoped
public class AccountBean {

	private User user;
	private UserManager userManager;
	private boolean loggedIn;

	public AccountBean() {
		user = new User();
		userManager = new UserManager();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public String login() {

		User user = userManager.getUser(this.user);

		if (user != null) {
			this.user = user;
			loggedIn = true;
			return "/admin/HomePage.xhtml?faces-redirect=true";
		} else {
			return "Login";
		}
	}

	public String signUp() {
		userManager.saveUser(user);
		return "/admin/HomePage.xhtml?faces-redirect=true";
	}

	public void modifyAccount() {
		userManager.updateUser(user);
	}

	public String logout() {
		userManager.destroySession();
		loggedIn = false;
		return "Login";
	}

	public void checkName(FacesContext facesContext, UIComponent component, Object name) throws ValidatorException {

		String data = name.toString();
		if (userManager.checkName(data) == false) {
			FacesMessage message = new FacesMessage(" Name must start with Uppercase and must not contain digits.");
			throw new ValidatorException(message);
		}
	}

	public void checkSurname(FacesContext facesContext, UIComponent component, Object surname)
			throws ValidatorException {

		String data = surname.toString();
		if (userManager.checkSurname(data) == false) {
			FacesMessage message = new FacesMessage(" Surname must start with Uppercase and must not contain digits.");
			throw new ValidatorException(message);
		}
	}

	// shto dhe nje validim per password.
	public void checkUsername(FacesContext facesContext, UIComponent component, Object username)
			throws ValidatorException {

		String data = username.toString();

		if (!data.equals(user.getUsername())) {
			if (userManager.checkUsername(data) == true) {
				FacesMessage message = new FacesMessage(" Username is already taken.");
				throw new ValidatorException(message);
			}
		}
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

}
