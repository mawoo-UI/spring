package cokr.oneweeks.guestbook.repository;

<<<<<<< HEAD


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cokr.oneweeks.guestbook.domain.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>{

  // void save(cokr.oneweeks.guestbook.domain.entity.Member member);

  
=======
import org.springframework.data.jpa.repository.JpaRepository;

import cokr.oneweeks.guestbook.domain.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
    
>>>>>>> 2f2f45ebec147e15252a0ada563193b9290f154b
}
