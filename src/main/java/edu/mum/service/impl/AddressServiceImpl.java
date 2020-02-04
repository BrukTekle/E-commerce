package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Address;
import edu.mum.domain.Members;
import edu.mum.repository.AddressRepository;
import edu.mum.repository.MemberRepository;

@Service
@Transactional 
public class AddressServiceImpl implements edu.mum.service.AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	public void save( Address address) {
		addressRepository.save(address);
	}
	
	public List<Address> findAll() {
		return (List<Address>) addressRepository.findAll();
	}
	
	public Address findOne(Long id) {
		return addressRepository.findOne(id);
	}

}
