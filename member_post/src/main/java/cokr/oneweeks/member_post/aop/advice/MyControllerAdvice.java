package cokr.oneweeks.member_post.aop.advice;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cokr.oneweeks.member_post.exception.NotMyPostException;
import cokr.oneweeks.member_post.exception.UnsignedAuthException;

@ControllerAdvice
public class MyControllerAdvice {
  @ExceptionHandler({UnsignedAuthException.class , NotMyPostException.class})
  public String unsignedAuthException(Exception ex) throws UnsupportedEncodingException {
    return "redirect:/msg?msg=" + URLEncoder.encode(ex.getMessage() , "utf-8") + "&url=/member/singin";
  }
}
