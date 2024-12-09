package co.kr.oneweeks.demo.mapper;

import org.apache.ibatis.annotation.Mapper;
import org.apache.ibatis.annotation.Select;


@Mapper
public interface MemberMapper {
    @Select("select now()")
    String selectNow();
    
} 

