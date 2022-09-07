package com.web.demo.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.demo.model.Product;
import com.web.demo.repository.ProductRepository;
import com.web.demo.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

private	ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> seProducts(String query) {
		
		return productRepository.searchProducts(query);
	}

	@Override
	public Product createProduct(Product product) {
		
		
		return productRepository.save(product);
	}

}
