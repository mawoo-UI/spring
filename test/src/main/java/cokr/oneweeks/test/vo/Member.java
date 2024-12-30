package cokr.oneweeks.test.vo;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
// import utils.CookieDateFormat;

@Data
@Builder()
@ToString
public class Member {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String tel;
	@CookieDateFormat(value = "")
	private Date birth;
	private String addr;
	private String detail_addr;
	
	@CookieDateFormat("yyyy-MM-dd HH:mm:ss")
	private Date regdate;
	private Date updatedate;
	private boolean black_list;
	private boolean admin;
	private boolean email_check;
	private boolean marketing_agree;
	private String nick;
	
	
	public static void main(String[] args) {
		Member m = Member.builder().build();
		System.out.println(m);
		Member[] members = {};
		
		int[] arr = {1,2,3,4};
	}
}
