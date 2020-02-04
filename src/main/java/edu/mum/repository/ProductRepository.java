package edu.mum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
}
