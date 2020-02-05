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
    public List<Orders> findOrderForUser(String username) {
        return ordersRepository.findOrderForUser( username);
    }

    @Override
    public Orders findOne(Long id) {
        return ordersRepository.findOne(id);
    }
}
