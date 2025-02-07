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

  default Guestbook toEntity(GuestbookDto dto) {
    return Guestbook.builder()
    .gno(dto.getGno())
    .title(dto.getTitle())
    .content(dto.getContent())
    .writer(dto.getWriter())
    .build();
  }

  default GuestbookDto toDto(Guestbook guestbook) {
    return GuestbookDto.builder()
    .gno(guestbook.getGno())
    .title(guestbook.getTitle())
    .content(guestbook.getContent())
    .writer(guestbook.getWriter())
    .modDate(guestbook.getModDate())
    .regDate(guestbook.getRegDate())
    .build();
  }
}
