package cokr.oneweeks.guestbook.repository;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;


import cokr.oneweeks.guestbook.domain.entity.Board;
import cokr.oneweeks.guestbook.domain.entity.Reply;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {
    @Autowired
  private ReplyRepository repository;

  @Test
  public void testExist() {
    log.info(repository);
  }
  
  @Test
  @Transactional
  @Rollback(false)
  public void testInsert() {
    IntStream.rangeClosed(1,500).forEach(i -> {
      Reply reply = Reply.builder()
      .text("text" + "1234")
      .replyer("replyer" + i)
      .board(Board.builder().bno(0L+((int) (Math.random() * 99)+1)).build())
      .build();
      // repository.save(reply);
    });
  }
  @Test
  public void testSelectList() {
  }
  @Test
  public void testSelectOne() {
    // Reply reply = repository.findById(1L).orElse(null);
    // log.info(reply);
    //댓글의 작성글의 작성자 이름
    // log.info(reply.getBoard().getMember().getName());
  }
  @Test
  public void testModify() {
   
    
    
  
  }
  @Test
  public void testQuerydsl() {
 
  }
  @Test
  public void testDelete() {
    
  }
  @Test
  @Transactional
  @Rollback(false)
  public void testDeleteBno() {
    repository.deleteByBoardBno(2L);
  }
}
