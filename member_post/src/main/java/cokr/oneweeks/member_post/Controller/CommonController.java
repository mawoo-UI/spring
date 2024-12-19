package cokr.oneweeks.member_post.Controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




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
  public String msg( @ModelAttribute("msg") String msg, @RequestParam("url") @Nullable String url, Model model) throws UnsupportedEncodingException {
      log.info(msg);
      log.info(url);
      if (url != null) {
        int idx = url.indexOf("?url=") + 5;
        log.info(url.substring(0, idx));
        log.info(URLEncoder.encode(url.substring(idx),"utf-8"));
        url = url.substring(0, idx) + URLEncoder.encode(url.substring(idx), "utf-8");
    }
    model.addAttribute("url", url);
      return "common/msg";
  }
  
  
}
