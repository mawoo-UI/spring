package cokr.oneweeks.di.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import cokr.oneweeks.di.vo.Post;
import lombok.extern.log4j.Log4j2;
@Log4j2
// @Service("gellery")
@Configuration
public class PostServiceImpleNotice implements PostService{

    @Override
    public List<Post> list() {
        List<Post> list = new ArrayList<>();
        list.add(Post.builder().pno(5L).title("공지사항 제목").writer("작성자").build());
        list.add(Post.builder().pno(6L).title("공지사항 제목").writer("작성자").build());
        return list;
    }

    @Override
    public void write(Post post) {
        log.info(getClass().getSimpleName() + ".writer() call");
    }

    @Bean("notice")
    public PostService postService () {
        return new PostServiceImpleNotice();
    }
}
