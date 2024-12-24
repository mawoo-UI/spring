package cokr.oneweeks.guestbook.service;

import java.util.List;


import cokr.oneweeks.guestbook.domain.dto.GuestbookListDto;
import cokr.oneweeks.guestbook.domain.dto.GuestbookModifyDto;
import cokr.oneweeks.guestbook.domain.dto.GuestbookViewDto;
import cokr.oneweeks.guestbook.domain.dto.GuestbookWriteDto;


public interface GuestbookService {
  void writer(GuestbookWriteDto dto);
  void modify(GuestbookModifyDto dto);
  void remove(Long gno);

  List<GuestbookListDto> list();
  GuestbookViewDto get(Long gno);
}
