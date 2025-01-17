package cokr.oneweeks.club.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cokr.oneweeks.club.entity.dto.LikesDto;
import cokr.oneweeks.club.service.LikesService;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
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
  @PostMapping("path")
  public void postMethodName(@RequestBody LikesDto dto) {
     service.toggle(dto); 
  }

}

