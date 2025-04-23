package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.exceptions.ProductNotFound;
import com.cts.model.Product;
import com.cts.repository.ProductRepository;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	Logger log =LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	ProductRepository repository;

	@Override
	public Product saveProduct(Product product) {
		log.info("In ProductServiceImpl saveproduct method .....");
		return repository.save(product);		
	}

	@Override
	public Product updateProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public String removeProduct(int productId) {
		repository.deleteById(productId);
		return "product deleted";
	}

	@Override
	public Product getProduct(int productId) throws ProductNotFound{
		Optional<Product> optional=repository.findById(productId);
		if(optional.isPresent())
			return optional.get();
		else
			throw new ProductNotFound("Prodcut Id is not valid.........");
				
	}

	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public List<Product> getAllProductsBetween(int initialPrice, int finalPrice) {
		return repository.findByProductPriceBetween(initialPrice, finalPrice);
	}

	@Override
	public List<Product> getAllProductsByCategory(String category) {
		return repository.findByProductCategoryIs(category);
	}

	@Override
	public List<Product> getAllProductsAbove(int price) {
		return repository.findByProductPriceGreaterThan(price);
		
	}

}
