package cokr.oneweeks.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cokr.oneweeks.todo.domain.TodoEntitiy;

public interface Todorepository extends JpaRepository<TodoEntitiy, Long> {
  
}
