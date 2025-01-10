package cokr.oneweeks.club.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cokr.oneweeks.club.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long>{
  Note findByNum(Long num);

  List<Note> findByMemberMno(Long mno);

  List<Note> findByMemberEmail(String email);

  // Optional<Note> getWriter();

  // List<Note> getList(String email);


}
