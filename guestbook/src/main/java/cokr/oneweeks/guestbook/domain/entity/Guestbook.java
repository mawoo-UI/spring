package cokr.oneweeks.guestbook.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "tbl_guestbook")
public class Guestbook extends BaseEntity{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long gno;
  @Column(nullable = false, length = 100)
  private String title;
  @Column(nullable = false, length = 1500)
  private String content;
  @Column(nullable = false, length = 50)
  private String writer;
}
