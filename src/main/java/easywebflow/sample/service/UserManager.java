package easywebflow.sample.service;

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

	@Inject
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
	        
	    	System.out.println(request.getUserPrincipal());
	    	System.out.println(request.isUserInRole("admin"));
	    	System.out.println(request.isUserInRole("USER"));
	    	System.out.println(request.isUserInRole("ADMINISTRATOR"));
	    	// TODO porownanie hashy passwordow
	    } catch (ServletException e) {
	        // Handle unknown username/password in request.login().
	        context.addMessage(null, new FacesMessage("Unknown login"));
	    }

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
