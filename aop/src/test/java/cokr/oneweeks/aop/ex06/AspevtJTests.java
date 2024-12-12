package cokr.oneweeks.aop.ex06;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cokr.oneweeks.aop.ex06.MyBean;

@SpringBootTest
public class AspevtJTests {
    @Autowired
    private MyBean bean;

    @Test
    public void testBean() {
        bean.run();
    }
}
