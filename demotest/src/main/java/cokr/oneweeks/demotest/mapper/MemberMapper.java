package cokr.oneweeks.demotest.mapper;

import org.apache.ibatis.annotations.Mapper;

import cokr.oneweeks.demotest.vo.Member;

@Mapper
public interface MemberMapper {
	int insert(Member member);
	Member selectOne(String id);
}
