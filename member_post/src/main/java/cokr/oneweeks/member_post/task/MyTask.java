package cokr.oneweeks.member_post.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
@EnableScheduling
public class MyTask {


  // @Scheduled(cron = " 0 0 5 * * THU" )//문자열형태로 //매일 자정
  // @Scheduled(cron = " 0 0 0 * * * " )// 매일자정
  // @Scheduled 가 지정된 메서드는 파라미터 x, 반환 x/ 동기방식 어싱크도 가능함(멀티스레드)옵션추가
  @Async
  @Scheduled(cron = " 0/5 * * * * * ")
  public void printTime() {
    log.info(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date()));
      }
}
