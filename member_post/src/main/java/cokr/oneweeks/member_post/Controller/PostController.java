package cokr.oneweeks.member_post.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cokr.oneweeks.member_post.dto.Criteria;
import cokr.oneweeks.member_post.dto.PageDto;
import cokr.oneweeks.member_post.service.PostService;
import cokr.oneweeks.member_post.vo.Post;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Controller
@RequestMapping("post")
@AllArgsConstructor
@Log4j2
public class PostController {
  private PostService service;

  @GetMapping("list")
  public void list(Criteria cri, Model model) {
    log.info(cri);
    model.addAttribute("posts", service.list(cri));
    model.addAttribute("pageDto", new PageDto(cri, service.count(cri)));
  }
  @GetMapping("view")
  public void view(@ModelAttribute("cri") Criteria cri,@RequestParam("pno") Long pno, Model model) {
    log.info(pno);
    model.addAttribute("post", service.view(pno));
  }

  @GetMapping("write")
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
  
  
}
