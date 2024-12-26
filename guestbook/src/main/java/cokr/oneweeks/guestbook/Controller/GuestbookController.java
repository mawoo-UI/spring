package cokr.oneweeks.guestbook.Controller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cokr.oneweeks.guestbook.domain.dto.PageRequestDto;
import cokr.oneweeks.guestbook.service.GuestbookService;
// import jakarta.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;


@Controller
@RequestMapping("guestbook")
@Log4j2
public class GuestbookController {
  // @Autowired
  @Inject //Autowired와 같은기능함
  private GuestbookService service;

  @GetMapping({"", "/", "list"})
  public String list(Model model, PageRequestDto dto) {
    log.info("result");  
    model.addAttribute("result", service.list(dto));
    return "/guestbook/list";
  }
  
}
