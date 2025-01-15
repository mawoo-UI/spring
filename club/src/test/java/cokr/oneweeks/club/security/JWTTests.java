package cokr.oneweeks.club.security;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import cokr.oneweeks.club.security.util.JWTUtil;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class JWTTests {
  
  private JWTUtil jwtUtil;

  @BeforeEach
  @Test
  public void testBefore() {
    jwtUtil = new JWTUtil();
  }


  @Test
  public void testCreate() throws Exception{
    String email = "user1@oneweeks.cokr";
    String str = jwtUtil.generateToken(email);
    log.info(str);
  }

  @Test
  public void testExtract() throws Exception{
    String email = "user1oneweeks.cokr";
    String token = jwtUtil.generateToken(email);

    Thread.sleep(5000);

    String resultEmail = jwtUtil.validateExtract(token);

    log.info(resultEmail);
    
    assertEquals(email, resultEmail);
  }
}
