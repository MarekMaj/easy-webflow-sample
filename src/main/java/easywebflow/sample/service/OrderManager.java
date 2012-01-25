package easywebflow.sample.service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Date;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import easywebflow.sample.model.Order;
import easywebflow.sample.model.OrderItem;
import easywebflow.sample.model.OrderItemId;
import easywebflow.sample.session.ShoppingCart;
import easywebflow.sample.session.UserManager;

public class OrderManager {

	@Inject 
	private ShoppingCart basket;
	@Inject
	private UserManager userManager;
	
	@PersistenceContext(name="sample")
	private EntityManager em;
	
	public OrderManager() {
		super();
	}
	
	public void completeOrder(Order order){
		BigDecimal value = new BigDecimal(basket.getTotalValue() + order.getShipmentType().getPrice().doubleValue());
		order.setTotalValue(value);
		
		order.setDate(new Date());
		
		order.setUser(userManager.getUser()); 
		em.persist(order);
	}

	public void completeOrderItems(Order order) {
		for (OrderItem i: basket.getOrderItems()){
			i.setId(new OrderItemId(order.getIdOrder(), i.getProduct().getIdProduct()));
			em.persist(i);
		}
		
	}
}
