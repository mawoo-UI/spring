package cokr.oneweeks.demotest.dto;

import java.lang.reflect.Field;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.servlet.http.HttpServletRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Criteria {
	private int page = 1; //처음 보여주는 페이지
	private int amount = 10; //게시물 갯수
	private int category = 2; //게시물 조회(페이지 관여)
	private String type;
	private String keyword;
	
	
	
	public int getOffset() {
		return (page - 1) * 10;
	}
	
	// request 분석 후 필드 초기화
	public Criteria (HttpServletRequest req) {
		if(req == null) return;
		
		Field[] fields = getClass().getDeclaredFields();
		for (Field field : fields ) {
			String tmp = req.getParameter(field.getName());
			if(tmp != null && !tmp.equals("")) {
				try {
					Object obj = tmp;
					if(field.getType() == int.class) {
						obj = Integer.parseInt(tmp);
					}
					field.set(this, obj);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//quertString 문자열 생성 (el에서 사용될 예정)
	
	//page 포함
	public String getQs2() {
		return "page="+page+"&"+getQs();
	}
	
	//page 비포함
	public String getQs( ) {
		Field[] fields = getClass().getDeclaredFields();
		String[] strs = new String[4];
		Stream.of(fields).filter(f->!f.getName().equals("page")).map(f-> {
			String r = null;
			try {
					r = f.getName() + "=" + (f.get(this) == null ? "" : f.get(this));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			return r;
			
		}).collect(Collectors.toList()).toArray(strs);
		return String.join("&", strs);
	}
	public String[] getTypeArr() {
		return type.split("");
	}
}
