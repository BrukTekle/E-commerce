package edu.mum.service.impl;

import java.util.List;

import edu.mum.domain.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.repository.MemberRepository;
import edu.mum.service.AddressService;
import edu.mum.service.UserCredentialsService;

@Service
@Transactional 
public class MemberServiceImpl implements edu.mum.service.MemberService {
	
 	@Autowired
	private MemberRepository memberRepository;

 	@Autowired
 	UserCredentialsService credentialsService;
 	
 	@Autowired
 	AddressService addressService;

// 	@PreAuthorize("hasRole('ROLE_ADMIN')")
 	    public void save( Members member) {
		memberRepository.save(member);
	}
 	
    @Override
// 	@PreAuthorize("hasRole('ROLE_ADMIN')")
       	public void saveFull( Members member) {
  		credentialsService.save(member.getUserCredentials());
  		addressService.save(member.getAddress());
  		memberRepository.save(member);
	}
  	
	public List<Members> findAll() {
		return (List<Members>)memberRepository.findAll();
	}

 	public Members findOne(Long id) {
		return memberRepository.findOne(id);
	}
	
//	public Members findByMemberNumber(int memberId) {
//		return memberRepository.findByMemberNumber(memberId);
//	}
 

}
