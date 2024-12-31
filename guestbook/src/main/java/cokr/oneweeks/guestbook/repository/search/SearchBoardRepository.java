package cokr.oneweeks.guestbook.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cokr.oneweeks.guestbook.domain.entity.Board;

public interface SearchBoardRepository {
  Board search1();

  Page<Object[]> searPage(String type, String keword, Pageable pageable);
}
