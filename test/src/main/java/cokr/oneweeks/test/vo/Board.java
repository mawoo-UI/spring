package cokr.oneweeks.test.vo;
//import java.sql.Date;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Board {

	private Long pno; 
	private String title;
	private String content;
	private String writer;
	private Long likes;
	private Long viewCount;
	private Date regdate;
	private Date updatedate;
	private int cno;
//	private boolean attachFlag;
	
	@Builder.Default
	private List<Attach> attachs = new ArrayList<Attach>();
	public Board(Long pno, String title, String content, String writer, Long likes, Long viewCount, Date regdate,
			Date updatedate, int cno) {
		super();
		this.pno = pno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.likes = likes;
		this.viewCount = viewCount;
		this.regdate = regdate;
		this.updatedate = updatedate;
		this.cno = cno;
	}
	

	
}
