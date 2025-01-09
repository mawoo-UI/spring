package cokr.oneweeks.club.security;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class SecurityTests {
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Test
  public void testEncoder () {
    log.info(passwordEncoder);
    log.info(passwordEncoder.getClass().getName());

    String pw = "1234";
    String encoded = passwordEncoder.encode(pw);

    log.info(pw);
    log.info(encoded);

    assertTrue(passwordEncoder.matches(pw, encoded));
    assertTrue(passwordEncoder.matches(pw, encoded));
  }
}
