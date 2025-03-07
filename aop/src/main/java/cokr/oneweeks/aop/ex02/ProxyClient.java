package cokr.oneweeks.aop.ex02;

import org.springframework.aop.framework.ProxyFactory;

import cokr.oneweeks.aop.ex02.adv.Packaging;
import cokr.oneweeks.aop.ex02.adv.Seasoning;
import cokr.oneweeks.aop.ex02.adv.Sourcing;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProxyClient {
    public static void main(String[] args) {
        Chicken chicken = new Chicken();
        Bbq bbq = new Bbq();

        chicken.cook("후추");
        bbq.cook("간장");

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(chicken);
        factory.addAdvice(new Seasoning());
        factory.addAdvice(new Sourcing());
        factory.addAdvice(new Packaging());

        Chicken chicken2 = (Chicken) factory.getProxy();
        log.info("===================");
        chicken2.cook("파닭");

        factory = new ProxyFactory(bbq);
        factory.addAdvice(new Sourcing());
        factory.addAdvice(new Packaging());

        Bbq bbq2 = (Bbq) factory.getProxy();
        log.info("===================");
        bbq2.cook("간장");
        

    }
}
