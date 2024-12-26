package cokr.oneweeks.guestbook.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import cokr.oneweeks.guestbook.domain.entity.Guestbook;

public interface GuestRepository extends JpaRepository<Guestbook, Long> 
, QuerydslPredicateExecutor<Guestbook>
{
//  @Modifying
//  @Query("") 
// List<GuestbookEntity> findBy
}
