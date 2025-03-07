package cokr.oneweeks.aop.ex05;

import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class Config {
    @Autowired
    private Seasoning seasoning;
    @Autowired
    @Qualifier("target")
    private First first;

    @Bean
    public ProxyFactory proxyFactory() {
        return new ProxyFactory();
    }
    @Bean
    public Pointcut pointcut() {
        AspectJExpressionPointcut pc = new AspectJExpressionPointcut();
        pc.setExpression("execution(* one(..))");

        return pc;
    }

    @Bean
    public Advisor advisor() {
        return new DefaultPointcutAdvisor(pointcut(), seasoning);
    }

    @Bean("proxy")
    public First first() {
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(first);
        factory.addAdvisor(advisor());
        return (First) factory.getProxy();
    }
    
}
