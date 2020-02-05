package edu.mum.service;

import edu.mum.domain.Catagory;
import edu.mum.domain.Orders;

import java.util.List;

public interface OrdersService {

	public void save(Orders orders);
	public List<Orders> findAll();
	public List<Orders> findOrderForUser(String username);
 	public Orders findOne(Long id);
	
	
}

	

