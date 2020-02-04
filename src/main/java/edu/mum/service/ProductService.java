package edu.mum.service;

import java.util.List;

import edu.mum.domain.Catagory;
import edu.mum.domain.Product;

public interface ProductService {
	public void save(Product catagory);
	public List<Product> findAllProducts();
 	public Product findOne(int id);
	

}
