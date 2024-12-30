package cokr.oneweeks.test.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Attach {
	private String uuid;
	private String origin;
	private String path;
	private boolean image;
	private Long pno;
	private Long cbno;
	private Long reno;
	
	public Attach(String uuid, String origin, String path, boolean image, Long cbno) {
		super();
		this.uuid = uuid;
		this.origin = origin;
		this.path = path;
		this.image = image;
		this.cbno = cbno;
	}
	
	public Attach(String uuid, String origin, String path, boolean image, Long reno, Long cbno) {
		super();
		this.uuid = uuid;
		this.origin = origin;
		this.path = path;
		this.image = image;
		this.reno = reno;
		this.cbno = cbno;
	}
	
	
}
