package cokr.oneweeks.guestbook.domain.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.*;

@Getter
@Setter
@ToString(exclude = "dtoList")
public class PageResultDto<D, E> {
  private List<D> dtoList;

  private int totalPage;
  private int page, size;
  private int start, end;
  private boolean prev, next;

  private List<Integer> pageList;

  public PageResultDto(Page<E> result, Function<E, D> fn) {
    dtoList = result.stream().map(fn).toList();
    totalPage = result.getTotalPages();

    Pageable pageable = result.getPageable();
    page = pageable.getPageNumber() + 1;
    size = pageable.getPageSize();

    int tempEnd = (int)(Math.ceil(page / 10.0)) * 10;
    start = tempEnd - 9;
    prev = start > 1;

    end = totalPage > tempEnd ? tempEnd : totalPage;
    next = totalPage > tempEnd;

    pageList = IntStream.rangeClosed(start, end).boxed().toList();
  }
}
