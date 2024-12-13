package cokr.oneweeks.jdbc.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.Map;

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

  // @Test
  // public void testList() {
  //   dao.selectlList().forEach(map -> log.info(map.get("id")));
  // }

  @Test
  public void testList() {
    Object o = "abcd";


    dao.selectlList().forEach(map -> {
      if (map instanceof Map) {
        Object id = ((Map)map).get("id");
        if (id instanceof String) {
          String idStr =(String) id;
        }
      }
    });
  }
  
  @Test
  public void testOne() {
    log.info(dao.selectOne("abcd"));
  }

  @Test
  public void testObject() {
    Object o = "1234";
    try {
      String s = (String)o;
      Long l = Long.valueOf(s);
      log.info(l + 2000);
    }
    catch(ClassCastException e) {
      log.info("cast 과정의 문제");
    }
    catch(NumberFormatException e) {
      log.info("문자열이지만 숫자로 구성되어 있지 않음");
    }
    
  }
    @Test
    public void testUpdate() {
      Member member = dao.selectOne("abcd") ;
      log.info(member);
      member.setRoad_addr("디지털로 306");
      member.setDetail_addr("2층 더 좋은 아카데미");
      member.setEmail("dreamfull7@nate.com");
      int result = dao.update(member);
      //result쪽 sql 오류
      assertEquals(1, result);

      log.info(dao.selectOne("abcd"));
    }
    @Test
    public void testDelete() {
      assertEquals(1, dao.delete("abcde"));
    }
}