package easywebflow.sample;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import easywebflow.sample.model.User;

@ApplicationScoped
@Named
public class Service implements Serializable { 
	 
	private Set<User> set = new HashSet<User>();
	
	public Service() { 
		super();
		System.out.println("Konstruktor service:"); 
	} 
 
	public Set<User> getSet() {
		return set;
	}
	
	public void addToSet(User sfd){
		set.add(sfd);
	}
	
	public void showThemAll(){
		System.out.println("Show them all:");
		Iterator<User> iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
		}
	}
	
	public int countUsers(){
		return set.size();
	}
}