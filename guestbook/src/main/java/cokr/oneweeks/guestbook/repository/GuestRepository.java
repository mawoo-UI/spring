package cokr.oneweeks.guestbook.repository;


import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import cokr.oneweeks.guestbook.domain.entity.GuestbookEntity;

public interface GuestRepository extends JpaRepository<GuestbookEntity, Long> {
// ,QuerydslPredicateExecutor<GuestbookEntity>{
//  @Modifying
//  @Query("") 
// List<GuestbookEntity> findBy
}
