package cokr.oneweeks.guestbook.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;
@SpringBootTest
@Log4j2
public class BoardServiceTests {
  @Autowired
  public BoardService service;

  @Test
  public void testGet() {
    Long bno = 3L;
    log.info(service.get(bno));
  }
}
