package co.kr.oneweeks.demo.vo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ComponentScan
public class HelloControllerTest {
    @GetMapping("hello")
    public String hello(Model aaa ) {
        
        aaa.addAttribute("data", "hello!!");
        
        return "hello";
    }

}
