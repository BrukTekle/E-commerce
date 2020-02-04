package edu.mum.service;

import java.util.List;

import edu.mum.domain.Catagory;
import edu.mum.domain.Members;
import edu.mum.repository.CatagoryRepository;

public interface CatagoryService {

	public void save(Catagory catagory);
	public List<Catagory> findAllCatagories();
 	public Catagory findOne(int id);
	
	
}

	

