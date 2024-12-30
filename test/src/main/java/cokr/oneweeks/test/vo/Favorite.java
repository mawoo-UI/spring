package cokr.oneweeks.test.vo;

import java.util.Date;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Favorite {
	private Long cbno;
	private String memberId;
	private Date regdate;
}
