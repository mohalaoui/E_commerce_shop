package com.shop.core;

import java.util.List;
import java.util.Optional;

import com.shop.entity.Customer;

public interface CustomerService {
	
	Customer addCustomer(Customer customer);
	
	void removeCustomer(Customer customer);
	
	Optional<Customer> getCustomer(long id);
	
	List<Customer> getAllCustomer();

}
