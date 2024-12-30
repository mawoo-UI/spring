package cokr.oneweeks.demotest.vo;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("reply")
public class Reply {
	private Long rno;
	private String content;
	private Date regdate;
	private Date updatedate;
	private Boolean hidden;
	private int likes;
	private String writer;
	private Long pno;

	
	
}
