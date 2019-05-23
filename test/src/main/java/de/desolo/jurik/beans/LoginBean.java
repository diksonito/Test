package de.desolo.jurik.beans;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import de.desolo.jurik.dao.UsersDao;
import de.desolo.jurik.resources.Session;
import de.desolo.jurik.resources.User;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String password;
	private String message, uname;
	
	private UsersDao userService = new UsersDao();
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String loginProject() {
		User user = userService.findByLogin(uname);

		if (user.password == password) {
			// get Http Session and store username
			HttpSession session = Session.getSession();
			session.setAttribute("username", uname);
			return "table";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Invalid Login!", "Please Try Again!"));
			// invalidate session, and redirect to other pages
			// message = "Invalid Login. Please Try Again!";
			return "index";
		}
	}

	public String logout() {
		HttpSession session = Session.getSession();
		session.invalidate();
		return "index";
	} 
}