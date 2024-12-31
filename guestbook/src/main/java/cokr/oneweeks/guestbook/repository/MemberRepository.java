package cokr.oneweeks.guestbook.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cokr.oneweeks.guestbook.domain.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>{

  // void save(cokr.oneweeks.guestbook.domain.entity.Member member);

  
}
