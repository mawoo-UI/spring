package cokr.oneweeks.guestbook.service;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.stereotype.Service;

import cokr.oneweeks.guestbook.domain.dto.BoardDto;
import cokr.oneweeks.guestbook.domain.entity.Board;
import cokr.oneweeks.guestbook.repository.BoardRepositoy;
import cokr.oneweeks.guestbook.repository.ReplyRepository;
import cokr.oneweeks.guestbook.domain.dto.PageRequestDto;
import cokr.oneweeks.guestbook.domain.dto.PageResultDto;

>>>>>>> 2f2f45ebec147e15252a0ada563193b9290f154b
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
<<<<<<< HEAD
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;

import lombok.Data;
import cokr.oneweeks.guestbook.domain.dto.BoardDto;
import cokr.oneweeks.guestbook.domain.dto.GuestbookDto;
import cokr.oneweeks.guestbook.domain.dto.PageRequestDto;
import cokr.oneweeks.guestbook.domain.dto.PageResultDto;
import cokr.oneweeks.guestbook.domain.entity.Board;
import cokr.oneweeks.guestbook.domain.entity.Guestbook;
import cokr.oneweeks.guestbook.repository.BoardRepository;
import cokr.oneweeks.guestbook.repository.ReplyRepository;
import jakarta.transaction.Transactional;

@Service
@Data
public class BoardServiceImpl implements BoardService{
  @Autowired
  private BoardRepository repository;
  @Autowired
  private ReplyRepository replyRepository;

  @Override
  public BoardDto get(Long bno) {

    //배열필요
    //반환타입을 오브젝트로 고정
    //형변환
    //퀘스트호출(같은 참조자료끼리 가능)
    //getClass, valueOf(오브젝트라서)toString사용/
    //파스 사용

    return toDto(repository.getBoardByBno(bno));
  }

  @Override
  public Long register(BoardDto dto) {
    Board board = toEntity(dto);
    // repository.save(board);
    return board.getBno();
  }

  @Override
  public PageResultDto<BoardDto, Object[]> list(PageRequestDto dto) {
    Pageable pageable = dto.getPageable(Sort.by(Direction.DESC, "bno"));

    // Page<Object[]> page = repository.getBoardWithReplyCount(pageable);
    Page<Object[]> page = repository.searPage(dto.getType(), dto.getKeyword(), pageable);
    Function<Object[], BoardDto> fn = e -> toDto(e);
    PageResultDto<BoardDto, Object[]> resultDto =  new PageResultDto<>(page, fn);
    return resultDto;
  }

  @Override
  public void modify(BoardDto dto) {
    repository.save(toEntity(dto));
  }

  @Override
  @Transactional
  public void remove(Long bno) {
    replyRepository.deleteByBoardBno(bno);   
    repository.deleteById(bno);
  }
  
}
=======

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
>>>>>>> 2f2f45ebec147e15252a0ada563193b9290f154b
