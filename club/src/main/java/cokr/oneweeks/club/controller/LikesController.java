package cokr.oneweeks.club.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cokr.oneweeks.club.entity.dto.LikesDto;
import cokr.oneweeks.club.service.LikesService;
import lombok.extern.log4j.Log4j2;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("api/v1/likes")
@Log4j2
public class LikesController {
  @Autowired
  private LikesService service;
  
  
  @GetMapping
  public boolean get(LikesDto dto) { // get에서는 RequestBody 사용안됨으로 제외
    log.info(dto);
    return service.get(dto);
    
  }
  // @PreAuthorize("email == dto.email")
  @PostMapping
  public ResponseEntity<?> toggle(@RequestBody LikesDto dto, @AuthenticationPrincipal String email) {
    log.info(email);
    log.info(dto);
    service.toggle(dto); 
    return ResponseEntity.ok().body(Map.of("result", service.toggle(dto)));
  }

}

