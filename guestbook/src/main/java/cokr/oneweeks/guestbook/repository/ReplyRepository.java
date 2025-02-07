package cokr.oneweeks.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cokr.oneweeks.guestbook.domain.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long>{
  void deleteByBoardBno(Long bno);
}
