package com.shop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = Customer.ENTITY_NAME)
public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2909382033593202896L;

	public static final String ENTITY_NAME = "CUSTOMER";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "last_name", nullable = false)
	private String lastname;
	
	@Column(name = "first_name", nullable = false)
	private String firstname;
	
	@Column(name = "phone_number", nullable = false)
	private String phone;
	
	@Column(name = "birth_date", nullable = false)
	private Date birthdate;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Set<Order> orders = new HashSet<>();

	public Customer() {}
	
	public Customer(String lastname, String firstname, String phone, Date birthdate) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.phone = phone;
		this.birthdate = birthdate;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public long getId() {
		return id;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
