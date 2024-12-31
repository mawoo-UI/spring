package cokr.oneweeks.guestbook.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.web.context.WebApplicationContext;


import cokr.oneweeks.guestbook.Controller.BoardController;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

// @WebMvcTest(BoardController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BoardControllerTests {
  // mock(초안)
  @Autowired
  private MockMvc mockMvc;

  // @BeforeEach
  // public void init (WebApplicationContext ctx) {
  //   mockMvc = MockMvcBuilder.WebApplicationContext(ctx).build();
  // }

  @Test
  public void testTest() throws Exception {
    mockMvc.perform(get("/api/v1/board/test")) //  //문자열도 인식함/
    .andExpect(status().isOk())
    .andExpect(content().string("test"));
  }
  @Test
  public void testList() throws Exception {
    mockMvc.perform(get("/api/v1/board/test")
    .param("page", "1")
    .param("size", "5")
    .param("type", "TC")
    .param("keyword", "8")
    )
    .andExpect(status().isOk())
    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
  }
  @Test
  public void testRegister() throws Exception {
    String jsonStr = " " + //
    "{\r\n" + //
    "{\r\n}" +//
    "   \"title\" : \"포스트맨 글등록\",\r\n" + //    
    "   \"content\" : \"등록\",\r\n" + //
    "   \"memberEmail\" : \"a@b.c\"\r\n" + //
    "}";
    mockMvc.perform(post("api/v1/board/")
    .content(jsonStr)
    .contentType(MediaType.APPLICATION_JSON_VALUE));
    // ).andDo((print()));
  }

}
