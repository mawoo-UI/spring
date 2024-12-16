package cokr.oneweeks.member_post.mapper;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class PostMapperTests {
  @Autowired
  private PostMapper mapper;

  @Test
  public void testExist() {
    assertNotNull(mapper);
  }
  // @Test
  // public void test() {
  //   Criteria cri;
  //   log.info(cri);
  //   mapper.selectList(new Criteria());
  // }
}
