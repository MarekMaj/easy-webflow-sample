package easywebflow.sample.session;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.validation.constraints.AssertTrue;

@RequestScoped
public class Credential implements Serializable{
	
	private String username;
	private String password;
	private String password2;
	
	public Credential() {
		super();
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword2() {
		return password2;
	}
	
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
}
