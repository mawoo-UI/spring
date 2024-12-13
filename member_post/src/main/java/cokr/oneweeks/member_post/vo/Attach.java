package cokr.oneweeks.member_post.vo;


import org.apache.ibatis.type.Alias;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Alias("attach")
public class Attach {
	private String uuid;
	private String origin;
	private String path;
	private boolean image;
	private long pno;
	

}
