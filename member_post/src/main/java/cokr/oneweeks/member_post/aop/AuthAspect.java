package cokr.oneweeks.member_post.aop;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import cokr.oneweeks.member_post.vo.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Aspect
@Component
@AllArgsConstructor
@Log4j2
public class AuthAspect {
  private HttpSession session;
  private HttpServletRequest req;
  private HttpServletResponse resp;
  
  @Before("@annotation(cokr.oneweeks.member_post.aop.MyPost)")
  public void myPost(JoinPoint joinPoint,MyPost myPost){
    // MyPost myPost
    Object o = session.getAttribute("member");
    String id = ((Member) o).getId(); //현재 로그인한 사용자

    Object[]args = joinPoint.getArgs();
    // joinPoint
    // String writerParam = myPost.value();
    log.error(Arrays.toString(args));
    log.error(id);
    // log.info(writerParam);
    // if (o == null || !((Member)o).getId().equals(post.getWriter())) {
    //   throw new RuntimeException("본인 게시글 아님");
    // }
  }

  @Before("@annotation(cokr.oneweeks.member_post.aop.SigninCheck)")
  public void signinCheck(JoinPoint jp) throws IOException {
    log.info(req.getRequestURL());
    log.info(req.getRequestURI());
    log.info(req.getQueryString());
    if (session.getAttribute("member") == null) {
      String url = "/member/signin?url=/post/write?" +URLEncoder.encode (req.getRequestURI() + "?" + req.getQueryString(), "utf-8");
      resp.sendRedirect("/msg?msg=" + URLEncoder.encode("로그인이 필요한 페이지 입니다", "utf-8") + "&url=" + url);
    }
    
  }
}
