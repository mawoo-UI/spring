package cokr.oneweeks.member_post.task;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import cokr.oneweeks.member_post.mapper.AttachMapper;
import cokr.oneweeks.member_post.vo.Attach;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@EnableScheduling
@Log4j2
@AllArgsConstructor
public class FileDeleteTask {
  private AttachMapper mapper;

  @Scheduled(cron = "0 0 14 * * *")
  public void deleteFiles() {
    String data = "2024/12/20";

      List<Attach> files = new ArrayList<>(Arrays.asList(new File("c:/upload",data).listFiles())
    //새로운 리스트를만들어야 가변리스트가됨
    .stream()
    .map(Attach::fromFile)
    .toList());


    log.info("==============================================================");
    List<Attach> dbs = new ArrayList<>(mapper.selectListByPath(data));
    List<Attach> thumbs = dbs.stream().filter(Attach::isImage).map(a -> Attach.builder().uuid("t_"+ a.getUuid()).build()).toList();
    

    dbs.addAll(thumbs);

    files.removeAll(dbs);

    files.stream().peek(a->a.setPath(data)).map(Attach::toFile)
    // .forEach(File::delete);
    //bi consumer/두개 인자
    .forEach((file) -> {file.delete();});//반환x/return하는건 괜찮음/근데 안씀
    //file 메서드에 참조됨
    log.info(files.size() + "개의 파일 삭제");

    //  stream

    //  최종연산 
    //  forEach(consumer)는 void반환/메서드 참조도 가능, count() /(스트림의 갯수를 몇개인지 보여줌),int반환
    //  Collect(collectors.toList())

    //  중간연산
    //  filter(predicate)/boolean , map(function), peek(consumer)



    log.info(() -> {return "abcd";});
  }
}
