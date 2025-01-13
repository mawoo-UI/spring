package cokr.oneweeks.guestbook.domain.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< HEAD
import lombok.ToString;

@Data
@Builder 
@ToString
=======

@Data
@Builder
>>>>>>> 2f2f45ebec147e15252a0ada563193b9290f154b
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
  private Long bno;
  private String title;
  private String content;
  private String memberEmail;
  private String memberName;
  private LocalDateTime regDate;
  private LocalDateTime modDate;
  private int replyCnt;
<<<<<<< HEAD

=======
>>>>>>> 2f2f45ebec147e15252a0ada563193b9290f154b
}
