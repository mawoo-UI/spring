package cokr.oneweeks.club.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cokr.oneweeks.club.entity.Likes;
import cokr.oneweeks.club.entity.Member;
import cokr.oneweeks.club.entity.Note;
import cokr.oneweeks.club.entity.dto.LikesDto;
import cokr.oneweeks.club.repository.MemberRepository;
import cokr.oneweeks.club.repository.NoteRepository;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class LikesServiceTests {
  @Autowired
  LikesService service;
  LikesDto dto = LikesDto.builder().mno(100L).num(1L).build();

  @Autowired
  private MemberRepository memberRepository;

  @Autowired
  private NoteRepository noteRepository;

  @Test
  public void testGet() {
    log.info(service.get(dto));
  }


  @Test
  public void testTogg() {
    
    service.toggle(dto);
    log.info(dto);

  }
  @Test 
  public void testInsertDummy() {
    List<Long> mnos = new ArrayList<> (memberRepository.findAll().stream().map(Member::getMno).toList());
    List<Long> nums = new ArrayList<> (noteRepository.findAll().stream().map(Note::getNum).toList());

    List<LikesDto> likesDtos = new ArrayList<>();
    Collections.shuffle(mnos);
    Collections.shuffle(nums);
    
    // mnos.subList(0,(int)(mnos.size() * 2));

    for(int i = 0; i < mnos.size(); i++){
      for(int j = 0; j < nums.size(); j++){
        likesDtos.add(LikesDto.builder().mno(mnos.get(i)).num(nums.get(j)).build());

      }
    }
    log.info(likesDtos.size());

    likesDtos = likesDtos.subList(0,likesDtos.size() / 5);

    log.info(likesDtos.size());

    likesDtos.forEach(dto -> service.toggle(dto));
  }

  
}
