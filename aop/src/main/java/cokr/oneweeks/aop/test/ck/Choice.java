package cokr.oneweeks.aop.test.ck;

import org.springframework.aop.AfterAdvice;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Choice implements AfterAdvice {
    // @Override
    public void Choicetast() {
        // String source = invocation.getArguments()[0].toString();
        log.info( "맛을 고른다");
        // Object o = invocation.proceed();
        // log.info(source + "완성.");

        // return;
    }
}
