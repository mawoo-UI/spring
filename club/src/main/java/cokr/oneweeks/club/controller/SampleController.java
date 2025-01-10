package cokr.oneweeks.club.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cokr.oneweeks.club.security.dto.AuthMemberDto;



@Controller
@Log4j2
@RequestMapping("sample")
public class SampleController {

  @GetMapping("all")
  public void exAll(@AuthenticationPrincipal AuthMemberDto dto) {
    // UsernamePasswordAuthenticationToken token;
    // AuthenticationManager manager;
    // AuthenticationProvider provider;
    log.info(dto);
    log.info("ex all");
  }
  @GetMapping("member")
  public void exMember(@AuthenticationPrincipal AuthMemberDto dto) {
    log.info(dto);
    log.info("ex member");
  }
  @GetMapping("admin")
  public void exAdmin(@AuthenticationPrincipal AuthMemberDto dto) {
    log.info(dto);
    log.info("ex admin");
  }

  @GetMapping("api")
  //AIzaSyDeKCW4gni-QnM5gYskOT7D3apKrRUpLYU ////
  @ResponseBody
  public AuthMemberDto getMethdName(@AuthenticationPrincipal AuthMemberDto dto) {
      return dto;
  }
  
}
