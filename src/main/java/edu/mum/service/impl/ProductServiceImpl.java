package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Product;
import edu.mum.repository.ProductRepository;
import edu.mum.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public void save(Product product) {
		productRepository.save(product);
	}

	@Override
	public List<Product> findAllProducts() {

		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product findOne(int id) {

		return productRepository.findOne(id);
	}

}
