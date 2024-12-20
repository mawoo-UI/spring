package cokr.oneweeks.todo.dto;


import cokr.oneweeks.todo.domain.TodoEntitiy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class TodoWriteDto {
  private String task;

  public TodoWriteDto(TodoEntitiy entitiy) {
    task = entitiy.getTask();

  }

  // dto >> entity
  public TodoEntitiy todoEntitiy() {
    return TodoEntitiy.builder().task(task).build();
  }
}
