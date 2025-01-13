package cokr.oneweeks.guestbook.domain.entity;

<<<<<<< HEAD

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
=======
import jakarta.persistence.Entity;
>>>>>>> 2f2f45ebec147e15252a0ada563193b9290f154b
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

<<<<<<< HEAD
// @Table()
=======
>>>>>>> 2f2f45ebec147e15252a0ada563193b9290f154b
@Entity(name = "tbl_board")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
<<<<<<< HEAD
@ToString(exclude = "member")
@Table
public class Board extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bno;

  private String title;

  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  private Member member;

=======
@ToString
@Table(name = "tbl_board")
public class Board extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    private String content;

    @ManyToOne
    private Member member;    
>>>>>>> 2f2f45ebec147e15252a0ada563193b9290f154b
}
