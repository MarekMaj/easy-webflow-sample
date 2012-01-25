package easywebflow.sample.session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import easywebflow.sample.model.User;

@SessionScoped
@Named
public class UserManager implements Serializable{

	private User user;
	@Inject
	private Credential credential;
	@PersistenceContext(name="sample") 
	private EntityManager em;

	public UserManager() {
		super();
	}

	public void login() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		try {
			request.login(this.credential.getUsername(), this.credential.getPassword());
			// get user from database - use EM without seperate DAO	     
			this.user = em.createNamedQuery(User.FIND_BY_LOGIN, User.class).
					setParameter("login", this.credential.getUsername()).getSingleResult();

			System.out.println("User principal " +request.getUserPrincipal());
			context.addMessage("loginForm", new FacesMessage("Zostałeś zalogowany " + this.user.getName()));
			// TODO porownanie hashy passwordow
		} catch (ServletException e) {
			// Handle unknown username/password in request.login().
			context.addMessage("loginForm", new FacesMessage("Niepoprawny login lub hasło"));
		} 

	} 
	
	public String logout(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.user = null;
			context.addMessage("loginForm", new FacesMessage("Zostałeś wylogowany"));
			context.getExternalContext().invalidateSession();
		} catch(Exception e){
			context.addMessage(null, new FacesMessage("Wylogowanie niepoprawne"));
		}
		return "/login.jsf?faces-redirect=true";
	}

	// getters and setters
	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
