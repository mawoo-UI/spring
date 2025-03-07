package cokr.oneweeks.club.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "tbl_attach")
@Getter
@ToString(exclude = "note")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attach extends BaseEntity{
  @Id
  // @GeneratedValue(strategy = GenerationType.UUID)
  private String uuid;
  private String origin;
  private boolean image;
  private String path;


  private long size;
  private String mime;
  private String fileName;
  private String ext;
  private String url;
  
  @ManyToOne(fetch = FetchType.LAZY)
  private Note note;

  



}
