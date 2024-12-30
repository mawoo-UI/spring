package cokr.oneweeks.aop.test;

import org.aopalliance.aop.Advice;
import org.springframework.aop.AfterAdvice;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Home implements AfterAdvice{
    public  void cook(String source) {
        log.info("재료를 가져온다.");
    }
}
