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

import cokr.oneweeks.guestbook.domain.entity.Guestbook;
import cokr.oneweeks.guestbook.domain.entity.QGuestbook;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;


@SpringBootTest
@Log4j2
public class GuestbookRepositoryTests {
  @Autowired
  private GuestbookRepository repository;

  @Test
  public void testExist() {
    log.info(repository);
  }

  @Test
  @Transactional
  public void testInsert() {
    repository.saveAll(
      IntStream.rangeClosed(1, 300).mapToObj(i -> {
        return Guestbook.builder()
        .title("제목" + i)
        .content("내용" + i)
        .writer("작성자" + (i % 10))
        .build();
      }).toList()
    );
  }

  @Test
  public void testSelectList() {
    repository.findAll().forEach(log::info);
  }

  @Test
  public void testSelectOne() {
    log.info(repository.findById(1L));
  }

  @Test
  public void testModify() {

    Optional<Guestbook> entity = repository.findById(1L);

    // 1
    entity.ifPresent(e -> {
      repository.save(Guestbook.builder()
      .gno(entity.get().getGno())
      .title("제목수정")
      .content("수정1")
      .writer(entity.get().getWriter())
      .build());
    });

    // 2
    if(!entity.isPresent()) {
      return;
    }
    
    repository.save(Guestbook.builder()
    .gno(entity.get().getGno())
    .title("제목수정")
    .content("수정1")
    .writer(entity.get().getWriter())
    .build());
    log.info(repository.findById(1L));  

    // repository.save(GuestbookEntity.builder()
    //   .gno(entity.get().getGno())
    //   .content("수정1")
    //   .writer(entity.get().getWriter())
    //   .build());
    // log.info(repository.findById(1L));
  }

  @Test
  public void testQuerydsl() {
    Pageable pageable = PageRequest.of(0, 10, Sort.by(Direction.DESC, "gno"));

    // Q도메인 관련 객체를 취득하는 방식
    QGuestbook qGuestbookEntity = QGuestbook.guestbook;

    String keyword = "1";

    // where절의 평가식을 활용하기 위한 빌더
    BooleanBuilder builder = new BooleanBuilder();

    // 실제 where 절에 들어가는 평가식 
    BooleanExpression expression = qGuestbookEntity.title.contains(keyword);

    // where절의 and, or 등 다중 행 연산에 대한 것들
    builder.and(expression);
    builder.or(qGuestbookEntity.writer.contains(keyword));

    Page<Guestbook> result = repository.findAll(builder, pageable);
    result.forEach(log::info);
  }
}
