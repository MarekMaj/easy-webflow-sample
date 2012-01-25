package easywebflow.sample.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import easywebflow.sample.model.OrderItem;
import easywebflow.sample.model.Product;

@SessionScoped
@Named
public class ShoppingCart implements Serializable{

	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	public ShoppingCart() {
		super();
	}
	
	public void add(Product product, Integer quantity){
		if (quantity > product.getQuantity()){
			FacesContext.getCurrentInstance().addMessage("dodajDoKoszyka", new FacesMessage("Niewystarczająca ilość w magazynie"));
			return;
		}

		// if product already in basket
		for (OrderItem existing: this.orderItems){
			if (existing.getProduct().getIdProduct() == product.getIdProduct() ){
				modifyQuantity(existing, existing.getQuantity() + quantity);
				return;
			}
		}

		OrderItem oi = new OrderItem(product, product.getPrice(), quantity);
		this.orderItems.add(oi);
		FacesContext.getCurrentInstance().addMessage("dodajDoKoszyka", new FacesMessage("Dodano produkt do koszyka"));
	}
	
	public void modifyQuantity(OrderItem oi, Integer quantity){
		if (quantity > oi.getProduct().getQuantity()){
			oi.setQuantity(oi.getProduct().getQuantity());
			FacesContext.getCurrentInstance().addMessage("dodajDoKoszyka", new FacesMessage("Niewystarczająca ilość w magazynie"));
			return;
		}
		oi.setQuantity(quantity);
		FacesContext.getCurrentInstance().addMessage("dodajDoKoszyka", new FacesMessage("Zmodyfikowano liczbę produktów w koszyku"));
	}
	
	public Double getTotalValue(){
		Double value = 0.0;
		for(OrderItem io: this.orderItems){
			value = value + io.getQuantity()*io.getPrice().doubleValue();
		}
		return value;
	}
	
	public void remove(OrderItem oi){
		this.orderItems.remove(oi);
	}
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public void cleanShoppingCart(){
		this.orderItems = new ArrayList<OrderItem>();
	}
}
