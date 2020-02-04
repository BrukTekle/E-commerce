package edu.mum.repository;

import edu.mum.domain.Catagory;
import edu.mum.domain.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long> {


}
