package cokr.oneweeks.guestbook.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import cokr.oneweeks.guestbook.domain.entity.Member;
import cokr.oneweeks.guestbook.domain.entity.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long>{
    void deleteByBoardBno(Long bno);


  
}
