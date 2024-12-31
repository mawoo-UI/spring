package cokr.oneweeks.guestbook.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cokr.oneweeks.guestbook.domain.dto.BoardDto;
import cokr.oneweeks.guestbook.domain.dto.PageRequestDto;
import cokr.oneweeks.guestbook.domain.dto.PageResultDto;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardServiceTests {
  @Autowired
  public BoardService service;

  @Test
  public void testGet() {
    // Long bno = 3L;
    log.info(service.get(2L));
  }
  @Test
  public void testRegister() {
    //given
    BoardDto dto = BoardDto.builder().title("서비스 테스트 제목").content("내용")
    .memberEmail("user4@a.com").build();

    // when
    Long result = service.register(dto);

    // then
    assertNotNull(result);

    //반환결과의 notnull
  }
  @Test
  public void testList() {
    PageResultDto<BoardDto, Object[]> dto = service.list(PageRequestDto.builder().page(1).size(10).build());
    log.info(dto);
    dto.getDtoList().forEach(log::info);
  }
  @Test
  public void testModify() {
    BoardDto dto = service.get(1L);
    dto.setMemberEmail("user95@a.com");

    service.modify(dto);

  }
 
}
