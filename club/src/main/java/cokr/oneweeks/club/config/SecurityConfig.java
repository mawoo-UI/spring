package cokr.oneweeks.club.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import cokr.oneweeks.club.security.handler.LoginSuccessHandler;
import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class SecurityConfig {

  private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
      // salt

      return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http
          .csrf(csrf -> csrf.disable()) // CSRF 비활성화 (필요에 따라 활성화)
          .authorizeHttpRequests(auth -> auth
              .requestMatchers("/sample/all/").permitAll() // `/public/` 경로는 인증 없이 접근 가능
              .requestMatchers("/sample/member/").hasRole("USER") // `/public/` 경로는 인증 없이 접근 가능
              .requestMatchers("/sample/admin/").hasRole("ADMIN") // `/public/` 경로는 인증 없이 접근 가능
              .anyRequest().authenticated() // 나머지는 인증 필요
          )
          .formLogin(f -> f.permitAll())
           // 기본 로그인 폼 활성화
          .logout(l -> l.logoutUrl("/member/signout"))
          // .oauth2Login(Customizer.withDefaults());
          .oauth2Login(o -> o.successHandler(loginSuccessHandler()))
          .rememberMe(r -> r.tokenValiditySeconds(60 * 60 * 24 * 14).userDetailsService(userDetailsService).rememberMeCookieName("remember-id"));
          // .logout(null)
          // .formLogin(null)
          // .
      return http.build();
  }

  @Bean
  public LoginSuccessHandler loginSuccessHandler() {
    return new LoginSuccessHandler(passwordEncoder());
  }
}