package co.kr.oneweeks.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
class HelloController {
    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World";
    }
}