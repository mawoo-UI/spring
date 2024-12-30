package cokr.oneweeks.demotest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cokr.oneweeks.demotest.dto.Criteria;
import cokr.oneweeks.demotest.vo.Post;

@Mapper
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
