package com.shop.entity;

import java.io.Serializable;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = Product.ENTITY_NAME)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "product")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4217228942072660483L;

	public static final String ENTITY_NAME = "PRODUCT";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
	private Set<Order> orders = new HashSet<>();
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "price", nullable = false)
	private double price;
	
	@Column(name = "available_stock", nullable = false)
	private long availableStock;

	public Product() {
	}

	public Product(Category category, String name, String description, double price, long availableStock) {
		super();
		this.category = category;
		this.name = name;
		this.description = description;
		this.price = price;
		this.availableStock = availableStock;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(long availableStock) {
		this.availableStock = availableStock;
	}

	public long getId() {
		return id;
	}

	@JsonIgnore
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
}
