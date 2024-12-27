package cokr.oneweeks.guestbook.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cokr.oneweeks.guestbook.domain.dto.GuestbookDto;
import cokr.oneweeks.guestbook.domain.entity.Guestbook;
import cokr.oneweeks.guestbook.domain.dto.PageRequestDto;
import cokr.oneweeks.guestbook.domain.dto.PageResultDto;
import cokr.oneweeks.guestbook.domain.entity.Guestbook;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class GuestbookServiceTest {
  @Autowired
  private GuestbookService service;


  @Test
  public void testWrite() {
    GuestbookDto dto = GuestbookDto.builder()
    .title("서비스 테스트 제목")
    .content("서비스 테스트 내용")
    .writer("작성자")
    .build();

    Long gno = service.write(dto);
    assertNotNull(gno);

    

  }
  // @Test
  // public void testList() {
  //   PageResultDto<GuestbookDto,Guestbook> dto = service.list(new PageRequestDto(2,10));
  //   dto.getDtoList().forEach(log::info);
  //   log.info(dto);
  //   dto.getPageList().forEach(log::info);
  // }

  @Test
  public void testResultDto() {
    
  }
}
