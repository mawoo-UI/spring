package cokr.oneweeks.demotest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import cokr.oneweeks.demotest.dto.Criteria;
import cokr.oneweeks.demotest.dto.PageDto;
import cokr.oneweeks.demotest.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@RequestMapping("post")
@Log4j2
@AllArgsConstructor
public class PostController {
    
    private PostService service;
    InternalResourceViewResolver resolver;
    @GetMapping("list")
    public String list(Criteria cri, Model model) {
        log.info(cri);
        model.addAttribute("posts", service.list(cri));
        model.addAttribute("pageDto", new PageDto(cri, service.count(cri)));
        return "post/list";
    }
    @GetMapping("view")
    public void view(@ModelAttribute("cri") Criteria cri,@RequestParam("pno") Long pno, Model model) {
        log.info(pno);
        model.addAttribute("post", service.view(pno));
  }

}
