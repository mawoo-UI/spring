package cokr.oneweeks.aop.test;

import org.springframework.aop.framework.ProxyFactory;

import cokr.oneweeks.aop.test.ck.Choice;
import cokr.oneweeks.aop.test.ck.Coocking;
import cokr.oneweeks.aop.test.ck.Makeing;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProxyClient {
    
    public static void main(String[] args) {
        Pencake pencake = new Pencake();
        Home home = new Home();

        pencake.cook("수플레");
        home.cook("초코");

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(pencake);
        factory.addAdvice(new Choice());
        factory.addAdvice(new Makeing());
        factory.addAdvice(new Coocking());
        Pencake pencake2 = (Pencake) factory.getProxy();
        log.info("===============");
        // pencake2.cook("수플레");


        factory = new ProxyFactory(pencake);
        factory.addAdvice(new Choice());
        factory.addAdvice(new Makeing());
        factory.addAdvice(new Coocking());
    }
}
