package cokr.oneweeks.club.service;


import java.util.List;
import java.util.Optional;

import cokr.oneweeks.club.entity.Attach;
import cokr.oneweeks.club.entity.Member;
import cokr.oneweeks.club.entity.Note;
import cokr.oneweeks.club.entity.dto.AttachDto;
import cokr.oneweeks.club.entity.dto.NoteDto;

public interface NoteService {
  // Note ToEntity(NoteDto Dto) {
    Optional <NoteDto> get(Long num);

    void remove(Long num);

    void modify(NoteDto dto);

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
    
    
    note.setAttachs(dto.getAttachDtos().stream().map(a -> Attach.builder()
      .uuid(a.getUuid())
      .origin(a.getOrigin())
      .ext(a.getExt())
      .fileName(a.getFileName())
      .image(a.isImage())
      .mime(a.getMime())
      .path(a.getPath())
      .size(a.getSize())
      .url(a.getUrl())
      .note(note)
      .build()).toList()
      );
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
    .attachDtos(note.getAttachs().stream().map(a -> AttachDto.builder()
      .ext(a.getExt())
      .fileName(a.getFileName())
      .image(a.isImage())
      .mime(a.getMime())
      .num(a.getNote().getNum())
      .origin(a.getOrigin())
      .path(a.getPath())
      .size(a.getSize())
      .url(a.getUrl())
      .uuid(a.getUuid())
      .build()).toList()
      ).build();
    return noteDto;
  }

//   NoteDto get(Long num);
//   List<NoteDto> list(String email);
//   Long write(NoteDto dto);
//   List<NoteDto> listAll();

}
