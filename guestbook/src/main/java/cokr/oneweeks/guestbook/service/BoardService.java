package cokr.oneweeks.guestbook.service;
import java.time.LocalDate;

import cokr.oneweeks.guestbook.domain.dto.BoardDto;
import cokr.oneweeks.guestbook.domain.dto.GuestbookDto;
import cokr.oneweeks.guestbook.domain.dto.PageRequestDto;
import cokr.oneweeks.guestbook.domain.dto.PageResultDto;
import cokr.oneweeks.guestbook.domain.entity.Board;
import cokr.oneweeks.guestbook.domain.entity.Guestbook;
import cokr.oneweeks.guestbook.domain.entity.Member;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.ManyToOne;

public interface BoardService {
  default Board toEntity (BoardDto dto) {
    return Board.builder()
    .bno(dto.getBno())
    .title(dto.getTitle())
    .content(dto.getContent())
    .member(Member.builder().email(dto.getMemberEmail()).name(dto.getMemberName()).build())
    .build();
  }
  default BoardDto toDto(Object[] arr) {
    if (arr == null ) return null;

    BoardDto.BoardDtoBuilder builder = BoardDto.builder();
    boolean containBoard = false;
    for(Object o : arr) {
      if (o == arr) continue;
      Class<?> cls = o.getClass();
      if (cls == long.class || cls == Long.class) {
        builder.replyCnt(Integer.parseInt(o.toString()));
      }
      else if(cls == Member.class) {
        builder.memberEmail(((Member)o).getEmail());
        builder.memberEmail(((Member)o).getName());

      }
      else if(cls == Board.class) {
        containBoard = true;
        Board b = (Board)o;
        builder.bno(b.getBno());
        builder.title(b.getTitle());
        builder.content(b.getContent());
        builder.regDate(b.getRegDate());
        builder.modDate(b.getModDate());
      }
    }
    
    return containBoard ? builder.build() : null;
    

  }
  Long register(BoardDto dto);
  BoardDto get(Long bno);


  PageResultDto<BoardDto, Object[]> list(PageRequestDto dto);
  void modify(BoardDto dto);
  void remove(Long bno);
}
