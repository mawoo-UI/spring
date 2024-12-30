package cokr.oneweeks.guestbook.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import cokr.oneweeks.guestbook.domain.entity.Member;


public interface ReplyRepository extends JpaRepository<Member, String>{



  
}
