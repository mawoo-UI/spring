package cokr.oneweeks.club.security.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto {
  private Long num;
  private String title;
  private String content;
  private String writer;
  private Long mno;
  private LocalDateTime regDate, modDate;

}
