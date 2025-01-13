package cokr.oneweeks.guestbook.Controller;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> 2f2f45ebec147e15252a0ada563193b9290f154b

import cokr.oneweeks.guestbook.domain.dto.BoardDto;
import cokr.oneweeks.guestbook.domain.dto.PageRequestDto;
import cokr.oneweeks.guestbook.service.BoardService;
import lombok.extern.log4j.Log4j2;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Log4j2
@Service
@RestController
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
      return ResponseEntity.ofNullable(service.get(bno));
  }
  
  @DeleteMapping("{bno}")
  public ResponseEntity<?> remove (@PathVariable("bno") Long bno) {
      service.remove(bno);
      return ResponseEntity.ok().body("success");

    }
  @PostMapping
  public ResponseEntity<?> register(@RequestBody BoardDto dto) {
      service.register(dto);
      return ResponseEntity.ok().body("success");
   }
  @PostMapping("{bno}")
  public ResponseEntity<?> modify(@RequestBody BoardDto dto) {
      service.modify(dto);
      return ResponseEntity.ok().body("success");
  }

  @GetMapping("test")
  public String test() {
      return "test";
  }
  
  
=======
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





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
    public ResponseEntity<?> remove(@PathVariable("bno") Long bno){
        service.remove(bno);
        return ResponseEntity.ok().body("success");
    }

    @GetMapping("test")
    public String test() {
        return "test";
    }
    
    
    
>>>>>>> 2f2f45ebec147e15252a0ada563193b9290f154b
}
