package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Catagory;
import edu.mum.repository.CatagoryRepository;
import edu.mum.service.CatagoryService;
@Service
@Transactional
public class CatagoryServiceImpl implements CatagoryService {
	@Autowired
	CatagoryRepository catagoryRepository;

	@Override
	public void save(Catagory catagory) {
		  catagoryRepository.save(catagory);

	}

	@Override
	public List<Catagory> findAllCatagories() {
		return (List<Catagory>)catagoryRepository.findAll();
	}

	@Override
	public Catagory findOne(int id) {
		return catagoryRepository.findOne(id);
	}
}
