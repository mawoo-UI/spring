package cokr.oneweeks.guestbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import cokr.oneweeks.guestbook.domain.dto.BoardDto;
import cokr.oneweeks.guestbook.domain.dto.PageRequestDto;
import cokr.oneweeks.guestbook.service.BoardService;

import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@Log4j2
@RequestMapping("api/v1/board")
public class BoardController {
  @Autowired
  private BoardService service;

  @GetMapping("list")
  public ResponseEntity<?> list(PageRequestDto dto) {
    return ResponseEntity.ok().body(service.list(dto));
  }

  @GetMapping("{bno}")
  public ResponseEntity<?> get(@PathVariable("bno") Long bno) {
    return ResponseEntity.ok().body(service.get(bno));
  }

  @PostMapping("write")
  public ResponseEntity<?> register(@RequestBody BoardDto dto) {
      service.register(dto);
      return ResponseEntity.ok().body("success");
  }
  
  @PutMapping("{bno}")
  public ResponseEntity<?> modify(@RequestBody BoardDto dto) {
      service.modify(dto);
      return ResponseEntity.ok().body("success");
  }

  @DeleteMapping("{bno}")
  public ResponseEntity<?> remove(@PathVariable("bno") Long bno) {
    service.remove(bno);
    return ResponseEntity.ok().body("success");
  }

  @GetMapping("test")
  public String test() {
      return "test";
  }
  
}
