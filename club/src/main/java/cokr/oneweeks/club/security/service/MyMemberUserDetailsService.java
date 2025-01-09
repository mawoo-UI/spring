package cokr.oneweeks.club.security.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cokr.oneweeks.club.entity.Member;
import cokr.oneweeks.club.repository.MemberRepository;
import cokr.oneweeks.club.security.dto.AuthMemberDto;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class MyMemberUserDetailsService implements UserDetailsService{
  private MemberRepository repository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.info(username);
    Member member = repository.findByEmailAndFromSocial(username, false);
    if (member == null) {
      throw new UsernameNotFoundException(username);
    }
    AuthMemberDto authMemberDto = new AuthMemberDto(member.getEmail(),member.getPassword(),member.getMno(),member.isFromSocial()
  ,member.getName() ,member.getRoleSet().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.name())).toList());
    

    return null;
  }
  
}
