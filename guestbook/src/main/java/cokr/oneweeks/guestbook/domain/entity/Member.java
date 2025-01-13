package cokr.oneweeks.guestbook.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

<<<<<<< HEAD
@Entity(name = "tbl_member")
=======
@Entity
>>>>>>> 2f2f45ebec147e15252a0ada563193b9290f154b
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
<<<<<<< HEAD
@Table
public class Member extends BaseEntity{
  @Id
  private String email;

  private String password;

  private String name;
=======
@Table(name = "tbl_member")
public class Member {
    @Id
    private String email;

    private String password;

    private String name;
>>>>>>> 2f2f45ebec147e15252a0ada563193b9290f154b
}
