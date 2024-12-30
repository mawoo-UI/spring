package cokr.oneweeks.test.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {
	private Long reno;
	private String content;
	private String writer;
	private int score;
	private Date regdate;
	private Date updatedate;
	private Long ccno;
	
	@Builder.Default
	private List<Attach> attachs = new ArrayList<Attach>();
	public Review(Long reno, String content, String writer, int score, Date regdate, Date updatedate, Long ccno) {
		super();
		this.reno = reno;
		this.content = content;
		this.writer = writer;
		this.score = score;
		this.regdate = regdate;
		this.updatedate = updatedate;
		this.ccno = ccno;
	}
	
	
}
