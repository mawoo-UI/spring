package cokr.oneweeks.aop.ex03;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MartImpl implements Mart {
    
    @Override
    public void getproduct(String name) {
        log.info("상품명 ::" + name);
        // throw new RuntimeException("예외발생");
    }
}
