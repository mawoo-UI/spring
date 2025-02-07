package cokr.oneweeks.guestbook.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import cokr.oneweeks.guestbook.domain.dto.GuestbookDto;
import cokr.oneweeks.guestbook.domain.dto.PageRequestDto;
import cokr.oneweeks.guestbook.domain.dto.PageResultDto;
import cokr.oneweeks.guestbook.domain.entity.Guestbook;
import cokr.oneweeks.guestbook.domain.entity.QGuestbook;
import cokr.oneweeks.guestbook.repository.GuestbookRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class GuestbookServiceImpl implements GuestbookService{
  private final GuestbookRepository repository;

  // public List<GuestbookListDto> list() {
  //   return repository.findAll().stream().map(GuestbookListDto::new).toList();
  // }

  public Long write(GuestbookDto dto) {
    Guestbook guestbook = toEntity(dto);
    log.info(guestbook);
    repository.save(guestbook);
    log.info(guestbook);
    return guestbook.getGno();
  }

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
    if(type.contains("C")) {
      conditionalBuilder.or(qGuestbook.content.contains(keyword));
    }
    if(type.contains("W")) {
      conditionalBuilder.or(qGuestbook.writer.contains(keyword));
    }
    booleanBuilder.and(conditionalBuilder);
    return booleanBuilder;
  }
}
