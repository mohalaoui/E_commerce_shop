package com.shop.web;

import static com.shop.web.ResourceRepresentationBuilderImpl.buildCollectionOfCustomerRepresentation;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shop.core.CustomerService;
import com.shop.entity.Customer;

@RestController
@CrossOrigin(origins="*")
public class ShopControllerImpl {
	
	@Autowired
	private CustomerService customerService; 
	
	
	@GetMapping(path ="/customers")
	public HttpEntity<CollectionOfResourceRepresentation<Customer>> getCustomers () {
		
		List<Customer> customers = customerService.getAllCustomer();
		CollectionOfResourceRepresentation<Customer> customersRepresentation = buildCollectionOfCustomerRepresentation(customers);
		customersRepresentation.add(linkTo(methodOn(ShopControllerImpl.class).getCustomers()).withSelfRel());
		
		return new ResponseEntity<>(customersRepresentation, HttpStatus.OK);
	}
	
	@GetMapping(path ="/customers/{id}")
	public HttpEntity<ResourceRepresentation<Customer>> getCustomer (@PathVariable long id) {
		
		Optional<Customer> customer = customerService.getCustomer(id);
		if(!customer.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ResourceRepresentation<Customer> resourceRepresentation = new ResourceRepresentation<Customer>(customer.get());
		resourceRepresentation.add(linkTo(methodOn(ShopControllerImpl.class).getCustomer(id)).withSelfRel());
		
		return new ResponseEntity<>(resourceRepresentation, HttpStatus.OK);
	}

}
