package cokr.oneweeks.di.test;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import cokr.oneweeks.di.service.PostService;
import cokr.oneweeks.di.service.PostServiceImplNomal;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PostTest {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(PostTest.class);
        ApplicationContext ctx = application.run(args);
        PostService service = ctx.getBean(PostServiceImplNomal.class);
        service.list().forEach(log::info);
    }
}
