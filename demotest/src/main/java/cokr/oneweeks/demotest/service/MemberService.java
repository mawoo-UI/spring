package cokr.oneweeks.demotest.service;

import java.util.List;

import cokr.oneweeks.demotest.dto.Criteria;
import cokr.oneweeks.demotest.vo.Member;

// import  cokr.oneweeks.member_post.Member;

public interface MemberService {
	//회원 가입
	int register(Member member);
	
	// 단일 조회
	Member findBy(String id);
	
	//로그인
	boolean login(String id, String pw);
	
	//회원 목록
	List<Member> list();
	
	// 회원 탈퇴
	boolean remove(String id);
	
	//회원 정보 수정
	boolean modify(Member member);

    Object list(Criteria cri);

    int count(Criteria cri);

    Object view(Long pno);
	
}
