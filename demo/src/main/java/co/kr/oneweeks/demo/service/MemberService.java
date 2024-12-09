package co.kr.oneweeks.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.oneweeks.demo.mapper.MemberMapper;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class MemberService {
    @Autowired
    private MemberMapper mapper;

    public String slectNow() {
        log.error(mapper.selectNow());
        return mapper.selectNow();
    }
}
