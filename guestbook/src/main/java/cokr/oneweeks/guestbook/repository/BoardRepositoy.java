package cokr.oneweeks.guestbook.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cokr.oneweeks.guestbook.domain.entity.Board;
import cokr.oneweeks.guestbook.repository.search.SearchBoardRepository;

public interface BoardRepositoy extends JpaRepository<Board, Long>, SearchBoardRepository{
  @Query("select b, m from tbl_board b left join member m where b.bno = :bno")
  Object getBoardWithMember(@Param("bno") Long gno);

  @Query("select b, r from tbl_board b left join tbl_reply r on b = r.board where bno = :bno")
  List<Object[]> getBoardWithReply(@Param("bno") Long bno);

  @Query(value = "select count(r), b, m\r\n" + //
        "from tbl_board b\r\n" + //
        "left join member m \r\n" + //
        "left join tbl_reply r on b = r.board\r\n" + //
        "group by b"
  , countQuery = "select count(b) from tbl_board b")
  Page<Object[]> getBoardWithReplyCount(Pageable pageable);

  @Query("select count(r), b, m\r\n" + //
        "from tbl_board b\r\n" + //
        "left join member m\r\n" + //
        "left join tbl_reply r on b = r.board\r\n" + //
        "where bno = :bno")
  Object getBoardByBno(@Param("bno") Long bno);
}
