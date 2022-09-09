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
		
		list=list.stream().map(b->{
			if(b.getId()==id)
			{
				
				b.setSku(product.getSku());
				b.setName(product.getName());
				b.setDescription(product.getDescription());
				b.setActive(product.getActive());
				b.setImageUrl(product.getImageUrl());
				b.setDatecreate(product.getDatecreate());
				b.setDateupdated(product.getDateupdated());
			}
			
			return b;
		}).collect(Collectors.toList());
		
		
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

}
