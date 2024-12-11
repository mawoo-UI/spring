package cokr.oneweeks.aop.ex01;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HelloWoldImpl implements HelloWold{
    
    @Override
    public void sayHello(String msg) {
        log.info(msg + " :: hello World");
    }
}
