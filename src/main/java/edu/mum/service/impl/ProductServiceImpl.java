package edu.mum.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.mum.domain.CartItem;
import edu.mum.domain.Members;
import edu.mum.domain.Orders;
import edu.mum.repository.CartItemRepository;
import edu.mum.repository.MemberRepository;
import edu.mum.repository.OrdersRepository;
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
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    MemberRepository memberRepository;

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productID) {

        return productRepository.findOne(productID);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);

    }

    @Override
    public void addProductToCard(Long productId, String username) {

        System.out.println("IN addProductToCard");
        System.out.println("Product id is " + productId);
        ordersRepository.findOne(1L);

        System.out.println("IN productRepository" + productRepository);
        Product product = productRepository.findProductById(1L);
        System.out.println("product" + product);
        Members member = memberRepository.findMembersByUserName(username);
        System.out.println("member" + member);

        Orders order = ordersRepository.findCartForMember(member);
        System.out.println("order" + order);

        if (order == null) {
            order = new Orders();
            order.setStatus("IN PROGRESS");
            order.setMember(member);
            ordersRepository.save(order);
        }
        CartItem cartItem = cartItemRepository.findCartItemByProductAndOrder(product, order);
        System.out.println("cartItem" + cartItem);

        if (cartItem == null || cartItem.getProduct().getId() != productId) {
            cartItem = new CartItem(product, order, 1);
        } else {
            cartItem.setAmount(cartItem.getAmount() + 1);
        }
        System.out.println("SAVED CART ITEM " + cartItem);
        cartItemRepository.save(cartItem);
    }

    @Override
    public void decreaseAmount(Long productId, Integer number) {
        Product product = productRepository.findOne(productId);
        product.setAmount(product.getAmount() - number);
        productRepository.save(product);

    }

}
