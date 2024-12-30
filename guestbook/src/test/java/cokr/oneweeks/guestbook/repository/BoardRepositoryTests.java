package cokr.oneweeks.guestbook.repository;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;


import cokr.oneweeks.guestbook.domain.entity.Board;
import cokr.oneweeks.guestbook.domain.entity.Member;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {
    @Autowired
  private BoardRepository repository;

  @Test
  // @Transactional
  // @Rollback(false)
  public void testExist() {
    // Member member = Member.builder()
    // .email("a@b.c")
    // .password("1234")
    // .name("새똥이")
    // .build();
    // repository.save(member);

  }
  
  @Test
  @Transactional
  @Rollback(false)
  public void testInsert() {
    Board board = Board.builder().title("새똥이글").content("새똥이 내용")
    .member(Member.builder().email("a@b.c").build())
    .build();
    // repository.save(board);
    // IntStream.rangeClosed(2,100).forEach(i -> {
    //   Board board = Board.builder()
    //   .title("title" +i)
    //   .content("content"+"1234")
    //   .member(Member.builder().email("user"+ i + "@a.com").build())
    //   .build();
    //   repository.save(board);
    // });
  }
  @Test
  public void testSelectList() {
  }
  @Test
  @Transactional
  public void testSelectOne() {
    // Board board = repository.findById(2L).get();
    // log.info(board);
    
    // log.info(board.getMember());
  }

  @Test
  public void testGetBoardWithMember() {
    Object result = repository.getBoardWithMember(2L);
    Object[] arr = (Object[]) result;
    log.info(Arrays.toString(arr));
  }
  @Test
  public void testGetBoardByBno() {
    Object[] arr = repository.getBoardByBno(2L);
    log.info(Arrays.toString(arr));
  }
  @Test
  public void testGetBoardWithWithReply() {
    List<Object[]> result = repository.getBoardWithReply(3L);
    result.forEach(arr -> log.info(Arrays.toString(arr)));
  }
  @Test
  public void testGetBoardWithReplyCount() {
    Pageable pageable = PageRequest.of(1, 10, Sort.by(Direction.DESC, "bno"));
    Page<Object[]> result = repository.getBoardWithReplyCount(pageable);
    result.forEach(arr -> log.info(Arrays.toString(arr)));
  }


  @Test
  public void testModify() {
   
    
    
  
  }
  @Test
  public void testQuerydsl() {
 
  }
}
