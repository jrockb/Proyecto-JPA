package co.com.jcd.proyectojpa.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.jcd.proyectojpa.entidades.Customer;

@Stateless
public class CustomerJpaController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager entityManager;
	
	public void create(Customer customer) {
		try {
			entityManager.persist(customer);
		}	
		catch(Exception ex) {
			ex.printStackTrace();		
		}
	}
	
	public List<Customer> list(){
		return entityManager
				.createQuery("FROM Customer m", Customer.class)
				.getResultList();
	}	
	
	
}
	

	
	
	
	
	
	
	


