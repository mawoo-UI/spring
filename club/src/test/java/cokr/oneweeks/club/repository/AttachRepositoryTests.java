package cokr.oneweeks.club.repository;

import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import cokr.oneweeks.club.entity.Attach;
import cokr.oneweeks.club.entity.Member;
import cokr.oneweeks.club.entity.Note;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class AttachRepositoryTests {
  
  @Autowired
  private AttachRepository repository;

  @Test
  @Transactional
  @Rollback(false)
  public void testInsert() {
    for(int i = 0; i< 5; i++) {

      Attach attach = Attach.builder()
      .origin("1.png")
      .note(Note.builder().num(1L).build())
      .build();

      repository.save(attach);
    }
  }

  @Test
  @Transactional
  public void testFindByEmail() {

  }

  public void testMember() {

  }

}
