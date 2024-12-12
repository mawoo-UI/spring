package cokr.oneweeks.jdbc.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cokr.oneweeks.jdbc.vo.Member;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberDaoTests {
  @Autowired
  private MemberDao dao;

  @Test
  public void testGetTime() {
    log.info(dao.getTime());
  }

  @Test
  public void testReqister() {
    Member member = Member.builder().id("abcde").pw("1234").name("스프링부트").build();
    dao.reqister(member);
  }
}