package co.com.jcd.proyectojpa.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import co.com.jcd.proyectojpa.dao.CustomerJpaController;
import co.com.jcd.proyectojpa.entidades.Customer;

@Named
@RequestScoped
public class CustomerBean {
	
	private Customer customer = new Customer();
	private List<Customer> customers;
	private String lastName;
	private String firstName;
	
	@Inject
	private CustomerJpaController customerController;
	
	@PostConstruct
	public void init() {
		customers = customerController.list();
	}
	
	public void submit() {
		try {
			customer.setLastName(lastName);
			customer.setFirstName(firstName);
			customerController.create(customer);
			customers.add(customer);
			customer = new Customer();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the customers
	 */
	public List<Customer> getCustomers() {
		return customers;
	}

	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
}
