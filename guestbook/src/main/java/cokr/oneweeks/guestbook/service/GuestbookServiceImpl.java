package cokr.oneweeks.guestbook.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import cokr.oneweeks.guestbook.domain.dto.GuestbookDto;
import cokr.oneweeks.guestbook.domain.dto.GuestbookModifyDto;
import cokr.oneweeks.guestbook.domain.dto.GuestbookViewDto;
import cokr.oneweeks.guestbook.domain.dto.PageRequestDto;
import cokr.oneweeks.guestbook.domain.dto.PageResultDto;
import cokr.oneweeks.guestbook.domain.entity.Guestbook;
import cokr.oneweeks.guestbook.repository.GuestRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@AllArgsConstructor
public class GuestbookServiceImpl implements GuestbookService {
  private GuestRepository repository;
  

  @Override
  public GuestbookViewDto get(Long gno) {
    Optional<Guestbook> opt = repository.findById(gno);
    if (!opt.isPresent()) {
      return null;
    }
    return new GuestbookViewDto(opt.get());
  }

  // @Override
  // public List<GuestbookListDto> list() {
  //   return repository.findAll().stream().map(GuestbookListDto::new).toList();
  // }

  @Override
  public void modify(GuestbookModifyDto dto) {
    repository.save(dto.toEntity());    
  }

  @Override
  public void remove(Long gno) {
    repository.deleteById(gno);
  }

  @Override
  public Long writer(GuestbookDto dto) {
    Guestbook guestbook = toEntity(dto);
    log.info(guestbook);
    repository.save(guestbook);
    log.info(guestbook);
    return guestbook.getGno();
  }

  @Override
  public PageResultDto<GuestbookDto, Guestbook> list(PageRequestDto dto) {
    Pageable pageable = dto.getPageable(Sort.by(Direction.DESC,"gno"));
    Page<Guestbook> page = repository.findAll(pageable);
    // Function<Guestbook, GuestbookDto> fn = e -> toDto(e); //ResultDto에서 필요해서씀
    PageResultDto<GuestbookDto, Guestbook> resultDto = new PageResultDto<>(page, e -> toDto(e)); //인터페이스는 안먹음
    return resultDto;
    //Page<E>를 Stream(으로 변환할 수 있음) .map(P).toList ↓
    //List<D>
  }
  
}
