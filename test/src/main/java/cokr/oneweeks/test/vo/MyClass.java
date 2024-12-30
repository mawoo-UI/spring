package cokr.oneweeks.test.vo;

import java.util.Date;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyClass {
	private Long ccno;
	private String id;
	private boolean participation;
	private Date regdate;
}
