package cokr.oneweeks.guestbook.service;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import cokr.oneweeks.guestbook.domain.dto.BoardDto;
import cokr.oneweeks.guestbook.domain.dto.PageRequestDto;
import cokr.oneweeks.guestbook.domain.dto.PageResultDto;
import cokr.oneweeks.guestbook.domain.entity.Board;
import cokr.oneweeks.guestbook.repository.BoardRepositoy;
import cokr.oneweeks.guestbook.repository.ReplyRepository;

import jakarta.transaction.Transactional;

@Service
public class BoardServiceImpl implements BoardService{
  @Autowired
  private BoardRepositoy repositoy;
  @Autowired
  private ReplyRepository replyRepository;

  @Override
  public Long register(BoardDto dto) {
    Board board = toEntity(dto);
    repositoy.save(board);
    return board.getBno();
  }

  @Override
  public BoardDto get(Long bno) {
    return toDto((Object[])repositoy.getBoardByBno(bno));
  }

  @Override
  public PageResultDto<BoardDto, Object[]> list(PageRequestDto dto) {
    Pageable pageable = dto.getPageable(Sort.by(Direction.DESC, "bno"));

    Page<Object[]> page = repositoy.getBoardWithReplyCount(pageable);
    Function<Object[], BoardDto> fn = e -> toDto(e);
    PageResultDto<BoardDto, Object[]> resultDto = new PageResultDto<>(page, fn);
    return resultDto;
  }

  @Override
  public void modify(BoardDto dto) {
    repositoy.save(toEntity(dto));
  }

  @Override
  @Transactional
  public void remove(Long bno) {
    replyRepository.deleteByBoardBno(bno);
    repositoy.deleteById(bno);
  }
  
}
