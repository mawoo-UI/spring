package cokr.oneweeks.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cokr.oneweeks.club.entity.dto.LikesDto;
import cokr.oneweeks.club.repository.LikesRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class LikesServiceImpl implements LikesService{
  @Autowired
  private LikesRepository repository;
  @Override
  public boolean get(LikesDto dto) {
    repository.findById(null);
    // return repository.findById(null);
    return false;
  }

  @Override
  public void toggle(LikesDto dto) {
    
  }
  
}
