package com.bajkic.market.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cart")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CartProduct {
	
	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		private String productName;
		
		private int quantity;
		
		private double price;
		
		private double desiredAmount;
		
		public CartProduct(Integer id, String productName, int quantity,double price,double desiredAmount) {
			super();
			this.id = id;
			this.productName = productName;
			this.quantity = quantity;
			this.price = price;
			this.desiredAmount = desiredAmount;
		}
		
		
		public CartProduct() {
			super();
		}


		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}


		public double getPrice() {
			return price;
		}


		public void setPrice(double price) {
			this.price = price;
		}


		public double getDesiredAmount() {
			return desiredAmount;
		}


		public void setDesiredAmount(double desiredAmount) {
			this.desiredAmount = desiredAmount;
		}
		
		
		
	}

