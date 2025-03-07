package cokr.oneweeks.guestbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cokr.oneweeks.guestbook.domain.dto.GuestbookDto;
import cokr.oneweeks.guestbook.domain.dto.PageRequestDto;
import cokr.oneweeks.guestbook.service.GuestbookService;

import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("guestbook")
@Log4j2
public class GuestbookController {
  @Autowired
  private GuestbookService service;

  @GetMapping({"", "list"})
  public String list(Model model, PageRequestDto dto) {
    // log.info("?");
    model.addAttribute("result", service.list(dto));
    return "/guestbook/list";
  }
  
  @GetMapping("register")
  public void register() {

  }
  
  @PostMapping("register")
  public String register(GuestbookDto dto, RedirectAttributes rttr) {
    rttr.addFlashAttribute("msg", service.write(dto));
    return "redirect:list";
  }
  
  @GetMapping({"read", "modify"})
  public void read(Long gno, Model model, @ModelAttribute("pageDto") PageRequestDto pageDto) {
    model.addAttribute("dto", service.read(gno));
  }
  
  @PostMapping("modify")
  public String modify(GuestbookDto dto, PageRequestDto pageDto, RedirectAttributes rttr) {
    service.modify(dto);
    rttr.addAttribute("page", pageDto.getPage());
    rttr.addAttribute("type", pageDto.getType());
    rttr.addAttribute("keyword", pageDto.getKeyword());
    return "redirect:list";
  }
  
  @PostMapping("remove")
  public String remove(Long gno, PageRequestDto pageDto, RedirectAttributes rttr) {
    service.remove(gno);
    rttr.addAttribute("page", pageDto.getPage());
    rttr.addAttribute("type", pageDto.getType());
    rttr.addAttribute("keyword", pageDto.getKeyword());
    return "redirect:list";
  }
  
}
