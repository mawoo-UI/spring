package cokr.oneweeks.guestbook.domain.dto;

import java.time.LocalDateTime;

import cokr.oneweeks.guestbook.domain.entity.Guestbook;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuestbookListDto {
  private Long gno;
  private String title;
  private String writer;
  private LocalDateTime regDate;
  private LocalDateTime modDate;

  

  public GuestbookListDto (Guestbook entity) {
    this.gno = entity.getGno();
    this.title = entity.getTitle();
    this.writer = entity.getWriter();
    this.regDate = entity.getRegDate();
    this.modDate = entity.getModDate();
  }
}
