package cokr.oneweeks.club.entity.composite;

import java.io.Serializable;

import cokr.oneweeks.club.entity.dto.LikesDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class LikesId implements Serializable{
  private Long member;
  private Long note;

  public LikesId(LikesDto dto) {
    member = dto.getMno();
    note = dto.getNum();
  }
}
