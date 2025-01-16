package cokr.oneweeks.club.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class S3ServiceTests {
  @SpringBootTest
  public class S3ServiceTest {
  
      @Autowired
      private S3Service s3Service;
  
      @Test
      public void testS3Client() {
          assertNotNull(s3Service);
      }
  }
  
}
