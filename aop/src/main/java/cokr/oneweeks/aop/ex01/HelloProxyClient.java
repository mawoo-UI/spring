package cokr.oneweeks.aop.ex01;

import java.lang.reflect.Proxy;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HelloProxyClient {
    public static void main(String[] args) {
        Class[] arrClasses = {HelloWold.class};
        
        HelloWold helloWold = new HelloWoldImpl();
        HelloWoldHandler<HelloWold> handler = new HelloWoldHandler<>(helloWold);

        helloWold.sayHello("개똥이");
        log.info(helloWold);
        log.info("==============================================");
        HelloWold proxy =
            (HelloWold) Proxy.newProxyInstance(HelloWold.class.getClassLoader(),
            arrClasses, handler);
        proxy.sayHello("새똥이");
        log.info(proxy);
    }
}
