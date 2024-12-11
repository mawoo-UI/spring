package cokr.oneweeks.di.service;

import java.util.stream.Stream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cokr.oneweeks.di.vo.Post;

@Configuration
public class MyClass {

    @Bean
    public PostService postService() {

        return () ->  Stream.of(Post.builder().pno(7L).title("익명").build()).toList();
    }
}
