package cokr.oneweeks.todo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.ScrollPosition.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cokr.oneweeks.todo.domain.TodoEntitiy;
import cokr.oneweeks.todo.dto.TodoListDto;
import cokr.oneweeks.todo.dto.TodoWriteDto;
import cokr.oneweeks.todo.repository.TodoRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TodoService {
  private  TodoRepository repository;
  private EntityManager manager;

  @PostConstruct
  public void init() {
  // public TodoService(TodoRepository repository) {
    // this.repository = repository;
    repository.saveAll(
      Stream.of(
      TodoEntitiy.builder().task("첫일").build(),
      TodoEntitiy.builder().task("첫일").build(),
      TodoEntitiy.builder().task("첫일").build()
      ).toList()
    );
  }
  // }

  //목록조회
  public List<TodoListDto> list() {
    // return repository.findAll(Sort.by(Direction.DESC,"id")).stream().map(TodoListDto::new).toList();
    // return repository.findByOrderByTaskDescIdAsc().stream().map(TodoListDto::new).toList();
    return repository.findAll(Sort.by(Order.desc("task"),Order.asc("id"))).stream().map(TodoListDto::new).toList();
  }
  //등록
  public void write(TodoWriteDto dto) {
    repository.save(dto.todoEntitiy());
  }
  //삭제
  public void remove(Long id) {
    // repository.delete(TodoEntitiy.builder().id(id).build());
    repository.deleteById(id);
  }
  //수정
  @Transactional
  public void modify(Long id) {
    // Optional<TodoEntitiy> entitiy = repository.findById(id);
    // entitiy.ifPresent(e->{ e.setDone(true); repository.save(e); });
    // repository.save(TodoEntitiy.builder().id(id).done(true).task("직접준것.").build());  
    repository.updateTodoDoneById(id);
    
  }

  //Using EntityManager
  @Transactional
  public void modify2(Long id) {
    // Optional.of(manager.find(TodoEntitiy.class, id).ifPresent(e -> e.setDone(true)));
    manager.find(TodoEntitiy.class, id).setDone(true);

  }
}
