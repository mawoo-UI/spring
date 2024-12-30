package cokr.oneweeks.demotest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cokr.oneweeks.demotest.dto.ReplyCri;
import cokr.oneweeks.demotest.vo.Reply;
@Mapper
public interface ReplyMapper {
	int insert(Reply reply);
	int update(Reply reply);
	int delete(Long rno);
	int deleteAll(Long pno);
	
	Reply selectOne(Long rno);
	List<Reply> selectList(@Param("pno") Long pno, @Param("cri") ReplyCri cri);
	List<Reply> selectListByMe(Reply reply);
}
