package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exceptions.ProductNotFound;
import com.cts.model.Product;
import com.cts.service.ProductService;

@RestController
@RequestMapping("/products") // http://localhost:8080/products
public class ProductController {
	@Autowired
	ProductService service;

	@GetMapping("/getproduct/{pid}") // http://localhost:8080/products/getproduct
	public Product fetchProduct(@PathVariable("pid") int productId) throws ProductNotFound {
		return service.getProduct(productId);
	}

	@PostMapping("/saveproduct") // http://localhost:1111/products/saveproduct
	public Product insertProduct(@RequestBody @Validated Product product) {
		return service.saveProduct(product);
	}

	@PutMapping("/updateproduct") // http://localhost:1111/products/updateproduct
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}

	@DeleteMapping("/deleteproduct/{pid}") // http://localhost:1111/products/updateproduct
	public String deleteProduct(@PathVariable("pid") int productId) {
		return service.removeProduct(productId);
	}

	@GetMapping("/getallproducts") // http://localhost:8080/products/getproduct
	public List<Product> fetchAllProducts() {
		return service.getAllProducts();
	}

	@GetMapping("/getallproductsbetweenprices/{initialPrice}/{finalPrice}") // http://localhost:8080/products/getproduct
	public List<Product> fetchAllProductsBetween(@PathVariable("initialPrice") int initialPrice,
			@PathVariable("finalPrice") int finalPrice) {
		return service.getAllProductsBetween(initialPrice, finalPrice);
	}

	@GetMapping("/getallproductsbycategory/{category}") // http://localhost:8080/products/getproduct
	public List<Product> fetchAllProductsByCategory(@PathVariable("category") String category) {
		return service.getAllProductsByCategory(category);
	}

	@GetMapping("/getallproductsaboveprice/{price}") // http://localhost:8080/products/getproduct
	public List<Product> fetchAllProductsAbovePrice(@PathVariable("price") int price) {
		return service.getAllProductsAbove(price);
	}

//	@ExceptionHandler(exception = ProductNotFound.class,produces = "Product Id Is Invalid")
//	public void handleProductNotFound()
//	{
//		
//	}

}
