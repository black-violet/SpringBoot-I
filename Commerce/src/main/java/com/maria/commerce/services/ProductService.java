package com.maria.commerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.maria.commerce.models.Product;
import com.maria.commerce.repositories.ProductRepository;


@Service
public class ProductService {

	private final ProductRepository productRepo;
	
	public ProductService(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	public List<Product> allProduct(){
		return productRepo.findAll();
	}
	
	public Product createProduct(Product product) {
		return  productRepo.save(product);
	}
	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}else {
		return null;
		}
	}
	
}
