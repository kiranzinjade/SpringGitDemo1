package com.web.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.demo.model.Product;
import com.web.demo.service.ProductService;

@RestController
//@RequestMapping("/api/v1/products")
public class SearchController {

	public SearchController(ProductService productService) {
		super();
		this.productService = productService;
	}

	private ProductService productService;

	@GetMapping("/search")
	public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query) {

		return ResponseEntity.ok(productService.seProducts(query));
	}

	@PostMapping("/createproduct")
	public void createProduct(@RequestBody Product product) {
		productService.createProduct(product);
	}
	
	@GetMapping("/getallproducts")
	public List<Product> getAllProduct()
	{
		return productService.getAllProducts();
	}
	
	@PutMapping("/updateproduct/{id}")
	public Product updateProduct(@PathVariable("id") long id,@RequestBody Product product)
	{
		
		       productService.updateProduct(id,product);
		       return product;
	}

}
