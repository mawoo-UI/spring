package cokr.oneweeks.jdbc.dao;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import cokr.oneweeks.jdbc.vo.Member;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MemberDao {
  private JdbcTemplate jdbcTemplate;

  public String getTime() {
    return jdbcTemplate.queryForObject("select now()",String.class);
  }

  public int reqister(Member member) {
    return jdbcTemplate.update("insert into tbl_member (id, pw, name) values(?, ?, ?)"
    , member.getId(), member.getPw(), member.getName());
  }
}
