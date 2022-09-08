package com.web.demo.service;

import java.util.List;

import com.web.demo.model.Product;
public interface ProductService {

	public List<Product> seProducts(String query)  ;

	public Product createProduct(Product product);

	public void updateProduct(long id,Product product);

	public List<Product> getAllProducts();
}
