package cokr.oneweeks.club.security.filter;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ApiLoginFilter extends AbstractAuthenticationProcessingFilter{
  public ApiLoginFilter(String defaultFilterProcessUrl) {
    super(defaultFilterProcessUrl);
  }
  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException, IOException, ServletException {
    log.info("============================= ApiLoginFilter.attemptAuthentication() ================================");
    String email = request.getParameter("email");
    String pw = "1234";
    

    log.info("email :" + email);
    log.info("pw :" + pw);
    // if (email == null) {
    //   throw new BadCredentialsException("email cannot be null");
    // }
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, pw);
    log.info(authenticationToken.getPrincipal());
    return getAuthenticationManager().authenticate(authenticationToken);
  }
}