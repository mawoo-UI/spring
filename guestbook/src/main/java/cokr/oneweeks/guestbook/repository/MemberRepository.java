package cokr.oneweeks.guestbook.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import cokr.oneweeks.guestbook.domain.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

  // void save(cokr.oneweeks.guestbook.domain.entity.Member member);

  
}
