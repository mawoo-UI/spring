package cokr.oneweeks.member_post.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Alias("post")
public class Post {
	private Long pno;
	private String title;
	private String writer;
	private String content;
	private Long viewCount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	private Date updatedate;
	private Integer cno;
	private Boolean attachFlag;

	private List<Attach> attachs = new ArrayList<Attach>();

}


