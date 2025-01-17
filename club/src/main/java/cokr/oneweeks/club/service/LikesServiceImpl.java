package cokr.oneweeks.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cokr.oneweeks.club.entity.composite.LikesId;
import cokr.oneweeks.club.entity.dto.LikesDto;
import cokr.oneweeks.club.repository.LikesRepository;
import cokr.oneweeks.club.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class LikesServiceImpl implements LikesService{
  @Autowired
  private LikesRepository repository;
  @Autowired
  private MemberRepository memberRepository;

  @Override
  public boolean get(LikesDto dto) {
    //검증/ null이 언제 나올 수 있겠다 생각해보기
    if (dto.getMno() == null) {
      Long mno = memberRepository.findByEmail(dto.getEmail()).getMno();
      dto.setMno(mno);
    }
    return repository.findById(new LikesId(dto)).isPresent();

    //isPresent()는 박스개념으로 생각/null이면 false/get 이면예외뜸
    // return false;
  }

  @Override
  public void toggle(LikesDto dto) {
    if (get(dto)) {
      repository.delete(toEntity(dto));   
      
    }
    else{
      repository.save(toEntity(dto));

    }
  }
  
}
