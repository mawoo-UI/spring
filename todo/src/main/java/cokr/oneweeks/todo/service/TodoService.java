package cokr.oneweeks.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cokr.oneweeks.todo.dto.TodoListDto;
import cokr.oneweeks.todo.dto.TodoWriteDto;
import cokr.oneweeks.todo.repository.Todorepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class TodoService {
  private final Todorepository repository;
  //목록조회
  public List<TodoListDto> list() {
    return repository.findAll().stream().map(TodoListDto::new).toList();
  }
  //등록
  public void write(TodoWriteDto dto) {
    repository.save(dto.todoEntitiy());
  }
  //삭제
}
