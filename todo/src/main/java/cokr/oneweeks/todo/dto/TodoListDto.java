package cokr.oneweeks.todo.dto;


import cokr.oneweeks.todo.domain.TodoEntitiy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class TodoListDto {
  private Long id;
  private String task;
  private boolean done;

  public TodoListDto(TodoEntitiy entitiy) {
    id = entitiy.getId();
    task = entitiy.getTask();
    done = entitiy.isDone();

  }

  // dto >> entity
  public TodoEntitiy todoEntitiy() {
    return TodoEntitiy.builder().id(id).task(task).done(done).build();
  }
}
