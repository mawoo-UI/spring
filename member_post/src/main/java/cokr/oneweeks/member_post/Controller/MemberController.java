package cokr.oneweeks.member_post.Controller;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cokr.oneweeks.member_post.service.MemberService;
import cokr.oneweeks.member_post.vo.Member;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("member")
@Log4j2
@AllArgsConstructor
public class MemberController {
  
  // /member/signin
  // return type
  // Sting : '해당 위치의 jsp' (ex: /WEB-INF/ciews/member/signin.jsp) 로 forward
  // void ; 접속 requestURI 위치를 반환 forward
  private MemberService service;

  @RequestMapping(value = "signin", method = RequestMethod.GET)
  public void signin() {}
  
  @PostMapping("signin")
  public String postSignin(Member member,@Nullable @RequestParam(required = false, value="remember-id") String remember,
    HttpSession session
  ) {
      
    log.info(remember);
    log.info(member);

      
    if (service.login(member.getId(), member.getPw())) {
      session.setAttribute("member", service.findBy(member.getId()));  
      return "redirect:/";
    }
      else {
        //실패
      }
      return null;
    }
        
  }
