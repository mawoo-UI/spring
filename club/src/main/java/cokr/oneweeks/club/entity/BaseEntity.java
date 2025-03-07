package cokr.oneweeks.club.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.ToString;

@MappedSuperclass //어떤 엔티티의 조상 클래스가 될 예정(그 필드를 자손으로 쓸 수 있음)
@EntityListeners(value = AuditingEntityListener.class) //어플리케이션 시작지점에도 선언해야함
@Getter
@ToString
public class BaseEntity {

  @CreatedDate
  @Column(name = "regdate",updatable = false) //updatable = false:외부적으로 못쓰게하는것
  private LocalDateTime regDate;

  // Rembrandt
  @LastModifiedDate
  @Column(name = "moddate")
  private LocalDateTime modDate;
  

}
