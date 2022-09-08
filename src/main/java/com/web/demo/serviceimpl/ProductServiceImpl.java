package com.web.demo.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public void updateProduct(long id,Product product) {
		
		List<Product> list=productRepository.findAll();
		
		List<Product> lpr=list.stream().map(b->
		{
			if(b.getId()==id)
			{
				b.setId(id);
				b.setSku(product.getSku());
				b.setName(product.getName());
			}
			return b;
		}).collect(Collectors.toList());
		
		
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

}
