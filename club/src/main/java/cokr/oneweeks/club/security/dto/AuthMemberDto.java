package cokr.oneweeks.club.security.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class AuthMemberDto extends User {
  public Long mno;
  public String email;
  public String name;
  public boolean fromSocial;


  public AuthMemberDto(String username, String password,Long mno, boolean fromSocial,String name, Collection<? extends GrantedAuthority> authorities) {
    super(username,password,authorities);
    this.email = username;
    this.mno = mno;
    this.fromSocial = fromSocial;
    this.name = name;
  }
  
}
