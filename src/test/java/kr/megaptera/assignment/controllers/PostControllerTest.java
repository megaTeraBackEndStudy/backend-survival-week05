package kr.megaptera.assignment.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.megaptera.assignment.application.CreatePostService;
import kr.megaptera.assignment.application.DeletePostService;
import kr.megaptera.assignment.application.GetPostService;
import kr.megaptera.assignment.application.UpdatePostService;
import kr.megaptera.assignment.dtos.PostCreateRequestDto;
import kr.megaptera.assignment.dtos.PostResponseDto;
import kr.megaptera.assignment.dtos.PostUpdateRequestDto;
import kr.megaptera.assignment.exceptions.PostNotFound;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PostController.class)
class PostControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  GetPostService getPostService;
  @MockBean
  CreatePostService createPostService;
  @MockBean
  UpdatePostService updatePostService;
  @MockBean
  DeletePostService deletePostService;

  ObjectMapper objectMapper = new ObjectMapper();

  @Test
  @DisplayName("GET /posts")
  void list() throws Exception {
    given(getPostService.getList()).willReturn(
        List.of(new PostResponseDto("1234", "제목1", "작성자1", "내용1"),
            new PostResponseDto("12345", "제목2", "작성자2", "내용2")));

    this.mockMvc.perform(get("/posts")).andExpect(status().isOk())
        .andExpect(content().string(containsString("제목")));

  }

  @Test
  @DisplayName("GET /posts/{id} - with correct ID")
  void detailWithCorrectId() throws Exception {
    String id = "1234";
    given(getPostService.detail(id)).willReturn(new PostResponseDto(id, "제목", "작성자", "내용"));
    mockMvc.perform(get("/posts/" + id)).andExpect(status().isOk())
        .andExpect(content().string(containsString("제목")));

  }

  @Test
  @DisplayName("GET /posts/{id} - with incorrect ID")
  void detail() throws Exception {
    String id = "1234";
    given(getPostService.detail(id)).willThrow(new PostNotFound());
    mockMvc.perform(get("/posts/" + id)).andExpect(status().isNotFound());
  }

  @Test
  @DisplayName("POST /posts")
  void create() throws Exception {
    PostCreateRequestDto request = new PostCreateRequestDto("title", "content", "author");

    String json = objectMapper.writeValueAsString(request);
    mockMvc.perform(post("/posts").contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isCreated());
    verify(createPostService).createPost(any(PostCreateRequestDto.class));
  }

  @Test
  @DisplayName("PATCH /posts/{id}")
  void update() throws Exception {
    String id = "1234";
    PostUpdateRequestDto request = new PostUpdateRequestDto("fixTitle", "fixContent");
    String json = objectMapper.writeValueAsString(request);
    mockMvc.perform(patch("/posts/" + id).contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isOk());

    verify(updatePostService).updatePost(eq(id), any(PostUpdateRequestDto.class));

  }

  @Test
  @DisplayName("DELETE /posts/{id}")
  void deletePost() throws Exception {
    String id = "1234";
    mockMvc.perform(delete("/posts/" + id)).andExpect(status().isOk());
    verify(deletePostService).deletePost(id);
  }
}
