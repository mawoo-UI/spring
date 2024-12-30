package cokr.oneweeks.guestbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import cokr.oneweeks.guestbook.domain.dto.BoardDto;
import cokr.oneweeks.guestbook.domain.entity.Board;
import cokr.oneweeks.guestbook.repository.BoardRepository;

@Service
@Data
public class BoardServiceImpl implements BoardService{
  @Autowired
  private BoardRepository repository;


  @Override
  public BoardDto get(Long bno) {
    return toDto(repository.getBoardByBno(bno));
  }

  @Override
  public Long register(BoardDto dto) {
    Board board = toEntity(dto);
    repository.save(board);
    return board.getBno();
  }
  
}
