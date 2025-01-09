package cokr.oneweeks.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cokr.oneweeks.club.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
  
  Member findByEmail(String email);
  Member findByEmailAndFromSocial(String email, boolean fromSocial);
  
}
