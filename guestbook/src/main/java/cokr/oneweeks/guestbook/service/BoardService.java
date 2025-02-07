package cokr.oneweeks.guestbook.service;

import cokr.oneweeks.guestbook.domain.dto.BoardDto;
import cokr.oneweeks.guestbook.domain.dto.PageRequestDto;
import cokr.oneweeks.guestbook.domain.dto.PageResultDto;
import cokr.oneweeks.guestbook.domain.entity.Board;
import cokr.oneweeks.guestbook.domain.entity.Member;

public interface BoardService {
  default Board toEntity(BoardDto dto) {
    return Board.builder()
    .bno(dto.getBno())
    .title(dto.getTitle())
    .content(dto.getContent())
    .member(Member.builder().email(dto.getMemberEmail()).name(dto.getMemberName()).build())
    .build();
  }

  default BoardDto toDto(Object[] arr) {
    if(arr == null) return null;

    BoardDto.BoardDtoBuilder builder = BoardDto.builder();
    boolean flag = false;
    for(Object o : arr) {
      if(o == null) continue;
      Class<?> cls = o.getClass();

      if(cls == long.class || cls == Long.class) {

        builder.replyCnt(Long.valueOf(o.toString()));

      } else if(cls == Member.class) {

        builder.memberEmail(((Member) o).getEmail());
        builder.memberName(((Member) o).getName());

      } else if(cls == Board.class) {
        flag = true;
        Board board = (Board) o;
        builder.bno(board.getBno());
        builder.title(board.getTitle());
        builder.content(board.getContent());
        builder.regDate(board.getRegDate());
        builder.modDate(board.getModDate());

      }
    }
    return flag ? builder.build() : null;
  }

  Long register(BoardDto dto);

  BoardDto get(Long bno);

  PageResultDto<BoardDto, Object[]> list(PageRequestDto dto);
  void modify(BoardDto dto);
  void remove(Long bno);
}
