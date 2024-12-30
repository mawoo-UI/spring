package cokr.oneweeks.demotest.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data  //겟터 셋터 둘다 해줌으로없으면 el 문제라고 뜸/주의
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

	// private Long rootno;
	// private Integer pdepth;
	// private Integer porder;
	
	private List<Attach> attachs = new ArrayList<Attach>();

	// public Post(Long pno, String title, String writer, String content, Long viewCount, Date regdate, Date updatedate,
	// Integer cno, Boolean attachFlag ,Long rootno, Integer pdepth, Integer porder) {
	// 	super();
	// 	this.pno = pno;
	// 	this.title = title;
	// 	this.writer = writer;
	// 	this.content = content;
	// 	this.viewCount = viewCount;
	// 	this.regdate = regdate;
	// 	this.updatedate = updatedate;
	// 	this.cno = cno;
	// 	this.attachFlag = attachFlag;
	// 	this.rootno = rootno;
	// 	this.pdepth = pdepth;
	// 	this.porder = porder;
	// }
	
}


