package com.shop.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
