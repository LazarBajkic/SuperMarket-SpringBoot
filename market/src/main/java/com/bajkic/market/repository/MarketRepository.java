package com.bajkic.market.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bajkic.market.model.Product;

@Repository
public interface MarketRepository extends JpaRepository<Product, Integer>{
	
	@Query(value="SELECT * FROM products p where p.product_type=:productType",nativeQuery=true)
	List<Product> findProductTypes(String productType);
	
	@Query(value="SELECT * FROM products p where p.id=:id",nativeQuery=true)
	Product findProductTypes(Integer id);
		
}
