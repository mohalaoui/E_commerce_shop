package com.shop.web;

import java.util.ArrayList;
import java.util.List;

import com.shop.entity.Customer;

public class ResourceRepresentationBuilderImpl {
	
	public static ResourceRepresentation<Customer> buildCustomerRepresentation(Customer customer) {
		ResourceRepresentation<Customer> resourceRepresentation = new ResourceRepresentation<>(customer);
		return resourceRepresentation;
	}
	
	public static CollectionOfResourceRepresentation<Customer> buildCollectionOfCustomerRepresentation(List<Customer> customers) {
		List<ResourceRepresentation<Customer>> resourceList = new ArrayList<>();
		for(Customer customer: customers) {
			ResourceRepresentation<Customer> customerRepresentation = buildCustomerRepresentation(customer);
			resourceList.add(customerRepresentation);
		}
		
		CollectionOfResourceRepresentation<Customer> collectionOfResourceRepresentation = new CollectionOfResourceRepresentation<>(resourceList);
		return collectionOfResourceRepresentation;
	}

}
