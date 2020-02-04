package edu.mum.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.domain.Product;
import edu.mum.repository.ProductRepository;
import edu.mum.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>)productRepository.findAll();
	}

	@Override
	public Product getProductById(Long productID) {
	
		return productRepository.findOne(productID);
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
		
	}
	

}
