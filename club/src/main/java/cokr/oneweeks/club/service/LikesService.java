package cokr.oneweeks.club.service;

import cokr.oneweeks.club.entity.dto.LikesDto;

public interface LikesService {
  void toggle(LikesDto dto);
  boolean get(LikesDto dto);
  
}
