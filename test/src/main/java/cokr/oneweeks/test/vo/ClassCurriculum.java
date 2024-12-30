package cokr.oneweeks.test.vo;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassCurriculum {
	private Long ccno;
	private String lname;
	private String host;
	// @CookieDateFormat
	private Date startdate;
	private Date regdate;
	private int max;
	private int price;
	private String location;
	private Long cbno;
	private String dutime;
	
	private double avgStar;
}
