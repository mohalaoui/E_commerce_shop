package com.shop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = Order.ENTITY_NAME)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "order")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3766413074621506228L;

	public static final String ENTITY_NAME = "PURCHASE_ORDER";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "date", nullable = false)
	private Date orderDate;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable( name = "ORDER_PRODUCT",
				joinColumns =  { @JoinColumn(name = "order_id") } ,
				inverseJoinColumns = { @JoinColumn(name = "product_id") }
			  )
	private Set<Product> products = new HashSet<>();
	
	// private Customer customer;

	public Order() {
	}

	public Order(Date orderDate) {
		this.orderDate = orderDate;
	}

	public long getId() {
		return id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}
