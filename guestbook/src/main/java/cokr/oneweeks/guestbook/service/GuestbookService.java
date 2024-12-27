package cokr.oneweeks.guestbook.service;


import cokr.oneweeks.guestbook.domain.dto.GuestbookDto;
import cokr.oneweeks.guestbook.domain.dto.PageRequestDto;
import cokr.oneweeks.guestbook.domain.dto.PageResultDto;
import cokr.oneweeks.guestbook.domain.entity.Guestbook;


public interface GuestbookService {
  Long write(GuestbookDto dto);
  void modify(GuestbookDto dto);
  void remove(Long gno);

  PageResultDto<GuestbookDto, Guestbook> list(PageRequestDto dto);
  GuestbookDto read(Long gno);
  

          //시그니처 출력
  default Guestbook toEntity(GuestbookDto dto){ //(출구)
    return Guestbook.builder()
    .gno(dto.getGno())
    .title(dto.getTitle())
    .content(dto.getContent())
    .writer(dto.getWriter())
    .build();
  }
  // entity >> dto 변환 메서드 정의
  default GuestbookDto toDto (Guestbook en){
    return GuestbookDto.builder()
    .gno(en.getGno())
    .title(en.getTitle())
    .content(en.getContent())
    .writer(en.getWriter())
    .regDate(en.getRegDate())
    .modDate(en.getModDate())
    .build();
  }

}
