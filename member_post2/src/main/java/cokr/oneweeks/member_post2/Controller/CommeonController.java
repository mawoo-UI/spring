package cokr.oneweeks.member_post2.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@Log4j2
public class CommeonController {
  @GetMapping({"/","/index"})
  public String index() {
      log.info("index controller");
      return "common/index";
  }
  @GetMapping("map")
  @ResponseBody
  public Map<?,?> getMethodName() {
      Map<String, Object> map = new HashMap<>();
      map.put("A", 1);
      return map;
  }
  
}
