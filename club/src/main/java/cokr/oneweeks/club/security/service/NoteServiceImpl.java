package cokr.oneweeks.club.security.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cokr.oneweeks.club.entity.Note;
import cokr.oneweeks.club.repository.NoteRepository;
import cokr.oneweeks.club.security.dto.NoteDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class NoteServiceImpl implements NoteService {
  @Autowired
  private NoteRepository repository;
  
 
  public Long repository(NoteDto dto) {
    Note note = ToEntity(dto);

    log.info("===================");
    log.info(note);
    repository.save(note);

    return note.getNum();
  }
  
  public NoteDto get (Long num) {
    Note note = repository.findByNum(num);
    // if (result.isPresent()) {
      
    //   return toDto(result.get());
    // }
    return toDto(note);
  }
  
  public void modify(NoteDto dto) {
    repository.save(ToEntity(dto));
  }

  public void remove(Long num) {
    repository.deleteById(num);
  }

  public List<NoteDto> getWriter(String email) {

    List<Note> list = repository.findByMemberEmail(email);

    return list.stream().map(note -> toDto(note)).collect(Collectors.toList());
  }

  @Override
  public List<NoteDto> list(String email) {
    List<Note> list = repository.findByMemberEmail(email);
    return list.stream().map(note -> toDto(note)).toList();
  }

  @Override
  public Long write(NoteDto dto) {
    Note note = ToEntity(dto);
    repository.save(note);
    return note.getNum();
  }
  

  
}
