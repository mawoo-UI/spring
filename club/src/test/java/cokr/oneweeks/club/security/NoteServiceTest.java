package cokr.oneweeks.club.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

// import cokr.oneweeks.club.entity.Member;
import cokr.oneweeks.club.security.dto.NoteDto;
import cokr.oneweeks.club.service.NoteService;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Transactional
@Log4j2
public class NoteServiceTest {
 @Autowired
  private NoteService service;

  @Test
  @Rollback(false)
  public void testWrite() {
    log.info(service.write(NoteDto.builder().title("제목").content("대충내용").writer("user1@oneweeks.cokr").mno(1L).build()));
  }

  @Test
  public void testGet() {
    log.info(service.get(11L));
  }

  @Test
  public void testList(){
    log.info(service.list("user61oneweeks.cokr"));
  }

  @Test
  public void testRead(){
    NoteDto dto = service.get(28L).get();
    dto.getAttachDtos().forEach(log::info);
  }
  // @Test
  // public void testMod(){

  //   log.info(service.modify(null));
  // }
}
