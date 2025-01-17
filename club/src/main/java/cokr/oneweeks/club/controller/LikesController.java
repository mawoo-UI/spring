package cokr.oneweeks.club.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cokr.oneweeks.club.entity.dto.LikesDto;
import cokr.oneweeks.club.service.LikesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("api/v1/likes")
public class LikesController {
  private LikesService service;
  
  
  @GetMapping
  public boolean get(@RequestBody LikesDto dto) {
    return service.get(dto);
    
  }
  @PostMapping("path")
  public void postMethodName(@RequestBody LikesDto dto) {
     service.toggle(dto); 
  }

}

