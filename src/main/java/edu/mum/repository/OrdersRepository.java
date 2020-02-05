package edu.mum.repository;

import edu.mum.domain.Catagory;
import edu.mum.domain.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long> {

    @Query("SELECT o from Orders o where o.member.userCredentials.username=:username")
    public List<Orders> findOrderForUser(@Param("username") String username);

}
