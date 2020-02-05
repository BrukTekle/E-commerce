package edu.mum.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.mum.domain.Product;


public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(Long productID);
	
	List<Product> getProductsByCategory(String category);

	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	void addProduct(Product product);

}
