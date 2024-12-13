package cokr.oneweeks.jdbc.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
  // create
  public int reqister(Member member) {
    return jdbcTemplate.update("insert into tbl_member (id, pw, name) values(?, ?, ?)"
    , member.getId(), member.getPw(), member.getName());
  }

  //select
  public List<Member> selectlList() {
    return jdbcTemplate.query("select * from tbl_member", new MyMapper());
  }

  // update
  public int update(Member member) {
    // return jdbcTemplate.update("select * from tbl_post",Date.valueOf(null));
    return jdbcTemplate.update("update tbl_member set pw = ?, name = ?, email = ?, road_addr = ?, detail_addr = ?, regdate = now(), where id = ?"
    , member.getPw(), member.getName(), member.getEmail(), member.getRoad_addr(), member.getDetail_addr(), member.getId());
  }

  // delete
  public int delete(String id){
    return jdbcTemplate.update("delete from tbl_member where id = ?", id);
  }


  public Member selectOne(String id) {
    return jdbcTemplate.queryForObject("select * from tbl_member where id = ?", new MyMapper(), id);
  }

  class MyMapper implements RowMapper<Member> {

    @Override
    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {

      return Member
        .builder()
        .id(rs.getString("id"))
        .pw(rs.getString("pw"))
        .name(rs.getString("name"))
        .email(rs.getString("email"))
        .road_addr(rs.getString("road_addr"))
        .detail_addr(rs.getString("detail_addr"))
        // .regdata(LocalDateTime.ofInstant(rs.getDate("regdata").toInstant(), ZoneId.systemDefault()))
        .regdate(rs.getTimestamp("regdate").toLocalDateTime())
        .build();
    }
    
  }
}
