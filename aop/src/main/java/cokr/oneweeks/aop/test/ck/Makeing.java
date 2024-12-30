package cokr.oneweeks.aop.test.ck;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.lang.Nullable;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Makeing implements AfterReturningAdvice {@Override
    public void afterReturning(@Nullable Object returnValue, Method method, Object[] args, @Nullable Object target)
            throws Throwable {
        log.info("그릇에 옮긴다.");
    }
    
}
