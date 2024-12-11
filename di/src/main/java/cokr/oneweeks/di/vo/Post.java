package cokr.oneweeks.di.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// java.util.Date 1.0 >> 밀레니얼 이슈
// java.util.Calendar 1.1 >> 시간대 이슈 Locale(지역 시간대오차가있음), ns 이슈
// java.util.LocalDateTime 1.8
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Long pno;
    private String title;
    private String writer;
    private LocalDateTime regdate;

   
}
