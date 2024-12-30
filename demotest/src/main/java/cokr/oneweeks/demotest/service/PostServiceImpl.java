package cokr.oneweeks.demotest.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cokr.oneweeks.demotest.dto.Criteria;
import cokr.oneweeks.demotest.mapper.AttachMapper;
import cokr.oneweeks.demotest.mapper.PostMapper;
import cokr.oneweeks.demotest.mapper.ReplyMapper;
import cokr.oneweeks.demotest.utils.MybatisInit;
import cokr.oneweeks.demotest.vo.Attach;
import cokr.oneweeks.demotest.vo.Post;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Transactional
@Log4j2
public class PostServiceImpl implements PostService {
	private PostMapper mapper;
	private AttachMapper attachMapper;
	private ReplyMapper replyMapper;
	
	@Override
	public int write(Post post) {
			mapper.insert(post);
			
			// post.getAttachs().forEach(a -> {
			// 	a.setPno(post.getPno());
			// 	attachMapper.insert(a);
			// });
			
			return 0;
	}

	@Override
	public int modify(Post post) {
			return mapper.update(post);
		}

	@Override
	public int remove(Long pno) {
			attachMapper.delete(pno);
			replyMapper.deleteAll(pno);
			return mapper.delete(pno);
	}

	@Override
	public Post findBy(Long pno) {
			return mapper.selectOne(pno);
		}

	@Override
	public List<Post> list(Criteria cri) {
		log.info("serviceeeeeeee");
		return mapper.selectList(cri);
	}
	
	@Override
	public int count(Criteria cri) {
	
			return mapper.getCount(cri);
		}

	@Override
	public Post view(Long pno) {
			mapper.increaseViewCount(pno);
			Post post = mapper.selectOne(pno);
			// post.setAttachs(attachMapper.selectList(pno));
			return post;
	
	}

}
