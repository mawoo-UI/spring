package cokr.oneweeks.member_post.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cokr.oneweeks.member_post.dto.ReplyCri;
import cokr.oneweeks.member_post.service.ReplyService;
import cokr.oneweeks.member_post.vo.Member;
import cokr.oneweeks.member_post.vo.Reply;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("reply")
@Log4j2
@AllArgsConstructor
public class ReplyController {
  private ReplyService service;
  //목록 조회
  @GetMapping({"list/{pno}","list/{pno}/{lastRno}","list/{pno}/{lastRno}/{amount}"})
  public Map<?,?> list(@SessionAttribute(required = false, name = "member") Member member,
    @PathVariable("pno") Long pno, ReplyCri cri,@PathVariable(required = false, name = "lastRno") Optional<Long> lastRno,
    @PathVariable(required =  false, name = "amount") Optional<Integer> amount) {
        cri.setAmount(amount.orElseGet(() -> 10));
        cri.setLastRno(lastRno.orElse(0L));
        log.info(cri);
        return service.list(pno, cri, member);
    }
  //Optional/. 만 찍으면 조건식 직접 만들 수 있음(get사용)
  //Or else라는게 있고, null인경우 or else안에있는값을 대체값으로 사용
  //notnull일 경우 값을 그대로 쓴다.

  
  //단일 조회
  @Operation(summary = "reply single select", description = "@PathVariable인 rno값을 입력 받고 해당 댓글을 json으로 리턴")
  @GetMapping("{rno}")
  public ResponseEntity<?> getMethodName(@PathVariable("rno") Long rno) {
      return new ResponseEntity<>(service.findBy(rno),HttpStatus.OK);
  }
  
  //등록
  @PostMapping
  @Operation(summary = "댓글 작성", description = "댓글 작성을위해 필요한 값을 전달 받음. content,writer,게시글 번호",
    responses = {
      @ApiResponse(responseCode = "200", description = "작성성공", content = @Content(schema = @Schema(implementation = String.class))),
      @ApiResponse(responseCode = "500", description = "작성실패")
    }
  )
  public ResponseEntity<?> write(@RequestBody Reply reply) {
    log.info(reply);
    return service.write(reply) > 0 ? ResponseEntity.ok().body("success") : ResponseEntity.internalServerError().build();
  }
  //수정
  @PutMapping
  public ResponseEntity<?> modify (@RequestBody Reply reply) {
      service.modify(reply);
      return ResponseEntity.ok().body("success");
  }
  
  //삭제
  @Delete("{rno}")
  public ResponseEntity<?> remove(@RequestParam Long rno) {
      return ResponseEntity.ok().body("success");
  }
  
}
