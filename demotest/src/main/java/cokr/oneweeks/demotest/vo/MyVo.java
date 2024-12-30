package cokr.oneweeks.demotest.vo;

import java.util.List;

import lombok.Data;

@Data
public class MyVo {
  private String data;
  private List<Post> posts;
}
