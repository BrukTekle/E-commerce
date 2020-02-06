package edu.mum.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("SELECT p from Product p where p.id =:id")
    public Product findProductById(@Param("id") Long id);
}
