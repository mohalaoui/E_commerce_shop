package com.shop;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shop.entity.Category;
import com.shop.entity.Customer;
import com.shop.entity.Order;
import com.shop.entity.Product;
import com.shop.respository.CategoryRepository;
import com.shop.respository.CustomerRepository;
import com.shop.respository.ProductRepository;

@SpringBootApplication
public class ShopApplication implements CommandLineRunner{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		Category multimediaCateg = categoryRepository.findByName("multimedia");
//		
//		Optional<Product> prod1 = productRepository.findById(3L);
//		prod1.get().setCategory(multimediaCateg);
//		
//		Optional<Product> prod2 = productRepository.findById(4L);
//		prod2.get().setCategory(multimediaCateg);
//		
//		Optional<Customer> messi = customerRepository.findById(2L);
//		
//		Order order = new Order(new Date());
//		order.getProducts().add(prod1.get());
//		order.getProducts().add(prod2.get());
//		
//		messi.get().getOrders().add(order);
//		
//		customerRepository.save(messi.get());
	}

}
