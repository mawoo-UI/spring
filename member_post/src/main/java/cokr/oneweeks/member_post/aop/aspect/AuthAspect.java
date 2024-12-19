package cokr.oneweeks.member_post.aop.aspect;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import cokr.oneweeks.member_post.exception.NotMyPostException;
import cokr.oneweeks.member_post.exception.UnsignedAuthException;
import cokr.oneweeks.member_post.vo.Member;
import cokr.oneweeks.member_post.vo.Post;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Aspect
@Component
@AllArgsConstructor
@Log4j2
@Order

public class AuthAspect {
  private HttpSession session;
  private HttpServletRequest req;
  private HttpServletResponse resp;
  
  @Before("@annotation(cokr.oneweeks.member_post.aop.SigninCheck)")
  public void signinCheck(JoinPoint jp) throws IOException {
    log.info(req.getRequestURL());
    log.info(req.getRequestURI());
    log.info(req.getQueryString());
    if (session.getAttribute("member") == null) {
      String url = "/member/signin?url=/post/write?" + URLEncoder.encode (req.getRequestURI() + "?" + req.getQueryString(), "utf-8");
      resp.sendRedirect("/msg?msg=" + URLEncoder.encode("로그인이 필요한 페이지 입니다", "utf-8") + "&url=" + url);
      
    }
  }
  @Before("@annotation(cokr.oneweeks.member_post.aop.MyPost)")
  public void myPost(JoinPoint joinPoint) throws IOException{
    // MyPost myPost/내가쓴건지 아닌지 확인용
    Object o = session.getAttribute("member");
    if (o == null) {
      throw new UnsignedAuthException("비로그인 상태");
    }
    String id = ((Member) o).getId(); //현재 로그인한 사용자
  
    Object[]args = joinPoint.getArgs();
    for(Object obj : args) {
      if(obj instanceof Post && !((Post)obj).getWriter().equals(id)) {
        throw new NotMyPostException("본인 게시물 아님");
      }
      // joinPoint
      // String writerParam = myPost.value();
    }
  
    log.error(Arrays.toString(args));
    log.error(id);
    
    // log.info(writerParam);
    // if (o == null || !((Member)o).getId().equals(post.getWriter())) {
    //   throw new RuntimeException("본인 게시글 아님");
    // }
  }
}
