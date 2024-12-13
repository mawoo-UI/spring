package cokr.oneweeks.member_post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cokr.oneweeks.member_post.dto.ReplyCri;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import cokr.oneweeks.member_post.mapper.PostMapper;
import cokr.oneweeks.member_post.mapper.ReplyMapper;
import cokr.oneweeks.member_post.utils.MybatisInit;
import cokr.oneweeks.member_post.vo.Member;
import cokr.oneweeks.member_post.vo.Reply;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReplyServiceImpl implements ReplyService{
	@Getter
	private static ReplyService instance = new ReplyServiceImpl();
	
	
	@Override
	public int write(Reply reply) {
		try(SqlSession session = MybatisInit.getInstance().sqlSessionFactory().openSession(true)) {
			ReplyMapper mapper = session.getMapper(ReplyMapper.class);
			return mapper.insert(reply);
		
		}
	}

	@Override
	public int modify(Reply reply) {
		try(SqlSession session = MybatisInit.getInstance().sqlSessionFactory().openSession(true)) {
			ReplyMapper mapper = session.getMapper(ReplyMapper.class);
			return mapper.update(reply);
		
		}
	}

	@Override
	public int remove(Long rno) {
		try(SqlSession session = MybatisInit.getInstance().sqlSessionFactory().openSession(true)) {
			ReplyMapper mapper = session.getMapper(ReplyMapper.class);
			return mapper.delete(rno);
			
		}
	}

	@Override
	public int removeAll(Long pno) {
		try(SqlSession session = MybatisInit.getInstance().sqlSessionFactory().openSession(true)) {
			ReplyMapper mapper = session.getMapper(ReplyMapper.class);
			return mapper.deleteAll(pno);
			
			}
		}
	@Override
	public Reply findBy(Long rno) {
		try(SqlSession session = MybatisInit.getInstance().sqlSessionFactory().openSession(true)) {
			ReplyMapper mapper = session.getMapper(ReplyMapper.class);
			return mapper.selectOne(rno);
			
			}
		}

	@Override
	public Map<String,List<Reply>> list(Long pno, ReplyCri cri, Object writer) {
		try(SqlSession session = MybatisInit.getInstance().sqlSessionFactory().openSession(true)) {
			ReplyMapper mapper = session.getMapper(ReplyMapper.class);
			Map<String, List<Reply>> map = new HashMap<>();
			map.put("list",mapper.selectList(pno, cri));
			
			if(writer != null) {
				Reply reply = new Reply();
				reply.setWriter(((Member)writer).getId());
				reply.setPno(pno);
				map.put("myList",mapper.selectListByMe(reply));
			}
			
			return map;
			
		}
	}
	
}