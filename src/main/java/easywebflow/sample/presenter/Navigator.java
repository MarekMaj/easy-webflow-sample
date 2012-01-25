package easywebflow.sample.presenter;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import easywebflow.sample.model.Category;
import easywebflow.sample.model.Product;

@Named
@SessionScoped
public class Navigator implements Serializable{

	private static final String PRODUCT_PARAM = "product";
	
	private Integer current;
	private Integer quantity;
	private List<Category> categories;
	private Product product;
	
	@PersistenceContext(name="sample")
	private EntityManager em;
	
	public Navigator() {
		super();
	}
	
	@PostConstruct
	public void initialize(){
		this.categories = em.createNamedQuery(Category.FIND_ALL, Category.class).getResultList();
	}
	
	private Integer getViewParameter(String name) {
        FacesContext fc = FacesContext.getCurrentInstance();
        String param = (String) fc.getExternalContext().getRequestParameterMap().get(name);
        if (param != null && param.trim().length() > 0) {
            return Integer.parseInt(param);
        } else {
            return null;
        }
	}

	public Product getProduct() {
		this.product = em.find(Product.class, this.getCurrent());
		return this.product;
	}
	// getters and setters
	
	public Integer getCurrent() {
		Integer incoming = this.getViewParameter(PRODUCT_PARAM);
		if (incoming!= null && incoming!= this.current){
			this.quantity = 1;
			this.current =incoming; 
		}
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public List<Category> getCategories() {
		return categories;
	}
	
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Integer getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}


