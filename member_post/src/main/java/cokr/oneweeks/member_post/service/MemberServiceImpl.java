package cokr.oneweeks.member_post.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import cokr.oneweeks.member_post.mapper.MemberMapper;
import cokr.oneweeks.member_post.vo.Member;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{
	public MemberMapper mapper;

	@Override
	public int register(Member member) {
		return mapper.insert(member);
	}

	@Override
	public Member findBy(String id) {
			return mapper.selectOne(id);
		}

	@Override
	public boolean login(String id, String pw) {
		Member m = findBy(id);
		return m != null && m.getPw().equals(pw);
	}

	@Override
	public List<Member> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modify(Member member) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
