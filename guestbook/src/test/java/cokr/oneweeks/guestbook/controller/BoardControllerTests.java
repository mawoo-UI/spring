package cokr.oneweeks.guestbook.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

// @WebMvcTest(BoardController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BoardControllerTests {
  @Autowired
  private MockMvc mockMvc;

  // @BeforeEach
  // public void init(WebApplicationContext ctx) {
  //   mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
  // }

  @Test
  public void testTest() throws Exception{
    mockMvc.perform(get("/api/v1/board/test"))
    .andExpect(status().isOk())
    .andExpect(content().string("test"));
  }

  @Test
  public void testList() throws Exception{
    mockMvc.perform(get("/api/v1/board/list")
    .param("page", "3")
    .param("size", "5")
    .param("type", "T,C")
    .param("keyword", "8")
    )
    .andExpect(status().isOk())
    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
  }

  @Test
  public void testRegister() throws Exception{
    String str = "{\r\n" + //
            "    \"memberEmail\": \"user89@a.com\",\r\n" + //
            "    \"content\": \"postman test!!!!1\",\r\n" + //
            "    \"title\" : \"postman write test\"\r\n" + //
            "}";
    mockMvc.perform(post("/api/v1/board/write")
      .content(str)
      .contentType(MediaType.APPLICATION_JSON_VALUE)
    ).andDo(print());
  }
}
