package cokr.oneweeks.guestbook.service;

import java.util.Optional;
// import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import cokr.oneweeks.guestbook.domain.dto.GuestbookDto;
import cokr.oneweeks.guestbook.domain.dto.PageRequestDto;
import cokr.oneweeks.guestbook.domain.dto.PageResultDto;
import cokr.oneweeks.guestbook.domain.entity.Guestbook;
import cokr.oneweeks.guestbook.domain.entity.QGuestbook;
import cokr.oneweeks.guestbook.repository.GuestRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@AllArgsConstructor
public class GuestbookServiceImpl implements GuestbookService {
  private final GuestRepository repository;
  
  
  public Long write(GuestbookDto dto) {
    Guestbook guestbook = toEntity(dto);
    log.info(guestbook);
    repository.save(guestbook);
    log.info(guestbook);
    return guestbook.getGno();
  }

<<<<<<< HEAD
  @Override
  @Transactional
=======
>>>>>>> 2f2f45ebec147e15252a0ada563193b9290f154b
  public void remove(Long gno) {
    repository.deleteById(gno);
  }

  @Override
  public void modify(GuestbookDto dto) {
    repository.save(toEntity(dto));    
  }

  @Override
  public GuestbookDto read(Long gno) {
    // if(!opt.isPresent()) {
      //   return null;
      // }
      // return toDto(opt.get());
    Optional<Guestbook> opt = repository.findById(gno);
    return opt.isPresent() ? toDto(opt.get()) : null;
  }

  @Override
  public PageResultDto<GuestbookDto, Guestbook> list(PageRequestDto dto) {
    Pageable pageable = dto.getPageable(Sort.by(Direction.DESC, "gno"));
    BooleanBuilder booleanBuilder = getSearch(dto);
<<<<<<< HEAD
    
=======
>>>>>>> 2f2f45ebec147e15252a0ada563193b9290f154b
    Page<Guestbook> page = repository.findAll(booleanBuilder, pageable);
    // Function<Guestbook, GuestbookDto> fn = e -> toDto(e);
    PageResultDto<GuestbookDto, Guestbook> resultDto =  new PageResultDto<>(page, e -> toDto(e));
    return resultDto;
  }

  private BooleanBuilder getSearch(PageRequestDto requestDto) {
    String type = requestDto.getType();
    BooleanBuilder booleanBuilder = new BooleanBuilder();
    QGuestbook qGuestbook = QGuestbook.guestbook;
    BooleanExpression expression = qGuestbook.gno.gt(0L);
    booleanBuilder.and(expression);

    if (type == null || type.trim().isEmpty()) {
      return booleanBuilder;
    }

    BooleanBuilder conditionalBuilder = new BooleanBuilder();
    String keyword = requestDto.getKeyword();
    if(type.contains("T")) {
      conditionalBuilder.or(qGuestbook.title.contains(keyword));
    }
<<<<<<< HEAD
    if (type.contains("C")) {
      conditionalBuilder.or(qGuestbook.content.contains(keyword));
    }
    if (type.contains("W")) {
=======
    if(type.contains("C")) {
      conditionalBuilder.or(qGuestbook.content.contains(keyword));
    }
    if(type.contains("W")) {
>>>>>>> 2f2f45ebec147e15252a0ada563193b9290f154b
      conditionalBuilder.or(qGuestbook.writer.contains(keyword));
    }
    booleanBuilder.and(conditionalBuilder);
    return booleanBuilder;
  }
}