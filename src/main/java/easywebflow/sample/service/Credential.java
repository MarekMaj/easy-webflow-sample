package easywebflow.sample.service;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class Credential implements Serializable{
	
	private String username;
	private String password;
	
	public Credential() {
		super();
		System.out.println("Konstruktor credential");
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
}
