package cokr.oneweeks.demotest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import cokr.oneweeks.demotest.dto.ReplyCri;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import cokr.oneweeks.demotest.mapper.PostMapper;
import cokr.oneweeks.demotest.mapper.ReplyMapper;
import cokr.oneweeks.demotest.utils.MybatisInit;
import cokr.oneweeks.demotest.vo.Member;
import cokr.oneweeks.demotest.vo.Reply;

@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService{
	private ReplyMapper mapper;

	
	
	@Override
	public int write(Reply reply) {
			return mapper.insert(reply);
		}

	@Override
	public int modify(Reply reply) {
			return mapper.update(reply);
		
		}

	@Override
	public int remove(Long rno) {
			return mapper.delete(rno);
			
		}

	@Override
	public int removeAll(Long pno) {
			return mapper.deleteAll(pno);
			
			}
	@Override
	public Reply findBy(Long rno) {
			return mapper.selectOne(rno);
			
			}

	@Override
	public Map<String,List<Reply>> list(Long pno, ReplyCri cri, Object writer) {
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
	
