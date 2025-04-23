package com.cts.service;

import java.util.List;

import com.cts.exceptions.ProductNotFound;
import com.cts.model.Product;

public interface ProductService {

	public abstract Product saveProduct(Product product);

	public abstract Product updateProduct(Product product);

	public abstract String removeProduct(int productId);

	public abstract Product getProduct(int productId) throws ProductNotFound;

	public abstract List<Product> getAllProductsBetween(int initialPrice, int finalPrice);

	public abstract List<Product> getAllProductsByCategory(String category);

	public abstract List<Product> getAllProducts();
	
	public abstract List<Product> getAllProductsAbove(int price);

}
