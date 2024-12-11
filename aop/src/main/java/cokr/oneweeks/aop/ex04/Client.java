package cokr.oneweeks.aop.ex04;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import cokr.oneweeks.aop.ex02.adv.Seasoning;
import cokr.oneweeks.aop.ex03.adv.SimpleAdvs;
import lombok.extern.log4j.Log4j2;
@Log4j2
public class Client {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new First());
        factory.addAdvice(new Seasoning());

        ((First)factory.getProxy()).one();
        ((First)factory.getProxy()).two();
        log.info("=========================");
        factory = new ProxyFactory(new First());
        factory.addAdvisor(new DefaultPointcutAdvisor(new SimpleAdvs(), new Seasoning()));
        ((First)factory.getProxy()).one();
        ((First)factory.getProxy()).two();
    }
}
