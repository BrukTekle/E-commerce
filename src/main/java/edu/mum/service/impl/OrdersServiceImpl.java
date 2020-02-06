package edu.mum.service.impl;

import edu.mum.domain.Orders;
import edu.mum.repository.OrdersRepository;
import edu.mum.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public void save(Orders orders) {
        ordersRepository.save(orders);
    }
    @Override
    public List<Orders> findAll() {
        return (List<Orders>) ordersRepository.findAll();
    }

    @Override
    public List<Orders> findCompletedOrderForUser(String username) {
        return ordersRepository.findCompletedOrderForUser( username);
    }

    @Override
    public Orders findInProgressOrderForUser(String username) {
        return ordersRepository.findInProgressOrderForUser( username);

    }

    @Override
    public Orders findOne(Long id) {
        return ordersRepository.findOne(id);
    }

    @Override
    public void updateToCompleted(String username) {

        Orders order =findInProgressOrderForUser(username);
        order.setStatus("COMPLETED");
        ordersRepository.save(order);
    }
}
