package cokr.oneweeks.guestbook.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import cokr.oneweeks.guestbook.domain.entity.Member;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {
  @Autowired
  private MemberRepository repository;

  @Test
  public void testExist() {
    log.info(repository);
  }

  @Test
  @Transactional
  @Rollback(false)
  public void testInsert() {
    IntStream.rangeClosed(2, 100).forEach(i -> {
      Member member = Member.builder()
      .email("user" + i + "@a.com")
      .password("1234")
      .name("쿠키" + i)
      .build();
      repository.save(member);
    });
  }

  @Test
  public void testSelectList() {
    repository.findAll().forEach(log::info);
  }

  @Test
  public void testSelectOne() {
    log.info(repository.findById("user10@a.com"));
  }
}
