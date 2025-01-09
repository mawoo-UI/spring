package cokr.oneweeks.club.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cokr.oneweeks.club.security.dto.AuthMemberDto;



@Controller
@Log4j2
@RequestMapping("sample")
public class SampleController {
  @GetMapping("all")
  public void exAll() {
    UsernamePasswordAuthenticationToken token;
    AuthenticationManager manager;
    AuthenticationProvider provider;
    log.info("ex all");
  }
  @GetMapping("member")
  public void exMember() {
    log.info("ex member");
  }
  @GetMapping("admin")
  public void exAdmin() {
    log.info("ex admin");
  }
  @GetMapping("api")
  @RequestMapping
  public AuthMemberDto getMethdName(@AuthenticationPrincipal AuthMemberDto dto) {
      return dto;
  }
  
}
