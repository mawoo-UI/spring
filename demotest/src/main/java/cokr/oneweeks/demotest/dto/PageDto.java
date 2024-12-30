package cokr.oneweeks.demotest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

//주로 화면에서 많이 사용됨
//dao는 데이터 베이스에서 많이사용됨
@Data
@AllArgsConstructor
public class PageDto {
	private Criteria cri;
	private int total; // 게시글 총량
	// 시작번호와 끝번호 필요
	private int startPage;// 페이지 버튼 시작 번호
	private int endPage;// 페이지 버튼 종료 번호

	private int pageCount = 10;// 페이지 버튼 갯수

	//이전 이후 계산용 필드
	private boolean prev;
	private boolean next;
	private boolean doublePrev;
	private boolean doubleNext;
	
	// start 1~ end 10 수식 만들기

	public PageDto(int total) {
		this(new Criteria(), total);
	}

	public PageDto(Criteria cri, int total) {
		this(cri, total, 10);

	}

	public PageDto(Criteria cri, int total, int pageCount) {
		this.cri = cri;
		this.total = total;
		this.pageCount = pageCount;
		endPage = (cri.getPage() + pageCount - 1) / pageCount * pageCount;
		startPage = endPage - pageCount + 1;
//		변수값은 여기서 관리/

		int realEnd = (total + cri.getAmount() - 1) / cri.getAmount();

//		page start end
//		1		1	10
//		2		2	10
//		3		3	10
//		4		4	10
//		11		11	20
		if (realEnd < endPage) {
			endPage = realEnd;
		}
		//
		prev = cri.getPage() > 1;
		next = cri.getPage() < realEnd;
		doublePrev = startPage > 1;
		doubleNext = endPage < realEnd;
	}

	public static void main(String[] args) {
		PageDto dto = new PageDto(225);// new Criteria(12,10), 123
		System.out.println(dto);
	}

}
