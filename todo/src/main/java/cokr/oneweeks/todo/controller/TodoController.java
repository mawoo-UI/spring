package cokr.oneweeks.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cokr.oneweeks.todo.dto.TodoListDto;
import cokr.oneweeks.todo.dto.TodoWriteDto;
import cokr.oneweeks.todo.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@AllArgsConstructor
@Log4j2
public class TodoController {
  private TodoService service;

  @GetMapping("todos")
  public String list(Model model) {
    model.addAttribute("todos", service.list());
    return "todo-list";
  }
  @PostMapping("todos")
  public String write(TodoWriteDto dto) {
      log.info(dto);
      service.write(dto);
      return "redirect:todos";
  }
  @RequestMapping("todos/remove")
  public String remove(Long id) {
      log.info(id);
      service.remove(id);
      return "redirect:/todos";
  }
  @RequestMapping("todos/modify")
  public String modify(Long id) {
      log.info(id);
      service.modify(id);
      
      return "redirect:/todos";
  }
  
  
}
