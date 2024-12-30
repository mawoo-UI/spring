package cokr.oneweeks.test.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardClass {
	private Long cbno;
	private String title;
	private String content;
	private String host;
	private Long viewCount;
	private Date regdate;
	private Date updatedate;
	private boolean end;
	private int accept;
	private int max;
	private int price;
	private String location;
	private String dutime;

	private double avgStar;

//	@Builder.Default
	private List<Attach> attachs = new ArrayList<Attach>();

	public BoardClass(Long cbno, String title, String content, String host, Long viewCount, Date regdate,
			Date updatedate, boolean end, int accept, int max, int price, String location, String dutime,
			double avgStar) {
		super();
		this.cbno = cbno;
		this.title = title;
		this.content = content;
		this.host = host;
		this.viewCount = viewCount;
		this.regdate = regdate;
		this.updatedate = updatedate;
		this.end = end;
		this.accept = accept;
		this.max = max;
		this.price = price;
		this.location = location;
		this.dutime = dutime;
		this.avgStar = avgStar;
	}

}
