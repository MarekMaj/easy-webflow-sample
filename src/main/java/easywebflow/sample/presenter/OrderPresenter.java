package easywebflow.sample.presenter;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import easywebflow.sample.model.PaymentType;
import easywebflow.sample.model.ShipmentType;

@Named
@RequestScoped
public class OrderPresenter {

	@PersistenceContext(name="sample")
	private EntityManager em;
	
	private int shipType;  
	private int payType;
	
	public OrderPresenter() {
		super();
	}
	
	public ShipmentType getShipmentType() { 
		return em.find(ShipmentType.class, shipType); 
	}
	
	public PaymentType getPaymentType(){
		return em.find(PaymentType.class, payType);
	}
	
	public int getShipType() {
		return shipType;
	}
	
	public void setShipType(int type) {
		this.shipType = type;
	}
	
	public int getPayType() {
		return payType;
	}
	
	public void setPayType(int payType) {
		this.payType = payType;
	}
	
	public List<ShipmentType> getShipments(){
		return em.createNamedQuery(ShipmentType.FIND_ALL, ShipmentType.class).getResultList();
	}
	
	public List<PaymentType> getPayments(){
		return em.createNamedQuery(PaymentType.FIND_ALL, PaymentType.class).getResultList();
	}
}
