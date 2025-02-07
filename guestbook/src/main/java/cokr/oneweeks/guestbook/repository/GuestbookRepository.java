package cokr.oneweeks.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import cokr.oneweeks.guestbook.domain.entity.Guestbook;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long>
, QuerydslPredicateExecutor<Guestbook>
{
  
}
