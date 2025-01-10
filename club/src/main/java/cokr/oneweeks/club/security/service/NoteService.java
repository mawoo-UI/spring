package cokr.oneweeks.club.security.service;


import java.util.List;

import cokr.oneweeks.club.entity.Member;
import cokr.oneweeks.club.entity.Note;
import cokr.oneweeks.club.security.dto.NoteDto;

public interface NoteService {
  default Note ToEntity(NoteDto Dto){
    Note note = Note.builder()
    .num(Dto.getNum())
    .title(Dto.getTitle())
    .content(Dto.getContent())
    .member(Member.builder().email(Dto.getWriter()).mno(Dto.getMno()).build()) 
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
  NoteDto get(Long num);
  List<NoteDto> list(String email);
  Long write(NoteDto dto);
}
