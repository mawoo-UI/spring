package cokr.oneweeks.guestbook.repository;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import cokr.oneweeks.guestbook.domain.entity.Guestbook;
import cokr.oneweeks.guestbook.domain.entity.Member;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {
    @Autowired
  private MemberRepository repository;

  @Test
  @Transactional
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
  public void testInsert() {
    IntStream.rangeClosed(2,100).forEach(i -> {
      Member member = Member.builder()
      .email("user" + i + "@a.com")
      .password("1234")
      .name("새똥이")
      .build();
      // repository.save(member);
    });
    
  }
  @Test
  public void testSelectList() {
  }
  @Test
  public void testSelectOne() {
  }
  @Test
  public void testModify() {
   
    
    
  
  }
  @Test
  public void testQuerydsl() {
 
  }
}
