package cokr.oneweeks.guestbook.domain.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
  private Long bno;
  private String title;
  private String content;
  private String memberEmail;
  private String memberName;
  private LocalDate regDate;
  private LocalDate modDate;
  private int replyCnt;
}
