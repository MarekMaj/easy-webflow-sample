package easywebflow.sample;

import java.io.Serializable;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Model;

@Model
public class User implements Serializable{
	
	private String name;
	
	private String password;
	private int age;
	
	public User() {
	}
	
	public User(User u) {
		super();
		this.name = u.getName();
		this.password = u.getPassword();
		this.age = u.getAge();
	}

	public User(String name, String password, int age) {
		super();
		this.name = name;
		this.password = password;
		this.age = age;
	}

	@PostConstruct
	public void g(){
		System.out.println("Wolam konstruktor usera");
	}
	
	@PreDestroy
	public void P(){
		System.out.println("Wolam destruktor usera");
	}
	
	public User(String name){
		this.name = name;
	}

	public void getD(){
		System.out.println("CD...");
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", age=" + age
				+ "]";
	}

}
