package easywebflow.sample.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import easywebflow.sample.model.User;

@Named
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UserService {

	@PersistenceContext(name="sample")
	private EntityManager em;

	public UserService() {
		super();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public boolean registerNewUser(User user){
		em.persist(user);
		return true;
	}

	public boolean uniqueLogin(User user){
		return (em.createNamedQuery(User.FIND_BY_LOGIN, User.class).
				setParameter("login", user.getLogin()).getResultList().size() != 0) 
				? false : true;
	}

}
