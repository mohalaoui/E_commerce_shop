package com.shop.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	Category findByName(String name);

}
