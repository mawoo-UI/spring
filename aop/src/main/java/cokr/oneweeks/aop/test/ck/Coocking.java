package cokr.oneweeks.aop.test.ck;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Coocking implements MethodBeforeAdvice {@Override
    public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
        log.info("팬케익을 굽는다.");        
    }
    
}
