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

import lombok.extern.log4j.Log4j2;
import cokr.oneweeks.guestbook.domain.entity.Guestbook;
import cokr.oneweeks.guestbook.domain.entity.QGuestbook;

@SpringBootTest
@Log4j2
public class GuestbookRepositoryTest {
  @Autowired
  private GuestRepository repository;

  @Test
  public void testExist() {
    log.info(repository);
  }
  
  @Test
  public void testInsert() {
    repository.saveAll(
    IntStream.rangeClosed(1, 300).mapToObj(i->{
      return Guestbook.builder()
      .title("제목"+i)
      .content("내용"+i)
      .writer("작성자"+(i%10))
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
    Long gno = 1L;
   
    Optional<Guestbook> opt = repository.findById(gno);
    // GuestbookEntity modifiedEntity = null;
    opt.ifPresent(entity -> {
      Guestbook modifiedEntity = Guestbook.builder()
      .gno(entity.getGno())
      .title(entity.getTitle())
      .content("변경된 내용 메리크리스마스")
      .writer(entity.getWriter())
      .build();
      repository.save(modifiedEntity);
      
    });
    //  if (!opt.isPresent()) {
      //   return;
      //  }
      
      //  repository.save(entity);
      
      
      //  GuestbookEntity entity = opt.get();
      // repository.save(GuestbookEntity.builder()
    // .gno(1L)
    // .title("수정제목")
    // .content("수정내용")
    // .writer("작성자2")
    // .build());
  
  }
  @Test
  public void testQuerydsl() {
    Guestbook.GuestbookBuilder builder1 =Guestbook.builder();
    Guestbook entity = builder1.build();
    builder1.content("콘텐트");
    builder1.title("타이틀");

    Pageable pageable = PageRequest.of(0,10, Sort.by(Direction.DESC,"gno"));

    //q도메인 객체 취득방식
    QGuestbook qGuestbook = QGuestbook.guestbook;
    
    String keyword = "1";

    //웨어절에 쓰는 평가식쓰기위한 빌더
    BooleanBuilder builder = new BooleanBuilder();
    
    //표현식 /qGuestbookEntity 기반으로 빌더처럼 타이틀
    //wher절 있으면 and로 들어감/없으면 wher 들어감
    BooleanExpression expression = qGuestbook.title.contains(keyword);
    
    //다중행 서브쿼리 쓸때 사용/평가식/any등 쓸때 사용
    builder.and(expression);
    builder.or(qGuestbook.writer.contains(keyword));

    Page<Guestbook> result = repository.findAll(builder,pageable);
    result.forEach(log::info);
  }
}
