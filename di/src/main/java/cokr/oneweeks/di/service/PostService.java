package cokr.oneweeks.di.service;

import java.util.List;

import cokr.oneweeks.di.vo.Post;

public interface PostService {
    default void write(Post post){
        
    }
    List<Post> list();

}
