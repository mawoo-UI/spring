package cokr.oneweeks.club.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import cokr.oneweeks.club.entity.dto.NoteDto;
import lombok.extern.log4j.Log4j2;


@SpringBootTest
@Transactional
@Log4j2
public class NoteServiceTests {
  @Autowired
  private NoteService service;

  // @Test
  // @Rollback(false)
  // public void testWrite() {
  //   service.write(NoteDto.builder().title("서비스 제목").content("서비스 내용").mno(10L).build());
  // }
  @Test
  public void testRead() {
    NoteDto dto = service.get(12L).get();
    dto.getAttachDtos().forEach(log::info);
  }
}
