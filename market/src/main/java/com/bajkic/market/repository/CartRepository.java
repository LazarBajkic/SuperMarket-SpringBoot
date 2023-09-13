package com.bajkic.market.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.bajkic.market.model.CartProduct;

public interface CartRepository extends JpaRepository<CartProduct, Integer>{
	
}
