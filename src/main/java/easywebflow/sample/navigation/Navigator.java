package easywebflow.sample.navigation;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Navigator implements Serializable{

	private Integer current;
	private Categories categories;
	
	public String order(){
		this.current = -1;
		return "info_order";
		// albo tutaj zrobic onclick
	}
	
	public String ship(){
		this.current = -1;
		return "info_ship";
	}
	
	public String contact(){
		this.current = -1;
		return "info_contact";
	}

	// getters and setters
	
	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}
	
}


