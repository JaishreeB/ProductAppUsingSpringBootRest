package com.cts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.model.Product;
import com.cts.repository.ProductRepository;
import com.cts.service.ProductServiceImpl;

@SpringBootTest
class ProductCrudOperationsUsingSpringJpaApplicationTests {
	@Mock
	ProductRepository repository;
	
	@InjectMocks
	ProductServiceImpl service;
	

	@Test
	void saveProductTest() {
		Product product = new Product("Samsung",2300,"electronics",20);
		Mockito.when(repository.save(product)).thenReturn(product);
		Product response = service.saveProduct(product);
		assertEquals("product saved successfully", response);
	}
}
