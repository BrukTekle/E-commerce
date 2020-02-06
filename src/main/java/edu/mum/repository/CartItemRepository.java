package edu.mum.repository;

import edu.mum.domain.CartItem;
import edu.mum.domain.Catagory;
import edu.mum.domain.Orders;
import edu.mum.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Long> {

    @Query("SELECT c from CartItem  c where c.order=:order and c.product=:product")
    public CartItem findCartItemByProductAndOrder(@Param("product") Product product, @Param("order") Orders order);

}
