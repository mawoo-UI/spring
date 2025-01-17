package cokr.oneweeks.club.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cokr.oneweeks.club.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long>{
  Note findByNum(Long num);

  List<Note> findByMemberMno(Long mno);

  List<Note> findByMemberEmail(String email);
  
  @Query("select n, count(distinct l) as likescnt, count(distinct a) as attachcnt \r\n "+
   "from tbl_note n left join tbl_likes l on l.note.num = n.num left join tbl_attach a on a.note.num = n.num \r\n" +
   "where n.member.email = :email group by n")
  // @Query(value = "SELECT n.*, count (DISTINCT 1.note_num, l.member_mno) replycnt, COUNT(DISTINCT uuid) attachcnt FROM tbl_note n \r\n" +//
  // "left join tbl_member m ON m.mno = n.member_mno and email = \r\n "
  // left join tbl_likes l on l.note_num = n.num
  // left join tbl_attach a on a.note_num = n.num
  // WHERE m.email = 'user100oneweeks.cokr' 
  // group by n.num;)
  List<Object[]> findByNotes(@Param("email") String email);
  
  @Query("select n, count(distinct l) as likescnt, count(distinct a) as attachcnt \r\n "+
   "from tbl_note n left join tbl_likes l on l.note.num = n.num left join tbl_attach a on a.note.num = n.num \r\n" +
   "group by n.num")
  // @Query(value = "SELECT n.*, count (DISTINCT 1.note_num, l.member_mno) replycnt, COUNT(DISTINCT uuid) attachcnt FROM tbl_note n \r\n" +//
  // "left join tbl_member m ON m.mno = n.member_mno and email = \r\n "
  // left join tbl_likes l on l.note_num = n.num
  // left join tbl_attach a on a.note_num = n.num
  // WHERE m.email = 'user100oneweeks.cokr' 
  // group by n.num;)
  List<Object[]> findByNotes();
}


