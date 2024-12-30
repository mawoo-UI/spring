package cokr.oneweeks.test.vo;

import java.util.Date;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassReg {
	private Long regno;
	private String content;
	private String nickname;
	private String tel;
	private String writer;
	private Long ccno;
	private boolean accept;
	private Date regdate;
}
