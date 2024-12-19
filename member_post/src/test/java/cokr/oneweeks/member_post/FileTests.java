package cokr.oneweeks.member_post;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;
@Log4j2
@SpringBootTest
public class FileTests {
  @Test
  public void testDeleteFiles() {
    File file = new File("c:/upload/2024/12/19", "8e9237df-3f73-4925-b387-50a56d391da7.png");
    file.delete();
  }
  @Test
  public void testListFiles() {
    File file = new File("c:/upload/2024/12/19");
    log.info(file.isDirectory());
    log.info(file.isFile());

    new ArrayList<>(Arrays.asList(file.listFiles(pathname -> pathname.getName().endsWith("jpg")))).forEach(log::info);
  }
}
