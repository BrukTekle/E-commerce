package edu.mum.service;

import java.util.List;

import edu.mum.domain.Members;

public interface MemberService {

	public void save(Members member);
    	public void saveFull( Members member);

	public List<Members> findAll();
 	public Members findOne(Long id);
//	public Members findByMemberNumber(int memberId);
 
	
}
