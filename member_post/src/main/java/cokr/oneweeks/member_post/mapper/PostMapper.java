package cokr.oneweeks.member_post.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cokr.oneweeks.member_post.dto.Criteria;
import cokr.oneweeks.member_post.vo.Post;


public interface PostMapper {
	int insert(Post post);
	
	Post selectOne(Long pno);
	
	int getCount(Criteria cri);
	
	List<Post> selectList(Criteria cri);
	
	int update(Post post);
	int increaseViewCount (Long pno);
	int delete(Long pno);

	@Select("select now()")
	String now();
	
	int write(Post post);
}
