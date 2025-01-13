package cokr.oneweeks.guestbook.repository;

<<<<<<< HEAD

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import cokr.oneweeks.guestbook.domain.entity.Member;
import cokr.oneweeks.guestbook.domain.entity.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long>{
    void deleteByBoardBno(Long bno);


  
=======
import org.springframework.data.jpa.repository.JpaRepository;

import cokr.oneweeks.guestbook.domain.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply,Long>{
    void deleteByBoardBno(Long bno);
>>>>>>> 2f2f45ebec147e15252a0ada563193b9290f154b
}
