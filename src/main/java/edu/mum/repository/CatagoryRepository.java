package edu.mum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Catagory;
@Repository
public interface CatagoryRepository extends CrudRepository<Catagory, Integer> {


}
