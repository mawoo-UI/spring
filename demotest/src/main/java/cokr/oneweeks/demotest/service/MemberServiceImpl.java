package cokr.oneweeks.demotest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import cokr.oneweeks.demotest.dto.Criteria;
import cokr.oneweeks.demotest.mapper.MemberMapper;
import cokr.oneweeks.demotest.vo.Member;

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

	@Override
	public Object list(Criteria cri) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'list'");
	}

	@Override
	public int count(Criteria cri) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'count'");
	}

	@Override
	public Object view(Long pno) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'view'");
	}
	
}
