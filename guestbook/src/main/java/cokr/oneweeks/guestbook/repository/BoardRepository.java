package cokr.oneweeks.guestbook.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cokr.oneweeks.guestbook.domain.entity.Member;


public interface BoardRepository extends JpaRepository<Member, String>{
  @Query("select b,m from tbl_board b left join member m where b.bno = :bno")
  Object getBoardWithMember(@Param("bno") Long bno);

  @Query("SELECT b,r from tbl_board b\r\n" + //
  "left join tbl_reply r\r\n" + //
  "on b = r.board\r\n" +//
  "where bno = :bno")

  List<Object> getBoardWithReply(@Param("bno") Long bno);

  @Query(value = "select count(r) , b, m \r\n" + //
        "FROM tbl_board b \r\n" + //
        "left join member m \r\n" + //
        "left join tbl_reply r on b = r.board\r\n" + //
        "group by b"
        , countQuery = "select count(b) from tbl_board b") 
        //nativeQuery:sql문장임을 알려줌/jpa의 특징을 많이 없앰
        //database문장을 안탄다는 특징을 없애고 , 최종적으로 안될때 씀
  Page<Object[]> getBoardWithReplyCount(Pageable pageable);

  @Query(value = "select count(r) , b, m \r\n" + //
        "from tbl_board b \r\n" + //
        "left join member m \r\n" + //
        "left join tbl_reply r on b = r.board\r\n" + //
        "where b.bno = :bno\r\n" //
        )
  Object[] getBoardByBno( @Param("bno") Long bno);

}
