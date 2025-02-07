package cokr.oneweeks.guestbook.Controller;

import java.time.LocalDateTime;
import java.util.stream.LongStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cokr.oneweeks.guestbook.domain.SampleDto;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("sample")
public class SampleController {
  @GetMapping({"ex02", "exLink"})
  public void ex02(Model model) {
      model.addAttribute("list", LongStream.rangeClosed(1, 20)
      .mapToObj(i -> SampleDto.builder().sno(i).first("first" + i).last("last" + i).regTime(LocalDateTime.now()).build()));
  }
  
  @GetMapping({"exLayout1", "exLayout2", "exTemplate", "exSidebar"})
  public void exLayout1() {

  }
  
}
