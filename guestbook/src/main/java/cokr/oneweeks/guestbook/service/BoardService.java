package cokr.oneweeks.guestbook.service;
import java.time.LocalDate;

import cokr.oneweeks.guestbook.domain.dto.BoardDto;
import cokr.oneweeks.guestbook.domain.entity.Board;
import cokr.oneweeks.guestbook.domain.entity.Member;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

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
    if (arr == null) return null;
    BoardDto.BoardDtoBuilder builder = BoardDto.builder();
    for(Object o : arr) {
      Class<?> cls = o.getClass();
      if (cls == int.class || cls == Integer.class) {
        builder.replyCnt(Integer.parseInt(o.toString()));
      }
      else if(cls == Member.class) {
        builder.memberEmail(((Member)o).getEmail());
        builder.memberEmail(((Member)o).getName());

      }
      else if(cls == Board.class) {
        Board b = (Board)o;
        builder.bno(b.getBno());
        builder.title(b.getTitle());
        builder.content(b.getContent());
        builder.regDate(b.getRegDate());
        builder.modDate(b.getModDate());
        
      }
    }
    
    return builder.build();


  }
  Long register(BoardDto dto);

  BoardDto get(Long bno);
}
