package cokr.oneweeks.test.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BoardCategory {


	private Integer cno;
	private String cname;
	private Date regdate;
	
}
