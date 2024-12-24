package cokr.oneweeks.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cokr.oneweeks.guestbook.domain.entity.GuestbookEntity;

public interface GuestRepository extends JpaRepository<GuestbookEntity, Long>{
  
}
