package com.bajkic.market.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String productName;
	private int quantity;
	private String productType;
	private double price;	
	private double desiredAmount;
	
	public Product(Integer id, String productName, int quantity, String productType,double price,double desiredAmount) {
		super();
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
		this.productType = productType;
		this.price = price;
		this.desiredAmount = desiredAmount;
	}
	
	
	public Product() {
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
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
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
