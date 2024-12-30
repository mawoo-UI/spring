package cokr.oneweeks.demotest.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@Log4j2
public class CommonController {
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

  @RequestMapping(value = "msg")
  public String msg( @ModelAttribute("msg") String msg, @ModelAttribute("url") @Nullable String url) {
      log.info(msg);
      log.info(url);
      return "common/msg";
  }
  
  
}
