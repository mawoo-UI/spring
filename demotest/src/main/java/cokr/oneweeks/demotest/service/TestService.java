package cokr.oneweeks.demotest.service;

import java.util.List;

import cokr.oneweeks.demotest.vo.Post;

public interface TestService {
	List<Post> list();
	
	Post findBy(Long pno);
	
	String now();
	
	int write (Post post);
}
