package edu.mum.repository;

import edu.mum.domain.Members;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Members, Long> {
//	public Members findByMemberNumber(Integer memberNumber);

    @Query("select m FROM Members m where m.userCredentials.username=:username")
    public Members findMembersByUserName(@Param("username") String username);
}
