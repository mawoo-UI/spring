package cokr.oneweeks.demotest.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cokr.oneweeks.demotest.mapper.PostMapper;
import cokr.oneweeks.demotest.utils.MybatisInit;
import cokr.oneweeks.demotest.vo.Post;

public class TestServiceImpl implements TestService{

	@Override
	public List<Post> list() {
		try(SqlSession session = MybatisInit.getInstance().sqlSessionFactory().openSession()) {
			PostMapper mapper = session.getMapper(PostMapper.class);
			return null;
//			return mapper.selectList();
		}
	}

	@Override
	public Post findBy(Long pno) {
		try(SqlSession session = MybatisInit.getInstance().sqlSessionFactory().openSession()) {
			PostMapper mapper = session.getMapper(PostMapper.class);
			return mapper.selectOne(pno);
		}
	}
	public String now() {
		try(SqlSession session = MybatisInit.getInstance().sqlSessionFactory().openSession()) {
			PostMapper mapper = session.getMapper(PostMapper.class);
			return mapper.now();
		}
	}
	
	@Override
	public int write(Post post) {
		try(SqlSession session = MybatisInit.getInstance().sqlSessionFactory().openSession(true)) {
			PostMapper mapper = session.getMapper(PostMapper.class);
			return mapper.write(post);
		}
	}

	public static void main(String[] args) {
		TestService service = new TestServiceImpl();
//		service.list().forEach(System.out::println);
//		System.out.println(service.findBy(779L));
//		System.out.println(service.now());
		
		// System.out.println(service.write(Post.builder().title("마이바티스 제목").content("내용").writer("abcd").build()));
		
		
	}
}
