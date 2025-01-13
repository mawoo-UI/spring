package cokr.oneweeks.club.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cokr.oneweeks.club.security.dto.NoteDto;
import cokr.oneweeks.club.security.service.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@Log4j2
@RequestMapping("api/v1/notes")
public class NoteController {
  @Autowired
  private NoteService service;

  @PostMapping
  public ResponseEntity<?> register(@RequestBody NoteDto dto) {
    Long num = service.write(dto);      
    return new ResponseEntity<>(num, HttpStatus.OK);
  }
  
  @GetMapping("{num}")
  public ResponseEntity<?> get(@PathVariable Long num) {
    return ResponseEntity.ok().body(service.get(num));
    //service.get(num)
  }
  
  @GetMapping("list")
  public ResponseEntity<?> list(String email) {
    return ResponseEntity.ok().body(service.list(email));
  }
  
  @PutMapping("{num}")
  public ResponseEntity<?> modify(@PathVariable Long num, @RequestBody NoteDto dto) {
    service.modify(dto);
    return ResponseEntity.ok().body("success");
    // return service.modify(dto) > 0 ? "success" : "falure" ;
    //다른방법 사용시에는 public String modify() {} 식으로도 사용가능
  }

  @DeleteMapping("{num}")
  public ResponseEntity<?> remove(@PathVariable Long num) {
    service.remove(num);
    return ResponseEntity.ok().body("success");
  }
  
  
}
