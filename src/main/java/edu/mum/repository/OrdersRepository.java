package edu.mum.repository;

import edu.mum.domain.Catagory;
import edu.mum.domain.Members;
import edu.mum.domain.Orders;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long> {

    @Query("SELECT o from Orders o where o.member.userCredentials.username=:username and o.status='COMPLETED'")
    public List<Orders> findCompletedOrderForUser(@Param("username") String username);


    @Query("SELECT o from Orders o where o.member.userCredentials.username=:username and o.status='IN PROGRESS'")
    public Orders findInProgressOrderForUser(@Param("username") String username);

    @Query("SELECT o from Orders o where o.member=:member AND o.status='IN PROGRESS'")
    public Orders findCartForMember(@Param("member") Members member);

    @Modifying
    @Query("update Orders o SET o.status='COMPLETED' where o.member.userCredentials.username=:username")
    public Orders updateToCompleted( @Param("username") String username);

}
