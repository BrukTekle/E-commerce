package edu.mum.service;

import edu.mum.domain.Catagory;
import edu.mum.domain.Orders;

import java.util.List;

public interface OrdersService {

	public void save(Orders orders);
	public List<Orders> findAll();
	public List<Orders> findCompletedOrderForUser(String username);
	public Orders findInProgressOrderForUser(String username);
 	public Orders findOne(Long id);
 	public void updateToCompleted(String username);

	
}

	

