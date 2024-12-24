package cokr.oneweeks.guestbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cokr.oneweeks.guestbook.domain.dto.GuestbookListDto;
import cokr.oneweeks.guestbook.domain.dto.GuestbookModifyDto;
import cokr.oneweeks.guestbook.domain.dto.GuestbookViewDto;
import cokr.oneweeks.guestbook.domain.dto.GuestbookWriteDto;
import cokr.oneweeks.guestbook.domain.entity.GuestbookEntity;
import cokr.oneweeks.guestbook.repository.GuestRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GuestbookServiceImpl implements GuestbookService {
  private GuestRepository repository;
  

  @Override
  public GuestbookViewDto get(Long gno) {
    Optional<GuestbookEntity> opt = repository.findById(gno);
    if (!opt.isPresent()) {
      return null;
    }
    return new GuestbookViewDto(opt.get());
  }

  @Override
  public List<GuestbookListDto> list() {
    return repository.findAll().stream().map(GuestbookListDto::new).toList();
  }

  @Override
  public void modify(GuestbookModifyDto dto) {
    repository.save(dto.toEntity());    
  }

  @Override
  public void remove(Long gno) {
    repository.deleteById(gno);
  }

  @Override
  public void writer(GuestbookWriteDto dto) {
    repository.save(dto.toEntity());  
    
  }
  
}
