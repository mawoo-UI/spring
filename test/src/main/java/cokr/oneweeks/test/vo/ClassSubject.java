package cokr.oneweeks.test.vo;

import java.util.Date;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassSubject {
	private Long sno;
	private String sname;
	private int maxEntry;
	private int price;
	private String location;
	private Date regdate;
	private Date updatedate;
	private String starter;
	private String dutime;
}
