package cokr.oneweeks.guestbook.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cokr.oneweeks.guestbook.domain.entity.Board;

public interface SearchBoardRepository {
<<<<<<< HEAD
  Board search1();

  Page<Object[]> searPage(String type, String keword, Pageable pageable);
}
=======
    Board search1();
  
    Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
  }
  
>>>>>>> 2f2f45ebec147e15252a0ada563193b9290f154b
