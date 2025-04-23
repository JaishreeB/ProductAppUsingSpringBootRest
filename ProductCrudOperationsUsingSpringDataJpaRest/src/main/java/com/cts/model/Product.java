package com.cts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "products_info")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Product {
	@Id
	@Column(name = "pid")
	@GeneratedValue
	private int productId;
	@NotBlank(message = "Product name can't be null or blank")
	private String productName;
	@Column(name = "price")
	@Min(value = 100, message = "product price can't be below 100")
	@Max(value = 300000, message = "product price cannot be more than 300000")
	private int productPrice;
	@Size(min = 5, max = 12, message = "category length must be between (5,12)")
	private String productCategory;
	@Column(name = "quantity", length = 8)
	@PositiveOrZero(message = "category length must be between (5,12)")
	private int productQuantity;

	public Product(String productName, int productPrice, String productCategory, int productQuantity) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}

}
