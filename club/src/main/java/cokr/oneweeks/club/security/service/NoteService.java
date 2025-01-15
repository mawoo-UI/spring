package cokr.oneweeks.club.security.service;


import java.util.List;
import java.util.Optional;

import cokr.oneweeks.club.entity.Member;
import cokr.oneweeks.club.entity.Note;
import cokr.oneweeks.club.security.dto.NoteDto;

public interface NoteService {
  // Note ToEntity(NoteDto Dto) {
    Optional <NoteDto> get(Long num);

    Long write(NoteDto dto);
    List<NoteDto> list(String memberEmail);
    List<NoteDto> listAll();


  default Note toEntity(NoteDto dto) {
    Note note = Note.builder()
    .num(dto.getNum())
    .title(dto.getTitle())
    .content(dto.getContent())
    .member(Member.builder().email(dto.getWriter()).mno(dto.getMno()).build()) 
    .build();
    // .member(noteDto.get)
    return note;
  }
  default NoteDto toDto(Note note) {
    NoteDto noteDto = NoteDto.builder()
    .num(note.getNum())
    .title(note.getTitle())
    .content(note.getContent())
    .writer(note.getMember().getEmail())
    .mno(note.getMember().getMno())
    .regDate(note.getRegDate())
    .modDate(note.getModDate())
    .build();
    return noteDto;
  }
  void remove(Long num);
  void modify(NoteDto dto);
//   NoteDto get(Long num);
//   List<NoteDto> list(String email);
//   Long write(NoteDto dto);
//   List<NoteDto> listAll();

}
