package cokr.oneweeks.club.service;


import org.springframework.stereotype.Service;

import cokr.oneweeks.club.entity.Likes;
import cokr.oneweeks.club.entity.Member;
import cokr.oneweeks.club.entity.Note;
import cokr.oneweeks.club.entity.dto.LikesDto;

@Service
// @RequiredArgsConstructor
// @Log4j2
public interface LikesService {
  void toggle(LikesDto dto);
  boolean get(LikesDto dto);
  

  default Likes toEntity(LikesDto dto) {
    return Likes.builder().member(Member.builder().mno(dto.getMno()).build()).note(Note.builder().num(dto.getNum()).build()).build();
  }


  default LikesDto toDto(Likes likes){
    return LikesDto.builder()
      .email(likes.getMember().getEmail())
      .mno(likes.getMember().getMno())
      .modDate(likes.getModDate())
      .regDate(likes.getRegDate())
      .num(likes.getNote().getNum())
      .build();
  }

}
