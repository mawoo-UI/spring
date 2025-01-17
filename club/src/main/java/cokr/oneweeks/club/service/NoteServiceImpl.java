package cokr.oneweeks.club.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cokr.oneweeks.club.entity.Member;
import cokr.oneweeks.club.entity.Note;
import cokr.oneweeks.club.entity.dto.NoteDto;
import cokr.oneweeks.club.repository.MemberRepository;
import cokr.oneweeks.club.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class NoteServiceImpl implements NoteService {
  @Autowired
  private NoteRepository repository;
  
  @Autowired
  private MemberRepository memberRepository;
 
  public Long repository(NoteDto dto) {
    Note note = toEntity(dto);

    log.info("===================");
    log.info(note);
    repository.save(note);

    return note.getNum();
  }
  
  public Optional<NoteDto> get (Long num) {
    Note note = repository.findByNum(num);
    return repository.findById(num).map(this::toDto);
  }
  
  public void modify(NoteDto dto) {
    repository.save(toEntity(dto));
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
    Member member = memberRepository.findByEmail(dto.getWriter());
    dto.setMno(member.getMno());
    Note note = toEntity(dto);
    return repository.save(toEntity(dto)).getNum();
  }
  @Override
  public List<NoteDto> listAll() {
    return repository.findAll().stream().map(this::toDto).toList();
  }
  

  
}
