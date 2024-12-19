package cokr.oneweeks.member_post.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import cokr.oneweeks.member_post.aop.annotation.MyPost;
import cokr.oneweeks.member_post.aop.annotation.SigninCheck;
import cokr.oneweeks.member_post.dto.Criteria;
import cokr.oneweeks.member_post.dto.PageDto;
import cokr.oneweeks.member_post.service.PostService;
import cokr.oneweeks.member_post.vo.Member;
import cokr.oneweeks.member_post.vo.Post;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;




@Controller
@RequestMapping("post")
@AllArgsConstructor
@Log4j2
public class PostController {
  private PostService service;
  // private CategoryService categoryService;

  @GetMapping("list")
  public String list(Criteria cri, Model model) {
    log.info(cri);
    model.addAttribute("posts", service.list(cri));
    model.addAttribute("pageDto", new PageDto(cri, service.count(cri)));
    // model.addAttribute("cname", categoryService.findBy(cri.getCategory()).getCname());
    return "post/list";
  }

  @GetMapping("view")
  public void view(@ModelAttribute("cri") Criteria cri,@RequestParam("pno") Long pno, Model model) {
    log.info(pno);
    model.addAttribute("post", service.view(pno));
  }

  @GetMapping("write")
  @SigninCheck
  public void write(@ModelAttribute("cri") Criteria cri , Post post) {
    log.info(cri);
    log.info(post);
  }
    
  @PostMapping("write")
  public String postWrite(Post post, Criteria cri) {
    post.setCno(cri.getCategory());
    service.write(post);
    log.info(post);
    // return "list?";
    return "redirect:list?" + cri.getQs2();
  }

  @GetMapping("modify")
  @SigninCheck

  public void modify(@RequestParam("pno") Long pno, Model model, Criteria cri,
  @SessionAttribute(name = "member",required = false) Member member) {
      log.info(pno);
      log.info(cri);
      Post post = service.findBy(pno);
      log.info(post);
      // if(!(member != null && member.getId().equals(post.getWriter()))) {

      // }
      if (member == null || !member.getId().equals(post.getWriter())) {
        throw new RuntimeException("동일하지 않은 혹은 비로그인");
      }
      log.info(member.getId());
        

      model.addAttribute("post", post);
  }
  public void checkMyPost(Post post) {

  }



  @PostMapping("modify")
  @SigninCheck @MyPost
  //여기
  public String postModify(Post post, Criteria cri) {
      log.info(post);      
      log.info(cri);
      // service.modify(post);
      // log.info("pno");
      return "redirect:list?"+ cri.getQs2();
  }

  
  @RequestMapping("remove")
  public String remove(@RequestParam("pno") Long pno, Criteria cri) {
      service.remove(pno);
      return "redirect:list?"+ cri.getQs();
  }
  
  
  
}
