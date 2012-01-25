package easywebflow.sample.service;


import javax.inject.Inject;

import easywebflow.sample.model.Order;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class OrderService {

	@Inject
	private OrderManager orderManager;
	
	public OrderService() {
		super();
	}

	@RolesAllowed("USER")
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public boolean confirmOrder(Order order){
		this.completeOrder(order);
		this.completeOrderItems(order);
		return true;
	}

	@RolesAllowed("USER")
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void completeOrderItems(Order order) {
		orderManager.completeOrderItems(order);
		
	}

	@RolesAllowed("USER")
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void completeOrder(Order order){
		orderManager.completeOrder(order);
	}

}
