package edu.mum.service;

import edu.mum.domain.Catagory;
import edu.mum.domain.Orders;

import java.util.List;

public interface OrdersService {

	public void save(Orders orders);
	public List<Orders> findAll();
 	public Orders findOne(Long id);
	
	
}

	

