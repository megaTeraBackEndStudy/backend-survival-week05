package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CreatePostService;
import kr.megaptera.assignment.application.DeletePostService;
import kr.megaptera.assignment.application.GetPostService;
import kr.megaptera.assignment.application.UpdatePostService;
import kr.megaptera.assignment.dtos.PostCreateRequestDto;
import kr.megaptera.assignment.dtos.PostResponseDto;
import kr.megaptera.assignment.dtos.PostUpdateRequestDto;
import kr.megaptera.assignment.exceptions.PostNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
  private final UpdatePostService updatePostService;
  private final GetPostService getPostService;
  private final CreatePostService createPostService;
  private final DeletePostService deletePostService;
  @GetMapping
  public List<PostResponseDto> getList(){
    return getPostService.getList();
  }

  @GetMapping("/{id}")
  public PostResponseDto detail(@PathVariable("id")String id){
    return getPostService.detail(id);
  }
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PostResponseDto create(@RequestBody PostCreateRequestDto request){
    return createPostService.createPost(request);
  }

  @PatchMapping("/{id}")
  public PostResponseDto updatePost(@PathVariable("id") String id,@RequestBody PostUpdateRequestDto request){
    return updatePostService.updatePost(id,request);
  }
  @DeleteMapping("/{id}")
  public PostResponseDto deletePost(@PathVariable("id")String id){
    return deletePostService.deletePost(id);
  }

  @ExceptionHandler(PostNotFound.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String postNotFound() {
    return "게시물을 찾을 수 없습니다";
  }

}
