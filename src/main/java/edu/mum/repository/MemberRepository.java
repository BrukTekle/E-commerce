package edu.mum.repository;

import edu.mum.domain.Members;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Members,Long> {
//	public Members findByMemberNumber(Integer memberNumber);
 	}
