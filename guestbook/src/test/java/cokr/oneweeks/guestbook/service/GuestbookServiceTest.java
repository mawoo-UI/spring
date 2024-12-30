package cokr.oneweeks.guestbook.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import cokr.oneweeks.guestbook.domain.dto.GuestbookDto;
import cokr.oneweeks.guestbook.domain.entity.Guestbook;
import jakarta.transaction.Transactional;
import cokr.oneweeks.guestbook.domain.dto.PageRequestDto;
import cokr.oneweeks.guestbook.domain.dto.PageResultDto;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class GuestbookServiceTest {
  @Autowired
  private GuestbookService service;


  @Test
  @DisplayName("글 작성 서비스 테스트")
  @Transactional
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
  public void testList() {
    PageRequestDto dto = PageRequestDto.builder().page(1).size(10).type("TC").keyword("제목").build();
    PageResultDto<GuestbookDto,Guestbook> resultDto = service.list(dto);
    log.info(resultDto);
    resultDto.getDtoList().forEach(log::info);
  }
  
  @Test
  public void testResultDto() {
    
  }
}
